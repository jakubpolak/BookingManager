package com.pa165.bookingmanager.controller;

import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jan Hrubeš
 */

@Controller("userRestController")
@RequestMapping(value = "/user")
public class UserRestController extends GenericRestController {
                                                                                                     
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto get(@PathVariable(value = "userId") Long userId) {
        return userService.find(userId);
    }

    @RequestMapping(value="create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto create(@RequestBody UserDto user) {
        userService.create(user);
        return user;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public void update(UserDto user) {
        userService.update(user);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("userId") Long userId) {
        UserDto user = userService.find(userId);

        if (user != null) {
            userService.delete(user);
        }
    }

}
