package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jakub Polak
 */
//@Controller("adminUserController")
@RequestMapping(value = "/admin/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list-of-users", method = RequestMethod.GET)
    public ModelAndView listOfUsers(){
        ModelAndView modelAndView = new ModelAndView("modules/admin/user/list-of-users");

        return modelAndView;
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ModelAndView createUser(){
        ModelAndView modelAndView = new ModelAndView("modules/admin/user/create-user");

        return modelAndView;
    }

    @RequestMapping(value = "/{userId}/update-user", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable Long userId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/user/update-user");

        return modelAndView;
    }

    @RequestMapping(value = "/{userId}/delete-user", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Long userId){
        return new ModelAndView("redirect:/admin/user/list-of-users");
    }
}
