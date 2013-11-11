package com.pa165.bookingmanager.dao;

import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.RoomEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Jakub Polak, Josef Stribny
 */
public interface RoomDao extends GenericDao<RoomEntity, Long>
{
	/**
     * Find all available rooms in a given hotel and dates
     *
     * @return list of room entities
     */
    List<RoomEntity> findAvailable(Long hotelId, Date from, Date to);

    /**
     * Find by hotel
     *
     * @param hotelEntity hotel entity
     * @return list of romm entities
     */
    List<RoomEntity> findByHotel(HotelEntity hotelEntity);
}
