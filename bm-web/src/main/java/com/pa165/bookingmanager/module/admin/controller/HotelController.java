package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.module.admin.form.HotelForm;
import com.pa165.bookingmanager.service.HotelService;
import com.pa165.bookingmanager.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jakub Polak
 */
@Controller("adminHotelController")
@RequestMapping(value = "/admin/hotel")
public class HotelController
{
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/list-of-hotels", method = RequestMethod.GET)
    public ModelAndView listOfHotels(){
        List<HotelDto> hotelDtos = hotelService.findAll();

        ModelAndView modelAndView = new ModelAndView("modules/admin/hotel/list-of-hotels");
        modelAndView.addObject("hotelDtos", hotelDtos);

        return modelAndView;
    }

    @RequestMapping(value = "/create-hotel", method = RequestMethod.GET)
    public ModelAndView createHotel(@ModelAttribute HotelForm hotelForm){
        ModelAndView modelAndView = new ModelAndView("modules/admin/hotel/create-hotel");

        return modelAndView;
    }

    @RequestMapping(value = "/create-hotel", method = RequestMethod.POST)
    public ModelAndView createHotel(@Valid HotelForm hotelForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/hotel/create-hotel");
            modelAndView.addObject("error", true);
        } else {
            HotelDto hotelDto = new HotelDtoImpl();
            BeanUtils.copyProperties(hotelForm, hotelDto);
            hotelService.create(hotelDto);

            modelAndView = new ModelAndView("redirect:/admin/hotel/list-of-hotels");
            redirectAttributes.addFlashAttribute("flashMessage", "{hotel.saved}");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/{hotelId}/update-hotel", method = RequestMethod.GET)
    public ModelAndView updateHotel(@PathVariable @ModelAttribute Long hotelId){
        List<RoomDto> roomDtos = roomService.findByHotel(hotelId);

        ModelAndView modelAndView = new ModelAndView("modules/admin/hotel/update-hotel");
        modelAndView.addObject("roomDtos", roomDtos);

        return modelAndView;
    }

    @RequestMapping(value = "/{hotelId}/delete-hotel", method = RequestMethod.GET)
    public ModelAndView deleteHotel(@PathVariable Long hotelId, RedirectAttributes redirectAttributes){
        return new ModelAndView("redirect:/admin/hotel/list-of-hotels");
    }
}
