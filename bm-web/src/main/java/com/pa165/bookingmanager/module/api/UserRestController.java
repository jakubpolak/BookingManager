package com.pa165.bookingmanager.module.api;

import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Jan Hrubeš
 */

@Controller("userRestController")
@RequestMapping(value = "/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getList() {
        return userService.findAll();
    }

    @RequestMapping(value = "/id/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUser(@PathVariable(value = "userId") Long userId) {
        return userService.find(userId);
    }

}
