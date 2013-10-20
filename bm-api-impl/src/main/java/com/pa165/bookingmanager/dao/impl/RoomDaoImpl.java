package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Polakova
 */
@Repository("roomDao")
public class RoomDaoImpl extends GenericDaoImpl<RoomEntity, Long> implements RoomDao
{
    /**
     * Constructor
     */
    public RoomDaoImpl(){
        super(RoomEntity.class);
    }
}
