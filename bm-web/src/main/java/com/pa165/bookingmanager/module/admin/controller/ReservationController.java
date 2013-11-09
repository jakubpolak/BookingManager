package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jakub Polak
 */
@Controller("adminReservationController")
@RequestMapping(value = "/admin/hotel/room/reservation")
public class ReservationController
{
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/{hotelId}/{roomId}/list-of-reservations", method = RequestMethod.GET)
    public ModelAndView listOfReservations(@PathVariable Long hotelId, @PathVariable Long roomId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/reservation/list-of-reservations");

        return modelAndView;
    }

    @RequestMapping(value = "/hotelId/{roomId}/create-reservation", method = RequestMethod.GET)
    public ModelAndView createReservation(@PathVariable Long hotelId, @PathVariable Long roomId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/reservation/create-reservation");

        return modelAndView;
    }

    @RequestMapping(value = "/{hotelId}/{roomId}/{reservationId}/update-reservation", method = RequestMethod.GET)
    public ModelAndView updateReservation(@PathVariable Long hotelId, @PathVariable Long roomId, @PathVariable Long reservationId){
        ModelAndView modelAndView = new ModelAndView("modules/admin/reservation/update-reservation");

        return modelAndView;
    }

    @RequestMapping(value = "/{reservationId}/delete-reservation", method = RequestMethod.GET)
    public ModelAndView deleteReservation(@PathVariable Long hotelId, @PathVariable Long roomId, @PathVariable Long reservationId){
        return new ModelAndView("redirect:/admin/hotel/room/reservation/" + hotelId + "/" + roomId + "/list-of-reservations");
    }
}
