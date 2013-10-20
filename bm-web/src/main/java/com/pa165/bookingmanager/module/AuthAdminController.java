package com.pa165.bookingmanager.module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("authAdminController")
@RequestMapping(value = "/auth-admin")
public class AuthAdminController
{
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String indexAction(){
        return "auth/admin-login";
    }

    @RequestMapping(value = "/login/error", method = RequestMethod.GET)
    public ModelAndView loginInvalidAction(){
        ModelAndView modelAndView = new ModelAndView("auth/admin-login");
        modelAndView.addObject("error", true);

        return modelAndView;
    }
}
