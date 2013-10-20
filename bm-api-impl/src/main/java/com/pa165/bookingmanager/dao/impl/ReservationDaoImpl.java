package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.entity.ReservationEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Polakova
 */
@Repository("reservationDao")
public class ReservationDaoImpl extends GenericDaoImpl<ReservationEntity, Long> implements ReservationDao
{
    /**
     * Constructor
     */
    public ReservationDaoImpl(){
        super(ReservationEntity.class);
    }
}
