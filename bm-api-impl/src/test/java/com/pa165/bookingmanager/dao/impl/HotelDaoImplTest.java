package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.TestSetup;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class HotelDaoImplTest extends TestSetup
{
    @Autowired
    HotelDao hotelDao;

    @Autowired
    RoomDao roomDao;

    @Test
    public void testFindAll(){
        List<HotelEntity> hotelEntities = hotelDao.findAll();
        Assert.assertEquals(3, hotelEntities.size());
    }

    @Test
    public void testFind(){
        HotelEntity hotelEntity = hotelDao.find(1L);
        Assert.assertNotNull(hotelEntity);
    }

    @Test
    public void testFindByCriteria(){
        Criterion critName = Restrictions.like("name", "%Hotel%");
        List<HotelEntity> hotelEntities = hotelDao.findByCriteria(critName);
        Assert.assertEquals(2, hotelEntities.size());
    }

    @Test
    public void testCreate(){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setNumber("101");
        roomEntity.setPrice(new BigDecimal(29.99));

        List<RoomEntity> roomEntities = new ArrayList<>();
        roomEntities.add(roomEntity);

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName("Sunce");
        hotelEntity.setRoomsById(roomEntities);

        hotelDao.create(hotelEntity);

        // Test if hotel was added into database
        HotelEntity hotelEntitySaved = hotelDao.find(hotelEntity.getId());
        Assert.assertNotNull(hotelEntitySaved);

        // Test if room was added into database
        RoomEntity roomEntity1Saved = roomDao.find(roomEntity.getId());
        Assert.assertNotNull(roomEntity1Saved);
    }

    @Test
    public void testUpdate(){
        Long hotelId = 1L;

        HotelEntity hotelEntity = hotelDao.find(hotelId);
        hotelEntity.setName("Hotel Imperial");
        List<RoomEntity> roomEntities = hotelEntity.getRoomsById();

        RoomEntity roomEntity = roomEntities.get(0);
        roomEntity.setNumber("999");

        hotelDao.create(hotelEntity);

        // Test if hotel was updated
        HotelEntity hotelEntityUpdated = hotelDao.find(hotelId);
        Assert.assertEquals(hotelEntityUpdated.getName(), "Hotel Imperial");

        // Test if hotel room was updated
        RoomEntity roomEntityUpdated = roomDao.find(roomEntity.getId());
        Assert.assertEquals(roomEntityUpdated.getNumber(), "999");
    }

    @Test
    public void testDelete(){
        Long id = 1L;

        HotelEntity hotelEntity = hotelDao.find(id);
        List<RoomEntity> roomEntities = hotelEntity.getRoomsById();
        hotelDao.delete(hotelEntity);

        // Test if hotel was deleted
        HotelEntity hotelEntityDeleted = hotelDao.find(id);
        Assert.assertNull(hotelEntityDeleted);

        // Test if hotel rooms were deleted
        for (RoomEntity roomEntity : roomEntities){
            RoomEntity roomEntityDeleted = roomDao.find(roomEntity.getId());
            Assert.assertNull(roomEntityDeleted);
        }
    }
}
