package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.TestDaoSetup;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Jan Hrubes, Josef Stribny
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomDaoImplTest extends TestDaoSetup
{
    @Autowired
    HotelDao hotelDao;

    @Autowired
    RoomDao roomDao;

    @Autowired
    ReservationDao reservationDao;

    @Test
    public void testFindAll(){
        List<RoomEntity> roomEntities = roomDao.findAll();
        Assert.assertEquals(8, roomEntities.size());
    }
    
    @Test
    public void testFindAvailable(){       
        // Let's create a reservation for January 2014
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationFrom(new GregorianCalendar(2014, 1, 10).getTime());
        reservationEntity.setReservationTo(new GregorianCalendar(2014, 1, 15).getTime());
        reservationEntity.setCustomerName("Josef");
        reservationEntity.setCustomerEmail("strzibny@strzibny.name");
        
        // Let's create a reservation for March 2014
        ReservationEntity reservationEntity2 = new ReservationEntity();
        reservationEntity2.setReservationFrom(new GregorianCalendar(2014, 3, 10).getTime());
        reservationEntity2.setReservationTo(new GregorianCalendar(2014, 3, 30).getTime());
        reservationEntity2.setCustomerName("Josef");
        reservationEntity2.setCustomerEmail("strzibny@strzibny.name");
        
        List<ReservationEntity> reservationEntities = new ArrayList<>();
        reservationEntities.add(reservationEntity);
        reservationEntities.add(reservationEntity2);
        
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setNumber("404");
        roomEntity.setPrice(new BigDecimal(29.99));
        roomEntity.setHotelByHotelId(hotelDao.find(1L));
        roomEntity.setReservationsById(reservationEntities);
        
        // Check how many rooms are available for our hotel, room no. 404 shouln't be there
        List<RoomEntity> roomEntities = roomDao.findAvailable(1L, new GregorianCalendar(2014, 3, 10).getTime(), new GregorianCalendar(2014, 3, 12).getTime());
        Assert.assertEquals(8, roomEntities.size());
        
        // Check how many rooms are available for our hotel, room no. 404 should be there
        List<RoomEntity> roomEntities = roomDao.findAvailable(1L, new GregorianCalendar(2014, 3, 10).getTime(), new GregorianCalendar(2014, 3, 12).getTime());
        Assert.assertEquals(9, roomEntities.size());
    }

    @Test
    public void testFind(){
        RoomEntity roomEntity = roomDao.find(1L);
        Assert.assertNotNull(roomEntity);
    }

    @Test
    public void testCreate(){
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationFrom(new GregorianCalendar(2013, 4, 27).getTime());
        reservationEntity.setReservationTo(new GregorianCalendar(2013, 4, 30).getTime());
        reservationEntity.setCustomerName("Jan Hrubeš");
        reservationEntity.setCustomerEmail("jan@hrubes.com");
        reservationEntity.setCustomerPhone("321 456 987");

        List<ReservationEntity> reservationEntities = new ArrayList<>();
        reservationEntities.add(reservationEntity);

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setNumber("101");
        roomEntity.setPrice(new BigDecimal(29.99));
        roomEntity.setHotelByHotelId(hotelDao.find(1L));
        roomEntity.setReservationsById(reservationEntities);

        roomDao.create(roomEntity);

        // Test if reservation was added into database
        RoomEntity roomEntitySaved = roomDao.find(roomEntity.getId());
        Assert.assertNotNull(roomEntitySaved);

        // Test if reservation was added into database
        ReservationEntity reservationEntitySaved = reservationDao.find(reservationEntity.getId());
        Assert.assertNotNull(reservationEntitySaved);
    }

    @Test
    public void testUpdate(){
        Long roomId = 1L;

        RoomEntity roomEntity = roomDao.find(roomId);
        roomEntity.setNumber("202");
        List<ReservationEntity> reservationEntities = roomEntity.getReservationsById();

        ReservationEntity reservationEntity = reservationEntities.get(0);
        reservationEntity.setCustomerName("Jan Hrubeš");

        roomDao.create(roomEntity);

        // Test if room was updated
        RoomEntity roomEntityUpdated = roomDao.find(roomId);
        Assert.assertEquals(roomEntityUpdated.getNumber(), "202");

        // Test if room reservation was updated
        ReservationEntity reservationEntityUpdated = reservationDao.find(reservationEntity.getId());
        Assert.assertEquals(reservationEntityUpdated.getCustomerName(), "Jan Hrubeš");
    }

    @Test
    public void testDelete(){
        Long roomId = 1L;

        RoomEntity roomEntity = roomDao.find(roomId);
        List<ReservationEntity> reservationEntities = roomEntity.getReservationsById();

        roomDao.delete(roomEntity);

        // Test if room was deleted
        RoomEntity roomEntityDeleted = roomDao.find(roomId);
        Assert.assertEquals(null, roomEntityDeleted);

        // Test if room reservations were deleted
        for (ReservationEntity reservationEntity : reservationEntities){
            ReservationEntity reservationEntityDeleted = reservationDao.find(reservationEntity.getId());
            Assert.assertNull(reservationEntityDeleted);
        }
    }
}


