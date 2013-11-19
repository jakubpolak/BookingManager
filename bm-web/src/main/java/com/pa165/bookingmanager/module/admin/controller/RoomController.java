package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.module.admin.form.RoomForm;
import com.pa165.bookingmanager.service.HotelService;
import com.pa165.bookingmanager.service.ReservationService;
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
@Controller("adminRoomController")
@RequestMapping(value = "/admin/hotel/room")
public class RoomController
{
    @Autowired
    private RoomService roomService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private ReservationService reservationService;

    /**
     * Create room
     *
     * @param roomForm room form
     * @param hotelId hotel id
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/create-room", method = RequestMethod.GET)
    public ModelAndView createRoom(@ModelAttribute RoomForm roomForm, @PathVariable Long hotelId){
        return new ModelAndView("modules/admin/room/create-room");
    }

    /**
     * Create room
     *
     * @param roomForm room form
     * @param bindingResult binding result
     * @param hotelId hotel id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/create-room", method = RequestMethod.POST)
    public ModelAndView createRoom(@Valid RoomForm roomForm, BindingResult bindingResult, @PathVariable Long hotelId, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/room/create-room");
            modelAndView.addObject("error", true);
        } else {
            HotelDto hotelDto = hotelService.find(hotelId);

            if (hotelDto == null){
                redirectAttributes.addFlashAttribute("flashMessage", "hotel.does.not.exist");
                redirectAttributes.addFlashAttribute("flashMessageType", "error");
            } else {
                RoomDto roomDto = new RoomDtoImpl();
                BeanUtils.copyProperties(roomForm, roomDto);
                roomDto.setHotelByHotelId(hotelDto);
                roomService.create(roomDto);

                redirectAttributes.addFlashAttribute("flashMessage", "room.saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            }

            modelAndView = new ModelAndView("redirect:/admin/hotel/" + hotelId + "/update-hotel");
        }

        return modelAndView;
    }

    /**
     * Update room
     *
     * @param hotelId hotel id
     * @param roomId room id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/update-room", method = RequestMethod.GET)
    public ModelAndView updateRoom(@ModelAttribute @PathVariable Long hotelId, @ModelAttribute @PathVariable Long roomId, RedirectAttributes redirectAttributes){
        RoomDto roomDto = roomService.find(roomId);

        ModelAndView modelAndView = null;

        if (roomDto == null){
            modelAndView = new ModelAndView("redirect:/admin/hotel/" + hotelId + "/update-hotel");
            redirectAttributes.addFlashAttribute("flashMessage", "room.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            List<ReservationDto> reservationDtos = reservationService.findByRoom(roomId);
            RoomForm roomForm = new RoomForm();

            BeanUtils.copyProperties(roomDto, roomForm);

            modelAndView = new ModelAndView("modules/admin/room/update-room");
            modelAndView.addObject("roomForm", roomForm);
            modelAndView.addObject("reservationDtos", reservationDtos);
        }

        return modelAndView;
    }

    /**
     * Update room
     *
     * @param hotelId hotel id
     * @param roomId room id
     * @param roomForm room form
     * @param bindingResult binding result
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/update-room", method = RequestMethod.POST)
    public ModelAndView updateRoom(
            @Valid RoomForm roomForm,
            BindingResult bindingResult,
            @ModelAttribute @PathVariable Long hotelId,
            @ModelAttribute @PathVariable Long roomId,
            RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/room/update-room");
            modelAndView.addObject("error", true);

            List<ReservationDto> reservationDtos = reservationService.findByRoom(roomId);
            modelAndView.addObject("reservationDtos", reservationDtos);
        } else {
            RoomDto roomDto = roomService.find(roomId);
            modelAndView = new ModelAndView("redirect:/admin/hotel/" + hotelId + "/update-hotel");

            if (roomDto == null){
                redirectAttributes.addFlashAttribute("flashMessage", "room.does.not.exist");
                redirectAttributes.addFlashAttribute("flashMessageType", "error");
            } else {
                BeanUtils.copyProperties(roomForm, roomDto);
                roomService.update(roomDto);

                redirectAttributes.addFlashAttribute("flashMessage", "room.saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            }
        }

        return modelAndView;
    }

    /**
     * Delete room
     *
     * @param hotelId hotel id
     * @param roomId room id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/delete-room")
    public ModelAndView deleteRoom(@PathVariable Long hotelId, @PathVariable Long roomId, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/hotel/" + hotelId + "/update-hotel");

        RoomDto roomDto = roomService.find(roomId);

        if (roomDto == null){
            redirectAttributes.addFlashAttribute("flashMessage", "room.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            roomService.delete(roomDto);

            redirectAttributes.addFlashAttribute("flashMessage", "room.deleted");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return modelAndView;
    }
}
