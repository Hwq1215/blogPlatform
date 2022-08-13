package com.example.coinsblog.controller;

import com.example.coinsblog.mapper.ServicerMapper;
import com.example.coinsblog.pojo.Servicer;
import com.example.coinsblog.service.ServicerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/manage/service")
public class ServicerManageController {

    @Autowired
    ServicerService servicerService = new ServicerService();

    @GetMapping("/index")
    public String serviceManageIndex(Model model){
        model.addAttribute("servicers",servicerService.getAllServicers());
        model.addAttribute("selectservicer", servicerService.searchDefaultServicer().getName());
        return "manage/servicerManager";
    }

    @GetMapping("/index/{name}")
    public String serviceManageIndex(Model model, @PathVariable("name") String name){
        model.addAttribute("servicers",servicerService.getAllServicers());
        model.addAttribute("selectservicer",name);
        return "manage/servicerManager";
    }

    @GetMapping("/delete/{name}")
    public String deleteServicer(@PathVariable("name") String name){
        servicerService.delServicer(name);
        return "redirect:/manage/service/";
    }

    @PostMapping("/add")
    public String addName(@RequestParam("name") String name,
                          @RequestParam("host") String host,
                          @RequestParam("admin") String admin,
                          @RequestParam("password") String password
                          ){
        if(servicerService.addServicer(new Servicer(name,host,admin,password))){
            return "redirect:/manage/service/"+name;
        }
        return "redirect:/manage/service/";
    }
}
