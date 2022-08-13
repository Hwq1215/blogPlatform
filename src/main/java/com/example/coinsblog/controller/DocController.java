package com.example.coinsblog.controller;

import com.example.coinsblog.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@CrossOrigin
public class DocController {
    @Value("${doc.url}")
    private String docUrl;

    @Autowired
    DocService docService = new DocService();

    @GetMapping("/page/docs")
    String pageAll(Model model){
        model.addAttribute("docUrl",docUrl);
        model.addAttribute("docs",docService.getAllDoc());
        return "docs.html";
    }
}
