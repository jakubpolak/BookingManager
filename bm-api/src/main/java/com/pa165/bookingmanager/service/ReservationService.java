package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.ReservationDto;

import java.util.Date;
import java.util.List;

/**
 * @author Jakub Polak
 */
public interface ReservationService
{
    /**
     * Find all
     *
     * @return list of reservation DTOs
     */
    List<ReservationDto> findAll();

    /**
     * Find
     *
     * @param id
     * @return reservation DTO
     */
    ReservationDto find(Long id);

    /**
     * Create
     *
     * @param reservationDto reservation DTO
     * @return 
     */
    ReservationDto create(ReservationDto reservationDto);

    /**
     * Update
     *
     * @param reservationDto reservation DTO
     */
    void update(ReservationDto reservationDto);

    /**
     * Delete
     *
     * @param reservationDto reservation DTO
     */
    void delete(ReservationDto reservationDto);

    /**
     * Find by room
     *
     * @param id
     * @return list of reservation DTOs
     */
    List<ReservationDto> findByRoom(Long id);
    
    /**
     * Is the room available
     *
     * @param id room id
     * @param from room available from
     * @param to room available to
     * @return true if the room is available or false
     */
    boolean isRoomAvailable(Long id, Date reservationFrom, Date reservationTo);
}
