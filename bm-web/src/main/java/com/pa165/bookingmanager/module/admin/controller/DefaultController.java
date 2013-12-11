package com.pa165.bookingmanager.module.admin.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jakub Polak, Jana Polakova
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
    public String index(@RequestHeader(value = "Accept-Language") String lang) {
        // Get current display language
        String displayLanguage = LocaleContextHolder.getLocale().getDisplayLanguage();

        // Change language automatically according to user browser preferences
        // It can be changed manually by calling ?lang=sk or ?lang=en, but it will change back to browser preferences
        // when user comes back to /admin
        if (lang.contains("sk-") && !displayLanguage.equals("Slovak")){
            return "redirect:/admin/hotel/list-of-hotels?lang=sk";
        } else if (lang.contains("en-") && !displayLanguage.equals("English")) {
            return "redirect:/admin/hotel/list-of-hotels?lang=en";
        }

        return "redirect:/admin/hotel/list-of-hotels";
    }
}