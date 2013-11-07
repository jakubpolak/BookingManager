package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jakub Polak
 */
//@Controller("adminRoomController")
@RequestMapping(value = "/admin/hotel/room")
public class RoomController
{
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/{hotelId}/list-of-rooms", method = RequestMethod.GET)
    public ModelAndView listOfRooms(@PathVariable Long hotelId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/room/list-of-rooms");

        return modelAndView;
    }

    @RequestMapping(value = "/{hotelId}/create-room", method = RequestMethod.GET)
    public ModelAndView createRoom(@PathVariable Long hotelId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/room/create-room");

        return modelAndView;
    }

    @RequestMapping(value = "/{hotelId}/{roomId}/update-room", method = RequestMethod.GET)
    public ModelAndView updateRoom(@PathVariable Long hotelId, @PathVariable Long roomId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/room/update-room");

        return modelAndView;
    }

    @RequestMapping(value = "/{hotelId}/{roomId}/delete-room")
    public ModelAndView deleteRoom(@PathVariable Long hotelId, @PathVariable Long roomId){
        return new ModelAndView("redirect:/admin/hotel/room/" + hotelId + "/list-of-rooms");
    }
}
