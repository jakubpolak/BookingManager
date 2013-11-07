package com.pa165.bookingmanager.module.home.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pa165.bookingmanager.service.HotelService;
import com.pa165.bookingmanager.service.UserService;
import com.pa165.bookingmanager.service.RoomService;
import com.pa165.bookingmanager.service.ReservationService;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.module.home.form.ReservationForm;

@Controller("homeDefaultController")
@RequestMapping(value = "/")
public class DefaultController
{
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private HttpServletRequest request;
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
    	List<HotelDto> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        return "modules/home/default/index";
    }
    
    @RequestMapping(value = "/hotel/{hotelId}", method = RequestMethod.GET)
    public String book(@PathVariable(value="hotelId") Long hotelId, ModelMap model) {
    	HotelDto hotel = hotelService.find(hotelId);
    	model.addAttribute("hotel", hotel);
    	return "modules/home/default/hotel";
    }
    
    @RequestMapping(value = "/book/{roomId}", method = RequestMethod.GET)
    public ModelAndView book(@PathVariable(value="roomId") Long roomId) {
    	ReservationForm reservation = new ReservationForm();
    	reservation.setRoomByRoomId(roomId);
    	
    	if(request.getParameter("from") != null){
			try {
				Date from = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("from"));
				reservation.setReservationFrom(from);
			} catch (ParseException e) {
				// Skip
			}
    	}
    	
    	if(request.getParameter("to") != null){
			try {
				Date to = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("to"));
				reservation.setReservationTo(to);
			} catch (ParseException e) {
				// Skip
			}
    	}
    	
    	return new ModelAndView("modules/home/default/book", "reservationForm", reservation);
    }
    
    @RequestMapping(value = "/processBooking", method = RequestMethod.POST)
    public String processBooking(@Valid @ModelAttribute("reservationForm")ReservationForm reservation, BindingResult result, ModelMap model) {
    	if (result.hasErrors()) {
    		model.addAttribute("reservationForm", reservation);
    		return "modules/home/default/book";
    	}
    	// TODO: check dates and create the reservation
    	
    	// Print details of successful reservation
    	model.addAttribute("id", reservation.getId());
    	model.addAttribute("reservationFrom", reservation.getReservationFrom());
    	model.addAttribute("reservationTo", reservation.getReservationTo());
    	model.addAttribute("customerName", reservation.getCustomerName());
    	model.addAttribute("customerEmail", reservation.getCustomerEmail());
    	model.addAttribute("customerPhone", reservation.getCustomerPhone());
    	model.addAttribute("roomByRoomId", reservation.getRoomByRoomId());
    	
        return "modules/home/default/reservation";	
    }
}