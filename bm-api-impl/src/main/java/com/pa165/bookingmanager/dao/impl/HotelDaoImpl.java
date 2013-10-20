package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.entity.HotelEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Polakova
 */
@Repository("hotelDao")
public class HotelDaoImpl extends GenericDaoImpl<HotelEntity, Long> implements HotelDao
{
    /**
     * Constructor
     */
    public HotelDaoImpl() {
        super(HotelEntity.class);
    }
}
