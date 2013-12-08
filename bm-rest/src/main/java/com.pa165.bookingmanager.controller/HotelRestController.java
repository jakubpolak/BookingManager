package com.pa165.bookingmanager.controller;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.service.HotelService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jan Hrubeš
 */

@Controller("hotelRestController")
@RequestMapping(value = "/hotel")
public class HotelRestController extends GenericRestController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<HotelDto> getAll() {
        return hotelService.findAll();
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.GET)
    @ResponseBody
    public HotelDto get(@PathVariable(value = "hotelId") Long hotelId) {
        return hotelService.find(hotelId);
    }

    @RequestMapping(value="create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void create(@RequestBody HotelDtoImpl hotel) {
        hotelService.create(hotel);
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.PUT,  consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("hotelId") Long hotelId, @RequestBody HotelDtoImpl hotel) {
        hotelService.update(hotel);
    }

    @RequestMapping(value = "/{hotelId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("hotelId") Long hotelId) throws ObjectNotFoundException {
        HotelDto hotel = hotelService.find(hotelId);
        if (hotel == null) {
            throw new ObjectNotFoundException("Hotel not found.");
        }
        hotelService.delete(hotel);
    }
}
