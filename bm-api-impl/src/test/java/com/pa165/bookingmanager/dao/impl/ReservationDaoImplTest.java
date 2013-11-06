package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.TestDaoSetup;
import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.entity.ReservationEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Jan Hrubes
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationDaoImplTest extends TestDaoSetup
{
    @Autowired
    ReservationDao reservationDao;

    @Autowired
    RoomDao roomDao;

    @Test
    public void testFindAll(){
        List<ReservationEntity> reservationEntities = reservationDao.findAll();
        Assert.assertEquals(4, reservationEntities.size());
    }

    @Test
    public void testFind(){
        ReservationEntity reservationEntity = reservationDao.find(1L);
        Assert.assertNotNull(reservationEntity);
    }

    @Test
    public void testCreate(){
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setReservationFrom(new GregorianCalendar(2013, 4, 27).getTime());
        reservationEntity.setReservationTo(new GregorianCalendar(2013, 4, 30).getTime());
        reservationEntity.setCustomerName("Jan Hrubeš");
        reservationEntity.setCustomerEmail("jan@hrubes.com");
        reservationEntity.setCustomerPhone("321 456 987");
        reservationEntity.setRoomByRoomId(roomDao.find(1L));

        reservationDao.create(reservationEntity);

        ReservationEntity reservationEntitySaved = reservationDao.find(reservationEntity.getId());
        Assert.assertNotNull(reservationEntitySaved);
    }

    @Test
    public void testUpdate(){
        Long reservationId = 1L;

        ReservationEntity reservationEntity = reservationDao.find(reservationId);
        reservationEntity.setCustomerName("Jan Hrubeš");

        reservationDao.create(reservationEntity);

        ReservationEntity reservationEntityUpdated = reservationDao.find(reservationId);
        Assert.assertEquals(reservationEntityUpdated.getCustomerName(), "Jan Hrubeš");
    }

    @Test
    public void testDelete(){
        Long hotelId = 1L;
        ReservationEntity reservationEntity = reservationDao.find(hotelId);

        reservationDao.delete(reservationEntity);

        ReservationEntity reservationEntityDeleted = reservationDao.find(hotelId);
        Assert.assertEquals(reservationEntityDeleted, null);
    }
}


