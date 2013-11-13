package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.HotelDto;

import java.util.Date;
import java.util.List;

/**
 * @author Jakub Polak, Josef Stribny
 */
public interface HotelService
{
    /**
     * Find all
     *
     * @return list of hotel DTOs
     */
    List<HotelDto> findAll();

    /**
     * Find
     *
     * @param id
     * @return hotel DTO
     */
    HotelDto find(Long id);
    
    /**
     * Find hotel by its room id
     *
     * @param id room id
     * @return hotel DTO
     */
    HotelDto findByRoomId(Long roomId);
    
    /**
     * Find with rooms
     *
     * @param id
     * @return hotel DTO including associated room DTOs
     */
    HotelDto findWithRooms(Long id);
    
    /**
     * Find with available rooms in the given time period
     *
     * @param id
     * @param from
     * @param to
     * @return hotel DTO including associated room DTOs
     */
    HotelDto findWithAvailableRooms(Long id, Date from, Date to);

    /**
     * Create
     *
     * @param hotelDto hotel DTO
     */
    void create(HotelDto hotelDto);

    /**
     * Update
     *
     * @param hotelDto DTO
     */
    void update(HotelDto hotelDto);

    /**
     * Delete
     *
     * @param hotelDto hotel DTO
     */
    void delete(HotelDto hotelDto);
}
