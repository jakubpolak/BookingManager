package com.pa165.bookingmanager.controller;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.UserRestDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.service.RoleService;
import com.pa165.bookingmanager.service.UserService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDto> getAll() {
        return userService.findAllAndRoles();
    }

    @RequestMapping(value = "roles", method = RequestMethod.GET)
    @ResponseBody
    public List<RoleDto> getRoles() {
        return roleService.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDto get(@PathVariable(value = "userId") Long userId) {
        return userService.find(userId);
    }

    @RequestMapping(value="create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void create(@RequestBody UserRestDto user) {
        // special Dto for rest transfer due to jackson parsing
        UserDto userDto= new UserDtoImpl();
        BeanUtils.copyProperties(user, userDto);

        userService.create(userDto);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("userId") Long userId, @RequestBody UserRestDto user) {
        // special Dto for rest transfer due to jackson parsing
        UserDto userDto= new UserDtoImpl();
        BeanUtils.copyProperties(user, userDto);

        userService.update(userDto);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("userId") Long userId) throws ObjectNotFoundException {
        UserDto user = userService.find(userId);

        if (user == null) {
            throw new ObjectNotFoundException("User not found.");
        }
        userService.delete(user);
    }

}
