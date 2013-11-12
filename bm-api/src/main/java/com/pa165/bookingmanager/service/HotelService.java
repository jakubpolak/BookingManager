package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.HotelDto;

import java.util.List;

/**
 * @author Jakub Polak
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
     * Find
     *
     * @param id
     * @return hotel DTO including associated room DTOs
     */
    HotelDto findWithRooms(Long id);

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
