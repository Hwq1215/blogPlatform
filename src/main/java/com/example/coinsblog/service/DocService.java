package com.example.coinsblog.service;

import com.example.coinsblog.mapper.DocMapper;
import com.example.coinsblog.pojo.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class DocService {
    @Autowired
    DocMapper docMapper;

    public List<Doc> getAllDoc(){
        return docMapper.getAllDoc();
    }

    public void addDoc(String name,String url){
        docMapper.addDoc(new Doc(name,url));
    }
    public void deleteDoc(String name){
        docMapper.deleteDoc(name);
    }

}
