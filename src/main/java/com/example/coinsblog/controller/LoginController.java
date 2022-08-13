package com.example.coinsblog.controller;

import com.example.coinsblog.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Value("${console.password}")
    String confirgNumber;

    @Autowired
    IconService iconService = new IconService();

    @GetMapping("/in")
    String loginIn(){
        return "login";
    }

    @GetMapping("/rec")
    String loginRec(@RequestParam("password") String password,
                    Model model,
                    HttpSession session){
        if(password.equals(confirgNumber)){
            session.setAttribute("loginUser","myself");
            return "redirect:/manage/index";
        }else{
            model.addAttribute("msg","通行码错误");
            return "/login";
        }
    }
}
