package com.example.coinsblog.controller;

import com.example.coinsblog.service.AlyService;
import com.example.coinsblog.service.HoleService;
import com.example.coinsblog.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class indexController {
    @Autowired
    IconService iconService = new IconService();
    @Autowired
    AlyService alyService = new AlyService();
    @Autowired
    HoleService holeService = new HoleService();

    @GetMapping("/")
    String welcome(Device device){
        alyService.DeviceFilter(device);
        return "redirect:/index";
    }

    @GetMapping("/index")
    String indexPage(Model model){
        model.addAttribute("icons",iconService.getAllIcons());
        model.addAttribute("total",alyService.getTotalAmount());
        model.addAttribute("mobile",alyService.getMobileAmount());
        model.addAttribute("pc",alyService.getPCAmount());
        model.addAttribute("tablets",alyService.getTabletAmount());
        model.addAttribute("other",alyService.getOtherAmount());
        model.addAttribute("holes",holeService.getHoles());
        return "index.html";
    }

    @GetMapping("search/whole")
    String searchPage(@RequestParam(value = "query") String content){
        return content;
    }


}
