package com.jkf.channel.gateway.channel;

import cn.hutool.core.lang.TypeReference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.configuration.BusinessConfig;
import com.jkf.channel.gateway.constant.ChannelCode;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.dao.*;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.service.ChannelProService;
import com.jkf.channel.gateway.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author xiangyu
 * @date 2023/11/20 18:17
 */
@Service
@Slf4j
public class HyServiceImpl implements IHyService {

    @Resource
    private ChannelInfoMapper channelInfoMapper;
    @Resource
    private ChannelMchRouteMapper channelMchRouteMapper;
    @Resource
    private BankSubInfoMapper bankSubInfoMapper;
    @Resource
    private AreaHyMapper areaHyMapper;
    @Resource
    private ChannelMchtHyMapper channelMchtHyMapper;
    @Autowired
    private ChannelProService channelProService;
    @Resource
    private SysConfigMapper sysConfigMapper;


    private JSONObject buildFqParam(JSONObject param) {
        JSONObject fqParam = new JSONObject();
        fqParam.put("mchName", param.getString("mchName"));
        fqParam.put("mchShortName", param.getString("mchShortName"));
        String channelName = "D0";
        switch (param.getString("settleCycle")) {
            case "0":
                channelName = "D0";
                break;
            case "1":
                channelName = "T1";
                break;
            case "3":
                channelName = "T1";
                break;
        }
        fqParam.put("channelName", channelName);
        String userType = "";
        switch (param.getString("mchtType")) {
            case "1":
                userType = "12";
                break;
            case "2":
                userType = "13";
                break;
            case "3":
                userType = "11";
                break;
        }
        fqParam.put("userType", userType);
        fqParam.put("corTel", param.getString("contactPhone"));
        fqParam.put("contactName", param.getString("contactName"));
        fqParam.put("idNoType", "0");
        fqParam.put("idNo", param.getString("contactCertNo"));
        fqParam.put("contactEmail", param.getString("contactEmail"));
        fqParam.put("issDate", param.getString("contactExpireStart").replaceAll("-", ""));
        if ("2199-12-31".equals(param.getString("contactExpireEnd"))) {
            param.put("contactExpireEnd", "9999-12-31");
        }
        fqParam.put("expiryDate", param.getString("contactExpireEnd").replaceAll("-", ""));
        fqParam.put("province", param.getString("province"));
        fqParam.put("city", param.getString("city"));
        fqParam.put("district", param.getString("district"));
        fqParam.put("address", param.getString("address"));
        if ("1".equals(param.getString("mchtType")) || "2".equals(param.getString("mchtType"))) {
            fqParam.put("businessLicenseNo", param.getString("businessLicense"));
            fqParam.put("businessLicenseIssDate", param.getString("businessExpireStart").replaceAll("-", ""));
            if ("2199-12-31".equals(param.getString("businessExpireEnd"))) {
                param.put("businessExpireEnd", "9999-12-31");
            }
            fqParam.put("businessLicenseExpiryDate", param.getString("businessExpireEnd").replaceAll("-", ""));
        }
        if ("1".equals(param.getString("mchtType"))) {
            fqParam.put("contactTel", param.getString("legalPhone"));
            fqParam.put("scale", param.getString("enterpriseScale"));
            fqParam.put("categoryType", param.getString("enterpriseCategory"));
            fqParam.put("corEmail", param.getString("contactEmail"));
            fqParam.remove("contactEmail");
        }
        return fqParam;
    }


    /**
     * 开户
     *
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> register(JSONObject param) {
        log.info("接收前置发过来的参数:{}", param);
        //查询是否配置了渠道
        List<ChannelInfo> channelInfos = channelInfoMapper.selectChannelByOrgIdAndChannelCompanyNo(param.getLong("orgId"), ChannelCode.HUOYAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelInfos, ErrorCode.PARAM_ERROR.getErrorCode(), "机构未配置分期的渠道");
        ChannelInfo channelInfo = channelInfos.get(0);
        //查询通道的所有属性
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        //查询正在使用的信息
        JSONObject accountInfo = param.getJSONObject("accountInfo");
        String settlementCardNum = accountInfo.getString("settlementCardNum");
        //查询支行是否存在
        if (!StringUtils.isEmpty(settlementCardNum)) {
            BankSubInfo bankSubInfo = bankSubInfoMapper.selectByPrimaryKey(settlementCardNum);
            AssertUtils.customNotNull(bankSubInfo, ErrorCode.PARAM_ERROR.getErrorCode(), "支行不支持");
            accountInfo.put("bankProviceCode", bankSubInfo.getProvinceCode());
            accountInfo.put("bankCityCode", bankSubInfo.getCityCode());
            accountInfo.put("acctOpenBankName", bankSubInfo.getEyeCode());
            if ("无此银行".equals(bankSubInfo.getEyeBankName())) {
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "该银行不支持,请更换一家银行");
            }
        }
        //地区码转换
        AreaHyExample areaHyExample = new AreaHyExample();
        areaHyExample.createCriteria().andIdEqualTo(param.getInteger("proviceCode"));
        List<AreaHy> areaPro = areaHyMapper.selectByExample(areaHyExample);
        AssertUtils.collectIsEmpty(areaPro, ErrorCode.PARAM_ERROR.getErrorCode(), "proviceCode通道不支持");
        String province = areaPro.get(0).getMergeName();
        areaHyExample = new AreaHyExample();
          areaHyExample.createCriteria().andIdEqualTo(param.getInteger("cityCode"));
        List<AreaHy> areaCity = areaHyMapper.selectByExample(areaHyExample);
        AssertUtils.collectIsEmpty(areaCity, ErrorCode.PARAM_ERROR.getErrorCode(), "cityCode通道不支持");
        String city = areaCity.get(0).getMergeName();
        areaHyExample = new AreaHyExample();
        areaHyExample.createCriteria().andIdEqualTo(param.getInteger("countryCode"));
        List<AreaHy> areaCountry = areaHyMapper.selectByExample(areaHyExample);
        AssertUtils.collectIsEmpty(areaCountry, ErrorCode.PARAM_ERROR.getErrorCode(), "countryCode通道不支持");
        String district = areaCountry.get(0).getMergeName();
        param.put("province", province);
        param.put("city", city);
        param.put("district", district);
        ChannelMchRouteExample example = new ChannelMchRouteExample();
        example.createCriteria().andChannelIdEqualTo(channelInfo.getId()).andMchIdEqualTo(param.getLong("mchId"));
        List<ChannelMchRoute> routes = channelMchRouteMapper.selectByExample(example);
        JSONObject fqParam = buildFqParam(param);
        Object object = null;
        JSONObject jsonObject = null;
        String eyeMerno = "";
        ChannelMchtHy channelMchtHy = null;
        try {
            if (routes == null || routes.size() == 0) {
                //新增接口
                Map<String, Object> reqParam = initMerchantStagesHeader(JSONObject.parseObject(fqParam.toJSONString(), new TypeReference<Map<String, String>>() {
                }), proMap);
                log.info("进件报文体：" + reqParam);
                object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/add", reqParam);
                log.info("进件响应信息：" + object);
                jsonObject = JSON.parseObject(String.valueOf(object));
                if (jsonObject.getString("msg") != null && jsonObject.getString("msg").contains("当前商户业务联系人手机号已存在")) {
                    fqParam.put("corTel", getPhoneNo());
                    reqParam = initMerchantStagesHeader(JSONObject.parseObject(fqParam.toJSONString(), new TypeReference<Map<String, String>>() {
                    }), proMap);
                    log.info("进件报文体以替换后的虚拟手机号：" + reqParam);
                    object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/add", reqParam);
                    log.info("进件以替换后的虚拟手机号响应信息：" + object);
                    jsonObject = JSON.parseObject(String.valueOf(object));
                }
                if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code"))) {
                    //成功回更返回信息
                    channelMchtHy = MchtHyUtils.buildMchtHy(fqParam);
                    channelMchtHy.setMchId(param.getLong("mchId"));
                    channelMchtHy.setChannelId(channelInfo.getId());
                    channelMchtHy.setChannelMchtNo(jsonObject.getString("data"));
                    channelMchtHy.setFeeMode("10");
                    channelMchtHy.setStatus("1");
                    channelMchtHy.setCreateId(0L);
                    channelMchtHy.setCreateTime(new Date());
                    channelMchtHyMapper.insert(channelMchtHy);
                    //存入路由
                    ChannelMchRoute route = new ChannelMchRoute();
                    route.setMchId(param.getLong("mchId"));
                    route.setChannelId(channelInfo.getId());
                    route.setChannelMchtNo(jsonObject.getString("data"));
                    route.setChannelOrder(channelInfo.getChannelOrder());
                    route.setCreateTime(new Date());
                    route.setCreateId(0L);
                    channelMchRouteMapper.insertSelective(route);
                    eyeMerno = jsonObject.getString("data");
                } else {
                    log.info("进件失败");
                    return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), jsonObject.getString("msg"));
                }
            } else {
                ChannelMchRoute channelMchRoute = routes.get(0);
                ChannelMchtHyExample channelMchtHyExample = new ChannelMchtHyExample();
                channelMchtHyExample.createCriteria().andMchIdEqualTo(channelMchRoute.getMchId()).andChannelMchtNoEqualTo(channelMchRoute.getChannelMchtNo());
                List<ChannelMchtHy> channelMchtHyList = channelMchtHyMapper.selectByExample(channelMchtHyExample);
                AssertUtils.collectIsEmpty(channelMchtHyList, ErrorCode.PARAM_ERROR.getErrorCode(), "系统信息缺失");
                channelMchtHy = channelMchtHyList.get(0);
                fqParam.put("mchNo", channelMchRoute.getChannelMchtNo());
                fqParam.put("corTel", channelMchtHy.getCorTel());
                //修改接口
                Map<String, Object> reqParam = initMerchantStagesHeader(JSONObject.parseObject(fqParam.toJSONString(), new TypeReference<Map<String, String>>() {
                }), proMap);
                log.info("修改报文体：" + reqParam);
                object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/update", reqParam);
                log.info("修改响应信息：" + object);
                jsonObject = JSON.parseObject(String.valueOf(object));
                if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code"))) {
                    log.info("修改成功");
                    Long id = channelMchtHy.getId();
                    ChannelMchtHy channelMchtHyUpdate = MchtHyUtils.buildMchtHy(fqParam);
//                    channelMchtHy.setStatus("1");
                    channelMchtHyUpdate.setUpdateId(0L);
                    channelMchtHyUpdate.setUpdateTime(new Date());
                    channelMchtHyUpdate.setId(id);
                    channelMchtHyMapper.updateByPrimaryKeySelective(channelMchtHyUpdate);
                    //后面绑定需要
                    eyeMerno = channelMchRoute.getChannelMchtNo();
                } else {
                    log.info("修改失败");
                    return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), jsonObject.getString("msg"));
                }
            }
        } catch (Exception e) {
            log.error("开户系统异常", e);
            return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), "开户失败系统异常");
        }
        //针对企业的,进行图片上传
        //开户绑卡
//开户
        try {
//            param.put("corTel", relColTel);
            if ("3".equals(channelMchtHy.getStatus())) {
                return ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "分期商户开通成功");
            }
            if (StringUtils.isEmpty(param.getJSONObject("accountInfo").getString("acctOpenBankName"))) {
                //通过支行号来获取银行信息
//            params.put("acctOpenBankName", merchantEyeMapper.selectAccompanyingBankCustom(params.getJSONObject("accountInfo").getString("openBankName")));
//                param.put("acctOpenBankName", merchantEyeMapper.selectAccompanyingBankCustomByBankNum(params.getJSONObject("accountInfo").getString("settlementCardNum")));
            }
            if(!StringUtils.isEmpty(param.getJSONObject("accountInfo").getString("bankProviceCode"))){
                areaHyExample = new AreaHyExample();
                areaHyExample.createCriteria().andIdEqualTo(accountInfo.getInteger("bankProviceCode"));
                List<AreaHy> bankProv = areaHyMapper.selectByExample(areaHyExample);
                param.put("acctProvince", bankProv.get(0).getMergeName());
            }
            if(!StringUtils.isEmpty(param.getJSONObject("accountInfo").getString("bankCityCode"))){
                areaHyExample = new AreaHyExample();
                areaHyExample.createCriteria().andIdEqualTo(accountInfo.getInteger("bankCityCode"));
                List<AreaHy> bankCity = areaHyMapper.selectByExample(areaHyExample);
                param.put("acctCity", bankCity.get(0).getMergeName());
            }
            //直接只传入开户行编号就好了
            JSONObject accJson = initMerchantAccounts(param, eyeMerno);
            Map<String, Object> reqParam = initMerchantStagesHeader(JSONObject.parseObject(accJson.toJSONString(), new TypeReference<Map<String, String>>() {
            }), proMap);
            log.info("开户报文体：" + reqParam);
            object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_binding", reqParam);
            log.info("开户响应信息：" + object);
            jsonObject = JSON.parseObject(String.valueOf(object));
            if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code")) && "1".equals(jsonObject.getJSONObject("data").getString("openAccountStatus"))) {
                //TODO 存入开户信息

                channelMchtHy.setAppid(jsonObject.getJSONObject("data").getString("appId"));
                channelMchtHy.setSecret(jsonObject.getJSONObject("data").getString("secret"));
                log.info("保存的信息:{}", JsonUtils.toJson(channelMchtHy));
                if ("1".equals(jsonObject.getJSONObject("data").getString("bindingStatus"))) {
                    channelMchtHy.setStatus("3");
                } else {
                    channelMchtHy.setStatus("4");
                    channelMchtHy.setFailReason(jsonObject.getString("msg"));
                }
                //回更密钥信息
                channelMchtHyMapper.updateByPrimaryKeySelective(channelMchtHy);
                if (!("1".equals(jsonObject.getJSONObject("data").getString("bindingStatus")))) {
                    return ResultUtils.businessResult(ErrorCode.BING_CARD_FAIL.getErrorCode(), "商户绑卡失败");
                }
                //修改分期状态
                //分期开通成功,异步处理
                return ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "开户成功");
            } else {
                if (jsonObject.getJSONObject("data") != null && !StringUtils.isEmpty(jsonObject.getJSONObject("data").getString("appId"))) {
                    //把appid也保存进去
                    try {

                        channelMchtHy.setAppid(jsonObject.getJSONObject("data").getString("appId"));
                        channelMchtHy.setSecret(jsonObject.getJSONObject("data").getString("secret"));
                        channelMchtHy.setStatus("4");
                        channelMchtHy.setFailReason(jsonObject.getString("msg"));
                        log.info("保存的信息:{}", JsonUtils.toJson(channelMchtHy));
                        channelMchtHyMapper.updateByPrimaryKeySelective(channelMchtHy);
                    } catch (Exception e) {
                        log.error("出现异常", e);
                    }
                }
                if (jsonObject.getJSONObject("data") != null) {
                    return ResultUtils.businessResult(ErrorCode.BING_CARD_FAIL.getErrorCode(), jsonObject.getJSONObject("data").getString("resMesg"));
                }
                if (!"0".equals(jsonObject.getString("code"))) {
                    return ResultUtils.businessResult(ErrorCode.BING_CARD_FAIL.getErrorCode(), jsonObject.getString("msg"));
                }
            }
        } catch (Exception e) {
            log.error("开户异常：", e);
            return ResultUtils.businessResult(ErrorCode.BING_CARD_FAIL.getErrorCode(), jsonObject == null ? "绑卡失败" : jsonObject.getString("msg"));
        }
        return ResultUtils.businessResult(ErrorCode.BING_CARD_FAIL.getErrorCode(), jsonObject.getJSONObject("data") == null ? jsonObject.getString("msg") : jsonObject.getJSONObject("data").getString("resMesg"));
    }

    @Override
    public Map<String, Object> edit(JSONObject param) {
        //理论上应该是1对1的关系
        List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByMchtIdAndCompanyCode(param.getLong("mchId"), ChannelCode.HUOYAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelMchRoutes, ErrorCode.PARAM_ERROR.getErrorCode(), "商户未开通分期");
        ChannelMchRoute channelMchRoute = channelMchRoutes.get(0);
        ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchRoute.getChannelId());
        //查询通道的所有属性
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        //地区码转换
        AreaHyExample areaHyExample = new AreaHyExample();
        areaHyExample.createCriteria().andIdEqualTo(param.getInteger("proviceCode"));
        List<AreaHy> areaPro = areaHyMapper.selectByExample(areaHyExample);
        AssertUtils.collectIsEmpty(areaPro, ErrorCode.PARAM_ERROR.getErrorCode(), "proviceCode通道不支持");
        String province = areaPro.get(0).getMergeName();
        areaHyExample = new AreaHyExample();
        areaHyExample.createCriteria().andIdEqualTo(param.getInteger("cityCode"));
        List<AreaHy> areaCity = areaHyMapper.selectByExample(areaHyExample);
        AssertUtils.collectIsEmpty(areaCity, ErrorCode.PARAM_ERROR.getErrorCode(), "cityCode通道不支持");
        String city = areaCity.get(0).getMergeName();
        areaHyExample = new AreaHyExample();
        areaHyExample.createCriteria().andIdEqualTo(param.getInteger("countryCode"));
        List<AreaHy> areaCountry = areaHyMapper.selectByExample(areaHyExample);
        AssertUtils.collectIsEmpty(areaCountry, ErrorCode.PARAM_ERROR.getErrorCode(), "countryCode通道不支持");
        String district = areaCountry.get(0).getMergeName();
        param.put("province", province);
        param.put("city", city);
        param.put("district", district);
        //调用分期的修改接口
        ChannelMchtHyExample channelMchtHyExample = new ChannelMchtHyExample();
        channelMchtHyExample.createCriteria().andMchIdEqualTo(channelMchRoute.getMchId()).andChannelMchtNoEqualTo(channelMchRoute.getChannelMchtNo());
        List<ChannelMchtHy> channelMchtHyList = channelMchtHyMapper.selectByExample(channelMchtHyExample);
        AssertUtils.collectIsEmpty(channelMchtHyList, ErrorCode.PARAM_ERROR.getErrorCode(), "系统信息缺失");
        ChannelMchtHy channelMchtHy = channelMchtHyList.get(0);
        JSONObject fqParam = buildFqParam(param);
        fqParam.put("mchNo", channelMchRoute.getChannelMchtNo());
        fqParam.put("corTel", channelMchtHy.getCorTel());
        //修改接口
        Map<String, Object> reqParam = initMerchantStagesHeader(JSONObject.parseObject(fqParam.toJSONString(), new TypeReference<Map<String, String>>() {
        }), proMap);
        log.info("修改报文体：" + reqParam);
        try {
            Object object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/update", reqParam);
            log.info("修改响应信息：" + object);
            JSONObject jsonObject = JSON.parseObject(String.valueOf(object));
            if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code"))) {
                log.info("修改成功");
                ChannelMchtHy channelMchtHyUpdate = MchtHyUtils.buildMchtHy(fqParam);
                channelMchtHyUpdate.setUpdateId(0L);
                channelMchtHyUpdate.setUpdateTime(new Date());
                channelMchtHyUpdate.setId(channelMchtHy.getId());
                channelMchtHyMapper.updateByPrimaryKeySelective(channelMchtHy);
                //后面绑定需要
                return ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "修改成功");
            } else {
                log.info("修改失败");
                return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), jsonObject.getString("msg"));
            }
        } catch (Exception e) {
            log.error("修改出现异常", e);
            return ResultUtils.businessResult(ErrorCode.EXCEPTION.getErrorCode(), "修改异常");
        }
    }

    @Override
    public Map<String, Object> bindCard(JSONObject param) {
        log.info("绑卡的参数:{}", param);
        List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByMchtIdAndCompanyCode(param.getLong("mchId"), ChannelCode.HUOYAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelMchRoutes, ErrorCode.PARAM_ERROR.getErrorCode(), "商户未开通分期");
        ChannelMchRoute channelMchRoute = channelMchRoutes.get(0);
        ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchRoute.getChannelId());
        //查询通道的所有属性
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        String settlementCardNum = param.getString("settlementCardNum");
        //查询支行是否存在
        if (!StringUtils.isEmpty(settlementCardNum)) {
            BankSubInfo bankSubInfo = bankSubInfoMapper.selectByPrimaryKey(settlementCardNum);
            AssertUtils.customNotNull(bankSubInfo, ErrorCode.PARAM_ERROR.getErrorCode(), "支行不支持");
            param.put("bankProviceCode", bankSubInfo.getProvinceCode());
            param.put("bankCityCode", bankSubInfo.getCityCode());
            param.put("acctOpenBankName", bankSubInfo.getEyeCode());
            if ("无此银行".equals(bankSubInfo.getEyeBankName())) {
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "该银行不支持,请更换一家银行");
            }
        }
        //
        ChannelMchtHyExample channelMchtHyExample = new ChannelMchtHyExample();
        channelMchtHyExample.createCriteria().andMchIdEqualTo(channelMchRoute.getMchId()).andChannelMchtNoEqualTo(channelMchRoute.getChannelMchtNo());
        List<ChannelMchtHy> channelMchtHyList = channelMchtHyMapper.selectByExample(channelMchtHyExample);
        AssertUtils.collectIsEmpty(channelMchtHyList, ErrorCode.PARAM_ERROR.getErrorCode(), "商户分期未开通");
        ChannelMchtHy channelMchtHy = channelMchtHyList.get(0);
        JSONObject accJson = initMerchantAccountsTwo(param, channelMchtHy.getChannelMchtNo());

        //查询绑卡
        Map<String, Object> maps = new HashMap<>();
        maps.put("mchNo", channelMchtHy.getChannelMchtNo());
        log.info("请求的地址:{}", proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_query");
        Map<String, Object> data = initMerchantStagesHeader(maps, proMap);
        log.info("开户查询报文体：" + data);
        Object queryResOne = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_query", data);
        log.info("开户查询响应信息：" + queryResOne);
        JSONObject queryResObjectOne = JSON.parseObject(String.valueOf(queryResOne));
        if ("0".equals(queryResObjectOne.getString("code")) && queryResObjectOne.getJSONObject("data") != null) {
            String bindingStatus = queryResObjectOne.getJSONObject("data").getString("bindingStatus");//绑卡状态: 0-未开始; 1-已完成; 2-处理中; 3-失败
            String openAccountStatus = queryResObjectOne.getJSONObject("data").getString("openAccountStatus");//开户状态: 0-未开始; 1-已完成; 2-处理中; 3-失败
            if ("0".equals(openAccountStatus) || "3".equals(openAccountStatus)) {
                throw new BusinessException(ErrorCode.OPEN_FAIL.getErrorCode(), "该商户请先调用分期开通接口开户");
            }
            //看看绑卡状态
            if ("0".equals(bindingStatus) || "3".equals(bindingStatus)) {
                //开户绑卡
                Map<String, Object> map = initMerchantStagesHeader(JSONObject.parseObject(accJson.toJSONString(), new TypeReference<Map<String, String>>() {
                }), proMap);
                log.info("报文体：" + map);
                Object object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_binding", map);
                log.info("请求的地址:{}", proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_binding");
//        Object object = sendPostRequest(BaseCustom.fireEyeUrl + "api/mchInfoInfo/binding",map);
                log.info("响应信息：" + object);
                JSONObject jsonObject = JSON.parseObject(String.valueOf(object));
                if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code"))) {
                    //存入开户信息
                    ChannelMchtHy hyUpdate = new ChannelMchtHy();
                    hyUpdate.setId(channelMchtHy.getId());
                    hyUpdate.setAppid(jsonObject.getJSONObject("data").getString("appId"));
                    hyUpdate.setSecret(jsonObject.getJSONObject("data").getString("secret"));
                    hyUpdate.setUpdateTime(new Date());
                    hyUpdate.setStatus("3");
                    channelMchtHyMapper.updateByPrimaryKeySelective(hyUpdate);
                    //回更密钥信息
                    if (!("1".equals(jsonObject.getJSONObject("data").getString("bindingStatus")))) {
                        return ResultUtils.businessResult("0097", "商户绑卡失败:" + jsonObject.getJSONObject("data").getString("resMesg"));
                    }
                    //分期开通成功,异步处理
//                    successAfter(params.getString("mchtNumber"));
                    return ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "绑定成功");
                }
            }
        } else {
            //查询返回的失败，可能还没有开户
            //开户绑卡
            Map<String, Object> map = initMerchantStagesHeader(JSONObject.parseObject(accJson.toJSONString(), new TypeReference<Map<String, String>>() {
            }), proMap);
            log.info("报文体：" + map);
            Object object = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_binding", map);
            log.info("请求的地址:{}", proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_binding");
//        Object object = sendPostRequest(BaseCustom.fireEyeUrl + "api/mchInfoInfo/binding",map);
            log.info("响应信息：" + object);
            JSONObject jsonObject = JSON.parseObject(String.valueOf(object));
            if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code"))) {
                //存入开户信息

                //回更密钥信息
                ChannelMchtHy hyUpdate = new ChannelMchtHy();
                hyUpdate.setId(channelMchtHy.getId());
                hyUpdate.setAppid(jsonObject.getJSONObject("data").getString("appId"));
                hyUpdate.setSecret(jsonObject.getJSONObject("data").getString("secret"));
                hyUpdate.setUpdateTime(new Date());
                hyUpdate.setStatus("3");
                channelMchtHyMapper.updateByPrimaryKeySelective(hyUpdate);
                if (!("1".equals(jsonObject.getJSONObject("data").getString("bindingStatus")))) {
                    return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), "商户绑卡失败:" + jsonObject.getJSONObject("data").getString("resMesg"));
                }
//                merchantEyeMapper.updateMerInfoChannelByStatus(params.getString("mchtNumber"));
                //分期开通成功,异步处理
//                successAfter(params.getString("mchtNumber"));
                return ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "绑定成功");
            }
        }
        //开户绑卡失败了,调用单独绑卡接口
        Map<String, Object> map = initMerchantStagesHeader(JSONObject.parseObject(accJson.toJSONString(), new TypeReference<Map<String, String>>() {
        }), proMap);
        //如果已经开户绑卡成功的，只能调用绑卡接口
        //失败了单独绑卡一次
        //{"msg":"重复提交","code":1001,"ok":false}
        //{"msg":"商户开户/绑卡已完成或处理中","code":2,"ok":false}
        log.info("报文体：" + map);
        log.info("请求的地址:{}", proMap.get("fireEyeUrl") + "api/mchInfoInfo/binding");
        Object res = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/binding", map);
        log.info("响应信息：" + res);
        JSONObject jsonObject = JSON.parseObject(String.valueOf(res));
        if ("SUCCESS".equals(jsonObject.getString("msg")) && "0".equals(jsonObject.getString("code"))) {
            try {
                if (StringUtils.isEmpty(channelMchtHy.getAppid())) {
//                    Map<String, Object> maps = new HashMap<>();
                    maps.put("mchNo", channelMchtHy.getChannelMchtNo());
                    log.info("请求的地址:{}", proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_query");
                    Map<String, Object> dataQuery = initMerchantStagesHeader(maps, proMap);
                    log.info("报文体：" + dataQuery);
                    Object queryRes = sendPostRequest(proMap.get("fireEyeUrl") + "api/mchInfoInfo/open_query", dataQuery);
                    log.info("响应信息：" + queryRes);
                    JSONObject queryResObject = JSON.parseObject(String.valueOf(queryRes));
                    if ("0".equals(queryResObject.getString("code")) && queryResObject.getJSONObject("data").getString("appId") != null) {
                        //回更密钥信息
                        ChannelMchtHy hyUpdate = new ChannelMchtHy();
                        hyUpdate.setId(channelMchtHy.getId());
                        hyUpdate.setAppid(queryResObject.getJSONObject("data").getString("appId"));
                        hyUpdate.setSecret(queryResObject.getJSONObject("data").getString("secret"));
                        hyUpdate.setUpdateTime(new Date());
                        channelMchtHyMapper.updateByPrimaryKeySelective(hyUpdate);
                    } else {
                        log.error("查询开户信息失败");
                    }
                }
            } catch (Exception e) {
                log.error("查询出现异常", e);
            }
            //分期开通成功,异步处理
//            successAfter(params.getString("mchtNumber"));
            ChannelMchtHy hyUpdate = new ChannelMchtHy();
            hyUpdate.setUpdateTime(new Date());
            hyUpdate.setStatus("3");
            channelMchtHyMapper.updateByPrimaryKeySelective(hyUpdate);
            return ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "绑定成功");
        } else {
            ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), jsonObject.getString("msg"));
        }
        return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), jsonObject.getString("msg"));
    }

    @Override
    public Map<String, Object> addRess(JSONObject param) {
        List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByMchtIdAndCompanyCode(param.getLong("mchId"), ChannelCode.HUOYAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelMchRoutes, ErrorCode.PARAM_ERROR.getErrorCode(), "商户未开通分期");
        ChannelMchRoute channelMchRoute = channelMchRoutes.get(0);
        ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchRoute.getChannelId());
        //查询通道的所有属性
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        Map<String, Object> maps = new HashMap<>();
        maps.put("mchNo",channelMchRoute.getChannelMchtNo());
        if (!StringUtils.isEmpty(param.getString("address1"))) {
            maps.put("address1", param.getString("address1"));
        }
        if (!StringUtils.isEmpty(param.getString("address2"))) {
            maps.put("address2", param.getString("address2"));
        }
        Map<String, Object> data = initMerchantStagesHeader(maps,proMap);
        log.info("报文体：" + data);
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", ErrorCode.SUCCESS.getErrorCode());
        result.put("resultMsg", "成功");
        try {
            String url = proMap.get("fireEyeUrl")+ "api/mchInfoInfo/add_address";
            log.info("请求的地址:{}", url);
            Object object = sendPostRequest(url, data);
            log.info("响应信息：" + object);
            JSONObject jsonObject = JSON.parseObject(String.valueOf(object));
            if (!"0".equals(jsonObject.getString("code"))) {
                result.put("resultCode", ErrorCode.FAIL.getErrorCode());
                result.put("resultMsg", jsonObject.getString("msg"));
            }
            JSONObject resultData = jsonObject.getJSONObject("data");
            if (resultData != null) {
                result.put("address", resultData.getString("address"));
                result.put("address1", resultData.getString("address1"));
                result.put("address2", resultData.getString("address2"));
                result.put("ad1State", resultData.getString("ad1State"));
                result.put("ad2State", resultData.getString("ad2State"));
            }
            return result;
        } catch (Exception e) {
            log.error("出现异常", e);
            return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), "系统异常");
        }
    }

    @Override
    public Map<String, Object> authToken(JSONObject param) {
        List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByMchtIdAndCompanyCode(param.getLong("mchId"), ChannelCode.HUOYAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelMchRoutes, ErrorCode.PARAM_ERROR.getErrorCode(), "商户未开通分期");
        ChannelMchRoute channelMchRoute = channelMchRoutes.get(0);
        ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchRoute.getChannelId());
        //查询通道的所有属性
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        //调用火眼的接口查询
        Map<String, Object> maps = new HashMap<>();
        maps.put("mchNo", channelMchRoute.getChannelMchtNo());
        maps.put("returnUrl", param.getString("returnUrl"));
        Map<String, Object> data = initMerchantStagesHeader(maps,proMap);
        log.info("报文体：" + data);
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", ErrorCode.SUCCESS.getErrorCode());
        result.put("resultMsg", "成功");
        try {
            String url = proMap.get("fireEyeUrl") + "api/mchInfoInfo/fetch_token";
            log.info("请求的地址:{}", url);
            Object object = sendPostRequest(url, data);
            log.info("响应信息：" + object);
            JSONObject jsonObject = JSON.parseObject(String.valueOf(object));
            if (!"0".equals(jsonObject.getString("code"))) {
                result.put("resultCode", ErrorCode.FAIL.getErrorCode());
                result.put("resultMsg", jsonObject.getString("msg"));
            } else {
                JSONObject jsonObjectData = jsonObject.getJSONObject("data");
                result.put("token", jsonObjectData.getString("token"));
                result.put("captureUrl", jsonObjectData.getString("captureUrl"));
                //认证的token记录下来
            }
            return result;
        } catch (Exception e) {
            log.error("出现异常", e);
            result.put("resultCode", ErrorCode.EXCEPTION.getErrorCode());
            result.put("resultMsg", "系统异常");
            return result;
        }
    }

    @Override
    public Map<String, Object> authTokenQuery(JSONObject param) {
        List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByMchtIdAndCompanyCode(param.getLong("mchId"), ChannelCode.HUOYAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelMchRoutes, ErrorCode.PARAM_ERROR.getErrorCode(), "商户未开通分期");
        ChannelMchRoute channelMchRoute = channelMchRoutes.get(0);
        ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchRoute.getChannelId());
        //查询通道的所有属性
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        Map<String, Object> maps = new HashMap<>();
        maps.put("mchNo", channelMchRoute.getChannelMchtNo());
        maps.put("token", param.getString("token"));
        Map<String, Object> data = initMerchantStagesHeader(maps,proMap);
        log.info("报文体：" + data);
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode",ErrorCode.SUCCESS.getErrorCode());
        result.put("resultMsg", "成功");
        try {
            String url = proMap.get("fireEyeUrl") + "api/mchInfoInfo/live_result";
            log.info("请求的地址:{}", url);
            Object object = sendPostRequest(url, data);
            log.info("响应信息：" + object);
            JSONObject jsonObject = JSON.parseObject(String.valueOf(object));
            if (!"0".equals(jsonObject.getString("code"))) {
                if("4179".equals(jsonObject.getString("code"))){
                    //检测中
                    result.put("resultCode",jsonObject.getString("code"));
                }else {
                    result.put("resultCode", ErrorCode.FAIL.getErrorCode());
                }
                result.put("resultMsg", jsonObject.getString("msg"));
            } else {
                JSONObject jsonObjectData = jsonObject.getJSONObject("data");
                result.put("score", jsonObjectData.getString("score"));
                result.put("h5Result", jsonObjectData.getString("h5Result"));
                result.put("smResult", jsonObjectData.getString("smResult"));
                result.put("rxResult", jsonObjectData.getString("rxResult"));
                result.put("desc", jsonObjectData.getString("desc"));
            }
            return result;
        } catch (Exception e) {
            log.error("出现异常", e);
            result.put("resultCode", ErrorCode.EXCEPTION.getErrorCode());
            result.put("resultMsg", "查询异常");
            return result;
        }
    }

    /**
     * 获取手机号
     *
     * @return
     */
    private String getPhoneNo() {
        String phone = sysConfigMapper.getSeq("phone_no") + "";
        if (phone.length() < (11 - BusinessConfig.phonePrefix.length())) {
            int len = phone.length();
            for (int i = 1; i <= (11 - BusinessConfig.phonePrefix.length() - len); i++) {
                phone = "0" + phone;
            }
        }
        return BusinessConfig.phonePrefix + phone;
    }

    public static JSONObject initMerchantAccounts(JSONObject jsonObject, String eyeMerno) throws Exception {
        JSONObject maps = jsonObject.getJSONObject("accountInfo");
        JSONObject map = new JSONObject();
        map.put("mchNo", eyeMerno);
        map.put("openBankName", maps.getString("acctOpenBankName"));
        map.put("bankAccount", maps.getString("bankAccount"));
        map.put("bankProvince", jsonObject.getString("acctProvince"));
        map.put("bankCity", jsonObject.getString("acctCity"));
        map.put("subBranchName", maps.getString("subBranchName"));
        map.put("settlementCardNum", maps.getString("settlementCardNum"));
        if ("1".equals(jsonObject.getString("mchtType"))) {
            map.put("approvalNo", maps.getString("approvalNo"));
        }
        map.put("contactTel", maps.getString("contactTel"));
        return map;
    }

    public static JSONObject initMerchantAccountsTwo(JSONObject jsonObject, String eyeMerno) {
        JSONObject map = new JSONObject();
        map.put("mchNo", eyeMerno);
        map.put("openBankName", jsonObject.getString("acctOpenBankName"));
        map.put("bankAccount", jsonObject.getString("bankAccount"));
        map.put("bankProvince", jsonObject.getString("acctProvince"));
        map.put("bankCity", jsonObject.getString("acctCity"));
        map.put("subBranchName", jsonObject.getString("subBranchName"));
        map.put("settlementCardNum", jsonObject.getString("settlementCardNum"));
        if (!StringUtils.isEmpty(jsonObject.getString("approvalNo"))) {
            map.put("approvalNo", jsonObject.getString("approvalNo"));
        }
        map.put("contactTel", jsonObject.getString("contactTel"));
        return map;
    }

    /**
     * 火眼商户进件报文组装
     *
     * @param maps
     * @return
     */
    public static Map<String, Object> initMerchantStagesHeader(Map<String, Object> maps, Map<String, String> proMap) {
        Map<String, Object> map = new HashMap<>();
        map.put("appId", proMap.get("channelAppid"));
        log.info("json数据:{}", maps);
        //转 JSON
        String reqParam = JSONObject.toJSONString(maps);
        log.info("json数据:{}", reqParam);
        //做 AES 加密
        reqParam = HpayKit.aesEncode(proMap.get("channelSecret").substring(0, 16), Base64.getEncoder().encodeToString(reqParam.getBytes()));
        //存入 map
        map.put("reqParam", reqParam);
        return map;
    }

    public static Object sendPostRequest(String url, Map<String, Object> param) {
        log.info("请求的地址:{}请求的参数:{}", url, param);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(param, headers);
        //RestTemplate restTemplate = new RestTemplate();
        RestTemplate restTemplate = new RestTemplate();
        String strBody = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
        return JSONObject.parseObject(strBody, Object.class);
    }
}
