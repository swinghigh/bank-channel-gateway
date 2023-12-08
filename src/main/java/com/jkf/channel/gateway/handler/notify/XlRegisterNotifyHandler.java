package com.jkf.channel.gateway.handler.notify;

import com.jkf.channel.gateway.constant.BusNotifyEnum;
import com.jkf.channel.gateway.dao.ChannelMchtXlMapper;
import com.jkf.channel.gateway.entity.ChannelMchtXl;
import com.jkf.channel.gateway.entity.ChannelMchtXlExample;
import com.jkf.channel.gateway.handler.IBussNotifyHandler;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 20:28
 */
@Service
public class XlRegisterNotifyHandler  implements IBussNotifyHandler {
    @Resource
    private ChannelMchtXlMapper channelMchtXlMapper;
    @Override
    public String getBusType() {
        return BusNotifyEnum.XL_REGISTER.getBussType();
    }

    @Override
    public void notifyPre(Map<String, Object> busMap) {

    }

    @Override
    public void notifyAfter(Map<String, Object> busMap, String result) {
        //修改通知的状态
        String noftifyResult="";
        if("SUCCESS".equals(result)){
            noftifyResult="1";
        }else{
            //通知失败
            noftifyResult="2";
        }
        ChannelMchtXlExample example=new ChannelMchtXlExample();
        example.createCriteria().andOutApplyIdEqualTo(String.valueOf(busMap.get("outApplyId")))
                .andMchIdEqualTo(Long.parseLong(String.valueOf(busMap.get("mchId"))));
        List<ChannelMchtXl> channelMchtXls= channelMchtXlMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(channelMchtXls)){
            ChannelMchtXl channelMchtXl=channelMchtXls.get(0);
            channelMchtXl.setNotifyFlag(noftifyResult);
            channelMchtXlMapper.updateByPrimaryKeySelective(channelMchtXl);
        }
    }
}
