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

    /**
     * List of hotels
     *
     * @return model and view
     */
    @RequestMapping(value = "/list-of-hotels", method = RequestMethod.GET)
    public ModelAndView listOfHotels(){
        List<HotelDto> hotelDtos = hotelService.findAll();

        ModelAndView modelAndView = new ModelAndView("modules/admin/hotel/list-of-hotels");
        modelAndView.addObject("hotelDtos", hotelDtos);

        return modelAndView;
    }

    /**
     * Create hotel
     *
     * @param hotelForm hotel form
     * @return model and view
     */
    @RequestMapping(value = "/create-hotel", method = RequestMethod.GET)
    public ModelAndView createHotel(@ModelAttribute HotelForm hotelForm){
        return new ModelAndView("modules/admin/hotel/create-hotel");
    }

    /**
     * Create hotel
     *
     * @param hotelForm hotel form
     * @param bindingResult binding result
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
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
            redirectAttributes.addFlashAttribute("flashMessage", "hotel.saved");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return modelAndView;
    }

    /**
     * Update hotel
     *
     * @param hotelId hotel id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/update-hotel", method = RequestMethod.GET)
    public ModelAndView updateHotel(@PathVariable @ModelAttribute Long hotelId, RedirectAttributes redirectAttributes){
        HotelDto hotelDto = hotelService.find(hotelId);
        ModelAndView modelAndView = null;

        if (hotelDto == null){
            modelAndView = new ModelAndView("redirect:/admin/hotel/list-of-hotels");
            redirectAttributes.addFlashAttribute("flashMessage", "hotel.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            List<RoomDto> roomDtos = roomService.findByHotel(hotelId);

            modelAndView = new ModelAndView("modules/admin/hotel/update-hotel");
            modelAndView.addObject("roomDtos", roomDtos);

            HotelForm hotelForm = new HotelForm();
            BeanUtils.copyProperties(hotelDto, hotelForm);
            modelAndView.addObject("hotelForm", hotelForm);
        }

        return modelAndView;
    }

    /**
     * Update hotel
     *
     * @param hotelId hotel id
     * @param hotelForm hotel form
     * @param bindingResult binding result
     * @param redirectAttributes redirect attribtues
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/update-hotel", method = RequestMethod.POST)
    public ModelAndView updateHotel(@PathVariable @ModelAttribute Long hotelId, @Valid HotelForm hotelForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/hotel/update-hotel");
            modelAndView.addObject("error", true);
        } else {
            HotelDto hotelDto = hotelService.find(hotelId);
            modelAndView = new ModelAndView("redirect:/admin/hotel/list-of-hotels");

            if (hotelDto == null){
                redirectAttributes.addFlashAttribute("flashMessage", "hotel.does.not.exist");
                redirectAttributes.addFlashAttribute("flashMessageType", "error");
            } else {
                BeanUtils.copyProperties(hotelForm, hotelDto);
                hotelService.update(hotelDto);

                redirectAttributes.addFlashAttribute("flashMessage", "hotel.saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            }
        }

        return modelAndView;
    }

    /**
     * Delete hotel
     *
     * @param hotelId hotel id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/delete-hotel", method = RequestMethod.GET)
    public ModelAndView deleteHotel(@PathVariable Long hotelId, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/hotel/list-of-hotels");

        HotelDto hotelDto = hotelService.find(hotelId);

        if (hotelDto == null){
            redirectAttributes.addFlashAttribute("flashMessage", "hotel.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            hotelService.delete(hotelDto);

            redirectAttributes.addFlashAttribute("flashMessage", "hotel.deleted");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return modelAndView;
    }
}
