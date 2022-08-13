package com.example.coinsblog.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@PropertySource(value = "classpath:application.yaml")
public class FileUtils {
    @Value("${web.upload}"+"img/")
    private String uploadImgPath;

    public String uploadImg(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return "img/default.png";
        }
        final byte[] bytes = file.getBytes();
        String randFileName = UUIDUtils.getUUID();
        int len = file.getOriginalFilename().split("\\.").length;
        String suffix = "";
        if (len > 0) {
            suffix = file.getOriginalFilename().split("\\.")[len - 1];
        }
        final Path path = Paths.get(uploadImgPath + randFileName + "." + suffix);
        System.out.println(path.toString());
        Files.write(path, bytes);
        return "img/" + randFileName + "." + suffix;
    }
}
