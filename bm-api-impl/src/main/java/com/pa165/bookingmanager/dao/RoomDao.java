package com.pa165.bookingmanager.dao;

import java.util.Date;
import java.util.List;

import com.pa165.bookingmanager.entity.RoomEntity;

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
}
