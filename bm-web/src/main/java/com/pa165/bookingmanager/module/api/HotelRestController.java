package com.pa165.bookingmanager.module.api;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jan Hrubeš
 */

@Controller("hotelRestController")
@RequestMapping(value = "/api/hotel")
public class HotelRestController extends GenericRestController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public List<HotelDto> getAll() {
        return hotelService.findAll();
    }

    @RequestMapping(value = "/get/{hotelId}", method = RequestMethod.GET)
    @ResponseBody
    public HotelDto get(@PathVariable(value = "hotelId") Long hotelId) {
        return hotelService.find(hotelId);
    }

    @RequestMapping(value="create", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HotelDto create(@RequestBody HotelDto hotel) {
        hotelService.create(hotel);
        return hotel;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public void update(HotelDto hotel) {
        hotelService.update(hotel);
    }

    @RequestMapping(value = "delete/{hotelId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("hotelId") Long hotelId) {
        HotelDto hotel = hotelService.find(hotelId);

        if (hotel != null) {
            hotelService.delete(hotel);
        }
    }
}
