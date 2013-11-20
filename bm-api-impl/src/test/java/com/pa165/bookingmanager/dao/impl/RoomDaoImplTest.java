package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.TestDaoSetup;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.entity.HotelEntity;
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
    	// Create a new room for reservations
    	RoomEntity roomEntity = new RoomEntity();
        roomEntity.setNumber("404");
        roomEntity.setPrice(new BigDecimal(29.99));
        roomEntity.setHotelByHotelId(hotelDao.find(1L));
        
        // Let's create a reservation for February 2014
        ReservationEntity reservationEntity1 = new ReservationEntity();
        reservationEntity1.setReservationFrom(new GregorianCalendar(2014, 1, 10).getTime());
        reservationEntity1.setReservationTo(new GregorianCalendar(2014, 1, 15).getTime());
        reservationEntity1.setCustomerName("Josef");
        reservationEntity1.setCustomerEmail("strzibny@strzibny.name");
        reservationEntity1.setCustomerPhone("123456789");
        reservationEntity1.setRoomByRoomId(roomEntity);
 
        // Let's create a reservation for May 2014
        ReservationEntity reservationEntity2 = new ReservationEntity();
        reservationEntity2.setReservationFrom(new GregorianCalendar(2014, 3, 10).getTime());
        reservationEntity2.setReservationTo(new GregorianCalendar(2014, 3, 30).getTime());
        reservationEntity2.setCustomerName("Josef");
        reservationEntity2.setCustomerEmail("strzibny@strzibny.name");
        reservationEntity2.setCustomerPhone("123456789");
        reservationEntity2.setRoomByRoomId(roomEntity);
        
        roomDao.create(roomEntity);
        reservationDao.create(reservationEntity1);
        reservationDao.create(reservationEntity2);
        
        // Check how many rooms are available for our hotel, room no. 404 shouln't be there
        List<RoomEntity> roomEntities = roomDao.findAvailable(1L, new GregorianCalendar(2014, 3, 1).getTime(), new GregorianCalendar(2014, 3, 31).getTime());
        Assert.assertEquals(4, roomEntities.size());
        
        List<RoomEntity> roomEntities2 = roomDao.findAvailable(1L, new GregorianCalendar(2014, 3, 10).getTime(), new GregorianCalendar(2014, 3, 30).getTime());
        Assert.assertEquals(4, roomEntities2.size());
        
        List<RoomEntity> roomEntities3 = roomDao.findAvailable(1L, new GregorianCalendar(2014, 1, 1).getTime(), new GregorianCalendar(2014, 1, 12).getTime());
        Assert.assertEquals(4, roomEntities3.size());
        
        List<RoomEntity> roomEntities4 = roomDao.findAvailable(1L, new GregorianCalendar(2014, 1, 11).getTime(), new GregorianCalendar(2014, 1, 20).getTime());
        Assert.assertEquals(4, roomEntities4.size());
        
        List<RoomEntity> roomEntities5 = roomDao.findAvailable(1L, new GregorianCalendar(2014, 1, 11).getTime(), new GregorianCalendar(2014, 1, 12).getTime());
        Assert.assertEquals(4, roomEntities5.size());
        
        // Check how many rooms are available for our hotel, room no. 404 should be there
        List<RoomEntity> roomEntities10 = roomDao.findAvailable(1L, new GregorianCalendar(2014, 4, 10).getTime(), new GregorianCalendar(2014, 4, 12).getTime());
        Assert.assertEquals(5, roomEntities10.size());
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

    @Test
    public void testFindByHotel(){
        HotelEntity hotelEntity = hotelDao.find(1L);
        Assert.assertEquals(4, roomDao.findByHotel(hotelEntity).size());
    }
}


