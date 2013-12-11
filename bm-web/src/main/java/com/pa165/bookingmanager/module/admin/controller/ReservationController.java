package com.pa165.bookingmanager.module.admin.controller;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.module.admin.form.ReservationForm;
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

/**
 * @author Jakub Polak, Jana Polakova
 */
@Controller("adminReservationController")
@RequestMapping(value = "/admin/hotel/room/reservation")
public class ReservationController
{
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    /**
     * Create reservation
     *
     * @param reservationForm reservation form
     * @param hotelId hotel id
     * @param roomId room id
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/create-reservation", method = RequestMethod.GET)
    public ModelAndView createReservation(@ModelAttribute ReservationForm reservationForm, @PathVariable Long hotelId, @PathVariable Long roomId){
        return new ModelAndView("modules/admin/reservation/create-reservation");
    }

    /**
     * Create reservation
     *
     * @param reservationForm reservation form
     * @param bindingResult binding result
     * @param hotelId hotel id
     * @param roomId room id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/create-reservation", method = RequestMethod.POST)
    public ModelAndView createReservation(
            @Valid ReservationForm reservationForm,
            BindingResult bindingResult,
            @PathVariable Long hotelId,
            @PathVariable Long roomId,
            RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/reservation/create-reservation");
            modelAndView.addObject("error", true);
        } else {
            RoomDto roomDto = roomService.find(roomId);

            if (roomDto == null){
                redirectAttributes.addFlashAttribute("flashMessage", "room.does.not.exist");
                redirectAttributes.addFlashAttribute("flashMessageType", "error");
            } else {
                ReservationDto reservationDto = new ReservationDtoImpl();
                reservationDto.setRoomByRoomId(roomDto);
                BeanUtils.copyProperties(reservationForm, reservationDto);
                reservationService.create(reservationDto);

                redirectAttributes.addFlashAttribute("flashMessage", "reservation.saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            }

            modelAndView = new ModelAndView("redirect:/admin/hotel/room/" + hotelId + "/" + roomId + "/update-room");
        }

        return modelAndView;
    }

    /**
     * Update reservation
     *
     * @param hotelId hotel id
     * @param roomId room id
     * @param reservationId reservation id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/{reservationId}/update-reservation", method = RequestMethod.GET)
    public ModelAndView updateReservation(
            @PathVariable Long hotelId,
            @PathVariable Long roomId,
            @PathVariable Long reservationId,
            RedirectAttributes redirectAttributes){
        ReservationDto reservationDto = reservationService.find(reservationId);
        ModelAndView modelAndView = null;

        if (reservationDto == null){
            modelAndView = new ModelAndView("redirect:/admin/hotel/room/" + hotelId + "/" + roomId + "/update-room");
            redirectAttributes.addFlashAttribute("flashMessage", "reservation.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "error");
        } else {
            modelAndView = new ModelAndView("modules/admin/reservation/update-reservation");

            ReservationForm reservationForm = new ReservationForm();
            BeanUtils.copyProperties(reservationDto, reservationForm);
            modelAndView.addObject("reservationForm", reservationForm);
        }

        return modelAndView;
    }

    /**
     * Update reservation
     *
     * @param reservationForm reservation form
     * @param bindingResult binding result
     * @param hotelId hotel id
     * @param roomId room id
     * @param reservationId reservation id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/{reservationId}/update-reservation", method = RequestMethod.POST)
    public ModelAndView updateReservation(
            @Valid ReservationForm reservationForm,
            BindingResult bindingResult,
            @PathVariable Long hotelId,
            @PathVariable Long roomId,
            @PathVariable Long reservationId,
            RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = null;

        if (bindingResult.hasErrors()){
            modelAndView = new ModelAndView("modules/admin/room/update-room");
            modelAndView.addObject("error", true);
        } else {
            ReservationDto reservationDto = reservationService.find(reservationId);
            modelAndView = new ModelAndView("redirect:/admin/hotel/room/" + hotelId + "/" + roomId + "/update-room");

            if (reservationDto == null){
                redirectAttributes.addFlashAttribute("flashMessage", "reservation.does.not.exist");
                redirectAttributes.addFlashAttribute("flashMessageType", "error");
            } else {
                BeanUtils.copyProperties(reservationForm, reservationDto);
                reservationService.update(reservationDto);

                redirectAttributes.addFlashAttribute("flashMessage", "reservation.saved");
                redirectAttributes.addFlashAttribute("flashMessageType", "success");
            }
        }

        return modelAndView;
    }

    /**
     * Delete reservation
     *
     * @param hotelId hotel id
     * @param roomId room id
     * @param reservationId reservation id
     * @param redirectAttributes redirect attributes
     * @return model and view
     */
    @RequestMapping(value = "/{hotelId}/{roomId}/{reservationId}/delete-reservation", method = RequestMethod.GET)
    public ModelAndView deleteReservation(@PathVariable Long hotelId, @PathVariable Long roomId, @PathVariable Long reservationId, RedirectAttributes redirectAttributes){
        ReservationDto reservationDto = reservationService.find(reservationId);

        if (reservationDto == null){
            redirectAttributes.addFlashAttribute("flashMessage", "reservation.does.not.exist");
            redirectAttributes.addFlashAttribute("flashMessageType", "reservation.deleted");
        } else {
            reservationService.delete(reservationDto);

            redirectAttributes.addFlashAttribute("flashMessage", "reservation.deleted");
            redirectAttributes.addFlashAttribute("flashMessageType", "success");
        }

        return new ModelAndView("redirect:/admin/hotel/room/" + hotelId + "/" + roomId + "/update-room");
    }
}
