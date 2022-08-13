package com.example.coinsblog.service;

import com.example.coinsblog.components.FileUtils;
import com.example.coinsblog.mapper.IconMapper;
import com.example.coinsblog.pojo.Icon;
import org.apache.ibatis.annotations.Delete;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class IconService {
    @Autowired
    IconMapper iconMapper;

    @Autowired
    FileUtils fileUtils;

    public List<Icon> getAllIcons(){
        return iconMapper.getAllIcons();
    }

    public void deleteIcon(String iconName){
        iconMapper.deleteIcon(iconName);
    }

    public void addIcon(String iconName, MultipartFile img, String urlPath, String htmlClass){
        String resPath = "default.png";
        try {
            resPath = fileUtils.uploadImg(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        iconMapper.addIcon(new Icon(iconName,resPath, urlPath,htmlClass));
    }
}
