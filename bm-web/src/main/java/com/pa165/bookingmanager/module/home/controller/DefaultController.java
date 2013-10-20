package com.pa165.bookingmanager.module.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("homeDefaultController")
@RequestMapping("/")
public class DefaultController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "modules/home/default/index";
    }
}