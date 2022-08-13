package com.example.coinsblog.service;

import com.example.coinsblog.mapper.AlyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

@Service
public class AlyService {
    @Autowired
    AlyMapper alyMapper;

    public boolean DeviceFilter(Device device){
        if(device.isNormal()){
            addAmount("pc");
        }else if(device.isMobile()){
            addAmount("mobile");
        }else if(device.isTablet()){
            addAmount("tablet");
        }else{
            addAmount("other");
        }
        addAmount("total");
        return true;
    }

    public Integer getTotalAmount(){
        return alyMapper.getValue("total");
    }

    public Integer getPCAmount(){
        return alyMapper.getValue("pc");
    }

    public Integer getMobileAmount(){
        return alyMapper.getValue("mobile");
    }

    public Integer getTabletAmount(){
        return alyMapper.getValue("tablet");
    }

    public Integer getOtherAmount(){
        return alyMapper.getValue("other");
    }

    private void addAmount(String key){
        Integer num = 1 + alyMapper.getValue(key);
        alyMapper.updateValue(key,num);
    }
}
