package com.jkf.channel.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.RedisConstants;
import com.jkf.channel.gateway.entity.OrgInfo;
import com.jkf.channel.gateway.entity.RequestLog;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.service.KeyService;
import com.jkf.channel.gateway.service.OrgInfoService;
import com.jkf.channel.gateway.service.OrgPermissionService;
import com.jkf.channel.gateway.utils.JsonUtils;
import com.jkf.channel.gateway.utils.RSAUtil;
import com.jkf.channel.gateway.utils.RedisUtil;
import com.jkf.channel.gateway.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 开方平台的接口的请求签名拦截
 *
 * @author xiangyu
 * @date 2023/10/30 15:36
 */
@Aspect
@Slf4j
@Component
public class OpenSignAspect {
    private static final String VERSION = "1.0";

    private static final String SIGNTYPE = "RSA";
    @Autowired
    private KeyService keyService;
    @Autowired
    private OrgPermissionService orgPermissionService;
    @Autowired
    private OrgInfoService orgInfoService;

    /**
     * 切入点描述 这个是PayController的切入点
     */
    @Pointcut("execution(public * com.jkf.channel.gateway.controller.OpenController.*(..))")
    public void controllerLog() {
    }//签名，可以理解成这个切入点的一个名称

    /**
     * aop日志记录，使用 IsSaveLog 注解记录的不记日志
     *
     * @param proceedingJoinPoint 切入点
     * @return 执行结果
     */
    @Around("controllerLog()")
    public Object controllerLogs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MDC.put(KeyConstants.TRANS_ID, UUID.randomUUID().toString().replaceAll("-",""));
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //得到传递给目标方法的参数值
        Object[] obj = proceedingJoinPoint.getArgs();
        Map<String, Object> map = (Map) obj[0];
        if(map!=null&&map.containsKey("reqId")){
            MDC.put(KeyConstants.TRANS_ID,MDC.get(KeyConstants.TRANS_ID)+"_"+map.get("reqId"));
        }
        log.info("接口请求参数:{}", map);
        String result = "";
        Long sTime=System.currentTimeMillis();
        Date cDate=new Date();
        try {
            result = business(proceedingJoinPoint);
        } catch (Exception e) {
            log.error("出现异常", e);
            result = ResultUtils.publicResult(ErrorCode.EXCEPTION.getErrorCode(), "系统异常");
        }finally {
            Long eTime=System.currentTimeMillis();
            try {
                //将请求日志异步写入数据库中
                RequestLog requestLog=new RequestLog();
                requestLog.setRequestId((String) map.get("reqId"));
                requestLog.setPath(request.getRequestURL().toString()+":"+map.get("method"));
                requestLog.setReqparam(JsonUtils.toJson(map));
                requestLog.setResparam(result);
                requestLog.setWaitTime(eTime-sTime);
                requestLog.setCreateTime(cDate);
                requestLog.setUpdateTime(new Date());
                RedisUtil.zset(RedisConstants.REDIS_KEY_LOG,System.currentTimeMillis(), JsonUtils.toJson(requestLog));
            }catch (Exception e){
                log.error("系统异常",e);
            }
        }
        log.info("接口响应参数:{}", result);
        return result;
    }

    private String business(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] obj = proceedingJoinPoint.getArgs();
        Map<String, Object> map = (Map) obj[0];
        log.info("接口请求参数:{}", map);
        //公共参数校验
        String checkResult = checkPublicValue(map);
        if (!"success".equals(checkResult)) {
            return ResultUtils.publicResult(ErrorCode.PARAM_ERROR.getErrorCode(), checkResult);
        }
        Map<String,Object> result=new HashMap<>();
        try {
            String orgNo = (String) map.get("orgNo");
            String publicKey = keyService.getOrgPublicKey(orgNo);
            if (StringUtils.isEmpty(publicKey)) {
                return ResultUtils.publicResult(ErrorCode.SIGN_FAIL.getErrorCode(), "获取密钥失败");
            }
            //1. 验签
            if (!RSAUtil.verify(map, publicKey)) {
                return ResultUtils.publicResult(ErrorCode.SIGN_FAIL.getErrorCode(), "验证签名失败");
            }
            String reqData = (String) map.get("reqData");
            //获取平台的私钥
            String privateKey = keyService.getPlatPrivateKey(orgNo);
            if (StringUtils.isEmpty(privateKey)) {
                return ResultUtils.publicResult(ErrorCode.SIGN_FAIL.getErrorCode(), "获取密钥失败");
            }
            //2. 解密
            String decryptValue = "";
            try {
                decryptValue = RSAUtil.privateDecrypt(reqData, privateKey);
                log.info("接口解密后的参数:{}", decryptValue);
            } catch (Exception e) {
                log.error("解密失败", e);
                return ResultUtils.publicResult(ErrorCode.FAIL.getErrorCode(), "reqData解密失败");
            }
            JSONObject params = null;
            try {
                params = JSON.parseObject(decryptValue);
            } catch (Exception e) {
                log.error("转换格式失败", e);
                return ResultUtils.publicResult(ErrorCode.FAIL.getErrorCode(), "reqData明文格式非法,请用json格式");
            }
            //3. 验证商户状态
            String method = (String) map.get("method");
            //判断机构是否有权限
            if (!orgPermissionService.validateMethod(orgNo, method)) {
                return ResultUtils.publicResult(ErrorCode.NO_PERMISSION.getErrorCode(), "接口无权限");
            }
            params.put("orgNo", orgNo);
            params.put("method", method);
            obj[0] = params;
            Object res = proceedingJoinPoint.proceed(obj);
            log.info("接口响应的明文参数:{}", res);
            //6.加密
            JSONObject respJson = JSONObject.parseObject((String) res);
            if (respJson != null && respJson.size() > 0) {
                result.put(KeyConstants.CODE, ErrorCode.SUCCESS.getErrorCode());
                result.put(KeyConstants.MSG, "操作成功");
                //使用机构的公钥加密
                result.put("respData", RSAUtil.publicEncrypt(respJson.toJSONString(), publicKey));
                //7.加签,平台的私钥生成签名
                result.put("sign", RSAUtil.sign(result, privateKey));
            } else {
                return ResultUtils.publicResult(ErrorCode.FAIL.getErrorCode(), "请求失败");
            }
        }catch (BusinessException be){
            return ResultUtils.publicResult(be.getCode(), be.getMessage());
        }catch (Exception e) {
            log.error("出现异常",e);
            return ResultUtils.publicResult(ErrorCode.EXCEPTION.getErrorCode(), "系统异常");
        }catch (Throwable t){
            log.error("出现异常",t);
            return ResultUtils.publicResult(ErrorCode.EXCEPTION.getErrorCode(), "系统异常");
        } finally{
            //清除当前线程中的变量

        }
        log.info("接口响应的密文参数:{}", result);
        return JSONObject.toJSONString(result);
    }

    /**
     * 校验公共参数
     *
     * @param map
     * @return
     */
    private  String checkPublicValue(Map<String, Object> map) {
        String orgNo = (String) map.get("orgNo");
        if (StringUtils.isEmpty(orgNo)) {
            return "orgNo为空";
        }
        OrgInfo orgInfo=orgInfoService.getOrgInfoFromCache(orgNo);
        if(orgInfo==null){
            return "机构不存在";
        }
        String reqId = (String) map.get("reqId");
        if (StringUtils.isEmpty(reqId)) {
            return "reqId为空";
        }
        String method = (String) map.get("method");
        if (StringUtils.isEmpty(method)) {
            return "接口名称为空";
        }
        if (StringUtils.isEmpty(map.get("timestamp") + "")) {
            return "交易时间戳为空";
        }
        if (!VERSION.equals(map.get("version") + "")) {
            return "版本号错误";
        }
        if (!SIGNTYPE.equals(map.get("signType") + "")) {
            return "签名类型错误";
        }
        String sign = (String) map.get("sign");
        if (StringUtils.isEmpty(sign)) {
            return "sign为空";
        }
        String reqData = (String) map.get("reqData");
        if (StringUtils.isEmpty(reqData)) {
            return "reqData为空";
        }
        return "success";
    }
}
