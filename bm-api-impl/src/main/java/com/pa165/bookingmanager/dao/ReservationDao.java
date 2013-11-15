package com.pa165.bookingmanager.dao;

import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;

import java.util.Date;
import java.util.List;

/**
 * @author Jakub Polak, Josef Stribny
 */
public interface ReservationDao extends GenericDao<ReservationEntity, Long>
{
    /**
     * Find by room
     *
     * @param id
     * @return list of reservation entities
     */
    public List<ReservationEntity> findByRoom(Long id);

    /**
     * Is the room available
     *
     * @param room room entity
     * @param from room available from
     * @param to room available to
     * @return true if the room is available or false
     */
	public boolean isRoomAvailable(RoomEntity room, Date reservationFrom, Date reservationTo);
}
