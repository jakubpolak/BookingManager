package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.module.admin.binder.RoleDtoBinder;
import com.pa165.bookingmanager.module.admin.form.type.UserCreateFormType;
import com.pa165.bookingmanager.module.admin.form.type.UserUpdateFormType;
import com.pa165.bookingmanager.service.RoleService;
import com.pa165.bookingmanager.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jakub Polak, Jana Polakova
 */
@Controller("adminUserController")
@RequestMapping(value = "/admin/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleDtoBinder roleDtoBinder;

    /**
     * Init binder
     *
     * @param webDataBinder web data binder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(RoleDto.class, roleDtoBinder);
    }

    /**
     * List of users
     *
     * @return model and view
     */
    @RequestMapping(value = "/list-of-users", method = RequestMethod.GET)
    public ModelAndView listOfUsers(){
        List<UserDto> userDtos = userService.findAllAndRoles();

        ModelAndView modelAndView = new ModelAndView("modules/admin/user/list-of-users");
        modelAndView.addObject("userDtos", userDtos);

        return modelAndView;
    }

    /**
     * Create user
     *
     * @param userCreateFormType user form
     * @return model and view
     */
    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ModelAndView createUser(@ModelAttribute UserCreateFormType userCreateFormType){
        ModelAndView modelAndView = new ModelAndView("modules/admin/user/create-user");
        List<RoleDto> roleDtos = roleService.findAll();
        modelAndView.addObject("roleDtos", roleDtos);

        return modelAndView;
    }

    /**
     * Create user
     *
     * @param userCreateFormType user form
     * @param bindingResult binding result
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid UserCreateFormType userCreateFormType, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/user/create-user");
            modelAndView.addObject("error", true);

            List<RoleDto> roleDtos = roleService.findAll();
            modelAndView.addObject("roleDtos", roleDtos);
        } else {
            UserDto userDto = new UserDtoImpl();
            BeanUtils.copyProperties(userCreateFormType, userDto);
            userService.create(userDto);

            modelAndView = new ModelAndView("redirect:/admin/user/list-of-users");
            redirectAttributes.addFlashAttribute("flashMessage", "user.saved");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return modelAndView;
    }

    /**
     * Update user
     *
     * @param userId user id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{userId}/update-user", method = RequestMethod.GET)
    public ModelAndView updateUser(@ModelAttribute @PathVariable Long userId, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        UserDto userDto = userService.find(userId);

        if (userDto == null){
            modelAndView = new ModelAndView("redirect:/admin/user/list-of-users");
            redirectAttributes.addFlashAttribute("flashMessage", "user.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            UserUpdateFormType userUpdateFormType = new UserUpdateFormType();
            BeanUtils.copyProperties(userDto, userUpdateFormType);

            modelAndView = new ModelAndView("modules/admin/user/update-user");
            modelAndView.addObject("userUpdateFormType", userUpdateFormType);

            List<RoleDto> roleDtos = roleService.findAll();
            modelAndView.addObject("roleDtos", roleDtos);
        }

        return modelAndView;
    }

    /**
     * Update user
     *
     * @param userUpdateFormType user form
     * @param bindingResult binding result
     * @param userId user id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{userId}/update-user", method = RequestMethod.POST)
    public ModelAndView updateUser(
            @Valid UserUpdateFormType userUpdateFormType,
            BindingResult bindingResult,
            @ModelAttribute @PathVariable Long userId,
            RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/user/update-user");
            modelAndView.addObject("error", true);

            List<RoleDto> roleDtos = roleService.findAll();
            modelAndView.addObject("roleDtos", roleDtos);
        } else {
            modelAndView = new ModelAndView("redirect:/admin/user/list-of-users");

            UserDto userDto = userService.find(userId);

            if (userDto == null){
                redirectAttributes.addFlashAttribute("flashMessage", "user.does.not.exist");
                redirectAttributes.addFlashAttribute("flashMessageType", "error");
            } else {
                BeanUtils.copyProperties(userUpdateFormType, userDto);
                userService.update(userDto);

                redirectAttributes.addFlashAttribute("flashMessage", "user.saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            }
        }

        return modelAndView;
    }

    /**
     * Delete user
     *
     * @param userId user id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{userId}/delete-user", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Long userId, RedirectAttributes redirectAttributes){
        UserDto userDto = userService.find(userId);

        if (userDto == null){
            redirectAttributes.addFlashAttribute("flashMessage", "user.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            userService.delete(userDto);

            redirectAttributes.addFlashAttribute("flashMessage", "user.deleted");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return new ModelAndView("redirect:/admin/user/list-of-users");
    }
}
