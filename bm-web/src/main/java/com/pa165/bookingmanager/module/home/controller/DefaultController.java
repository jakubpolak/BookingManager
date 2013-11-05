package com.pa165.bookingmanager.module.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("homeDefaultController")
@RequestMapping(value = "/")
public class DefaultController
{
    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "modules/home/default/index";
    }
}