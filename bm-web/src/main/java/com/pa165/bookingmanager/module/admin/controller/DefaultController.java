package com.pa165.bookingmanager.module.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jakub Polak
 */
@Controller("adminDefaultController")
@RequestMapping(value = "/admin")
public class DefaultController
{
    /**
     * Index
     *
     * @return redirect to /admin/hotel/list-of-hotels
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "redirect:/admin/hotel/list-of-hotels";
    }

    /**
     * Change language
     *
     * @param lang lang
     * @return redirect to /admin
     */
    @RequestMapping(value = "/{lang}/change-language", method = RequestMethod.GET)
    public String changeLanguage(@PathVariable String lang){
        return "redirect:/admin";
    }
}