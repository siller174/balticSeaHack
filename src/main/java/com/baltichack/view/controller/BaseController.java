package com.baltichack.view.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }


    @RequestMapping("/")
    public String home() {
        return "redirect:/api/event/";
    }
}
