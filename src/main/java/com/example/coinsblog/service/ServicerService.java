package com.example.coinsblog.service;
import java.util.List;

import com.example.coinsblog.mapper.ServicerMapper;
import com.example.coinsblog.pojo.Servicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicerService {
    @Autowired
    ServicerMapper servicerMapper;

    public List<Servicer> getAllServicers(){
        return servicerMapper.getServicers();
    }

    public Servicer getServicerByName(String name){
        return servicerMapper.getServicerByName(name);
    }

    public boolean addServicer(Servicer servicer){
        if(getServicerByName(servicer.getName())!=null){
            return false;
        }
        servicerMapper.addServicer(servicer);
        return true;
    }

    public void delServicer(String name){
        servicerMapper.deleteServicer(name);
    }

    public Servicer searchDefaultServicer(){
        Servicer servicer = servicerMapper.getServicerByName("undefined");
        if(servicer==null){
            servicer = new Servicer("undefined","127.0.0.1","root","");
        }
        return servicer;
    }
}
