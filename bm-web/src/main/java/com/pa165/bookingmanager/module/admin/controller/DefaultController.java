package com.pa165.bookingmanager.module.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("adminDefaultController")
@RequestMapping(value = "/admin")
public class DefaultController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "modules/admin/default/index";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings(ModelMap model) {
        return "modules/admin/default/settings";
    }
}