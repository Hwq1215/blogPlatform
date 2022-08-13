package com.example.coinsblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class ConnectController {
    @GetMapping("/connect")
    String connectPage(){
        return "connect.html";
    }
}
