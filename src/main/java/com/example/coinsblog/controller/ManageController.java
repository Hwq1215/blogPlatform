package com.example.coinsblog.controller;

import cn.hutool.core.date.DateUtil;
import com.example.coinsblog.pojo.Hole;
import com.example.coinsblog.service.DocService;
import com.example.coinsblog.service.HoleService;
import com.example.coinsblog.service.IconService;
import javafx.scene.input.DataFormat;
import org.attoparser.trace.MarkupTraceEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Controller
@CrossOrigin
@RequestMapping("/manage")
public class ManageController {
    @Value("${doc.url}")
    private String docUrl;

    @Autowired
    IconService iconService = new IconService();

    @Autowired
    DocService docService = new DocService();

    @Autowired
    HoleService holeService = new HoleService();
    @GetMapping("/index")
    public String managePage(Model model,HttpSession session){
        model.addAttribute("docUrl",docUrl);
        model.addAttribute("icons",iconService.getAllIcons());
        model.addAttribute("docs",docService.getAllDoc());
        model.addAttribute("holes",holeService.getHoles());
        return "manage/blogManager";
    }

    @GetMapping("/login/out")
    public String loginIn(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/hole/update")
    public String holeEdit(@RequestParam("id") int id,
                           @RequestParam("content") String content,
                           @RequestParam("timestamp") String timestampStr,
                           @RequestParam("status") int status,
                           @RequestParam("url") String url){
        timestampStr = timestampStr.replace("T"," ");
        Timestamp timestamp = Timestamp.valueOf(timestampStr);
        System.out.println(timestampStr.lastIndexOf(':'));
        holeService.updateHole(new Hole(id,content,timestamp,status,url));
        return "redirect:/manage/index";
    }

    @GetMapping("/hole/add")
    public String holeAdder(@RequestParam("id") int id,
                            @RequestParam("content") String content,
                            @RequestParam("timestamp") String timestampStr,
                            @RequestParam("status") int status,
                            @RequestParam("url") String url){
        timestampStr = timestampStr.replace("T"," ");
        if(timestampStr.lastIndexOf(':')!=16){
            timestampStr = timestampStr + ":00";
        }
        Timestamp timestamp = Timestamp.valueOf(timestampStr);
        holeService.addHole(new Hole(id,content,timestamp,status,url));
        return "redirect:/manage/index";
    }

    @GetMapping("hole/delete/{id}")
    public String holeDeleter(@PathVariable("id") Integer id){
        holeService.delHole(id);
        return "redirect:/manage/index";
    }

    @PostMapping("icon/add")
    public String addIcon(@RequestParam("newiconName") String iconName,
                          @RequestParam("newiconImg") MultipartFile img,
                          @RequestParam("newiconUrlPath") String urlPath,
                          @RequestParam("newiconClass") String htmlClass
                          ){
        iconService.addIcon(iconName,img,urlPath,htmlClass);
        return "redirect:/manage/index";
    }

    @PostMapping("doc/add")
    public String addDoc(@RequestParam("newdocName") String name,
                         @RequestParam("newdocUrlPath") String url
                          ){
        docService.addDoc(name, url);
        return "redirect:/manage/index";
    }


    @GetMapping("icon/delete/{iconName}")
    public String deleteIcon(@PathVariable("iconName") String iconName){
        iconService.deleteIcon(iconName);
        return "redirect:/manage/index";
    }

    @GetMapping("doc/delete/{name}")
    public String deleteDoc(@PathVariable("name") String name){
        docService.deleteDoc(name);
        return "redirect:/manage/index";
    }
}
