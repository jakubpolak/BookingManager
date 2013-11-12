package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.RoomDto;

import java.util.Date;
import java.util.List;

/**
 * @author Jakub Polak, Josef Stribny
 */
public interface RoomService
{
    /**
     * Find all
     *
     * @return list of room DTOs
     */
    List<RoomDto> findAll();

    /**
     * Find
     *
     * @param id
     * @return room DTO
     */
    RoomDto find(Long id);

    /**
     * Create
     *
     * @param roomDto room DTO
     */
    void create(RoomDto roomDto);

    /**
     * Update
     *
     * @param roomDto room DTO
     */
    void update(RoomDto roomDto);

    /**
     * Delete
     *
     * @param roomDto room DTO
     */
    void delete(RoomDto roomDto);

    /**
     * Find by hotel
     *
     * @param id hotel id
     * @return list of room DTOs
     */
    List<RoomDto> findByHotel(Long id);
    
    /**
    * Find available rooms by hotel in a given time period
    *
    * @param id hotel id
    * @param from rooms available from
    * @param to rooms available to
    * @return list of room DTOs
    */
    List<RoomDto> findAvailableByHotel(Long id, Date from, Date to);
}
