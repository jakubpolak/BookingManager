package com.pa165.bookingmanager.dao;

import com.pa165.bookingmanager.entity.ReservationEntity;

import java.util.List;

/**
 * @author Jakub Polak
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
}
