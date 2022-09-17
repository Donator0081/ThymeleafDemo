package com.example.thymeleaf_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainDemoController {

    @GetMapping("/hello")
    public String showHelloPage(Model model){
        model.addAttribute("data", new java.util.Date());
        return "hello-world";
    }
}
