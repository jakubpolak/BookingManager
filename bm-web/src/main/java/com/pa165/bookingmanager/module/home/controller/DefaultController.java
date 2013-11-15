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

import com.pa165.bookingmanager.service.HotelService;
import com.pa165.bookingmanager.service.UserService;
import com.pa165.bookingmanager.service.RoomService;
import com.pa165.bookingmanager.service.ReservationService;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.module.home.form.ReservationForm;

/**
 * @author Josef Stribny
 */
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
    public String showHotel(@PathVariable(value="hotelId") Long hotelId, ModelMap model) {
    	HotelDto hotel = null;
    	
    	if(request.getParameter("from") != null && request.getParameter("to") != null){
			try {
				Date from = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("from"));
				Date to = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("to"));
				
				hotel = hotelService.findWithAvailableRooms(hotelId, from, to);
			} catch (ParseException e) {
				// Invalid date
			}
    	}
    	
    	if(hotel == null) {
    		hotel = hotelService.findWithRooms(hotelId);
    	}
    	
    	model.addAttribute("from", request.getParameter("from"));
		model.addAttribute("to", request.getParameter("to"));
    	model.addAttribute("hotel", hotel);
    	return "modules/home/default/hotel";
    }
    
    @RequestMapping(value = "/book/{roomId}", method = RequestMethod.GET)
    public String bookRoom(@PathVariable(value="roomId") Long roomId, ModelMap model) {
    	ReservationForm reservation = new ReservationForm();
    	reservation.setRoomByRoomId(roomId);
    	
    	if(request.getParameter("from") != null && request.getParameter("to") != null){
			try {
				Date from = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("from"));
				reservation.setReservationFrom(from);
				Date to = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("to"));
				reservation.setReservationTo(to);
			} catch (ParseException e) {
				// Skip
			}
    	}
    	
    	// Associated hotel has to exist
    	RoomDto room = roomService.find(roomId);
    	HotelDto hotel = hotelService.findByRoomId(room.getId());

    	model.addAttribute("room", room);
    	model.addAttribute("hotel", hotel);
    	model.addAttribute("reservationForm", reservation);
    	
    	return "modules/home/default/book";
    }
    
    @RequestMapping(value = "/processBooking", method = RequestMethod.POST)
    public String processBooking(@Valid @ModelAttribute("reservationForm")ReservationForm reservationForm, BindingResult result, ModelMap model) {
    	if (result.hasErrors()) {
    		model.addAttribute("reservationForm", reservationForm);
    		return "modules/home/default/book";
    	}
    	
    	RoomDto roomDto = roomService.find(reservationForm.getRoomByRoomId());
    	
    	ReservationDto reservationDto = new ReservationDtoImpl();
    	reservationDto.setReservationFrom(reservationForm.getReservationFrom());
    	reservationDto.setReservationTo(reservationForm.getReservationTo());
    	reservationDto.setCustomerName(reservationForm.getCustomerName());
    	reservationDto.setCustomerEmail(reservationForm.getCustomerEmail());
    	reservationDto.setCustomerPhone(reservationForm.getCustomerPhone());
    	reservationDto.setRoomByRoomId(roomDto);
    	
    	reservationService.create(reservationDto);
    	
    	// Print details of successful reservation
    	model.addAttribute("id", reservationForm.getId());
    	model.addAttribute("reservationFrom", reservationForm.getReservationFrom());
    	model.addAttribute("reservationTo", reservationForm.getReservationTo());
    	model.addAttribute("customerName", reservationForm.getCustomerName());
    	model.addAttribute("customerEmail", reservationForm.getCustomerEmail());
    	model.addAttribute("customerPhone", reservationForm.getCustomerPhone());
    	model.addAttribute("roomByRoomId", reservationForm.getRoomByRoomId());
    	
        return "modules/home/default/reservation";	
    }
}