package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestSetup;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.service.ReservationService;
import com.pa165.bookingmanager.service.RoomService;
import junit.framework.Assert;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Jakub Polak, Jan Hrubes
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ReservationServiceImplTest extends TestSetup
{
    @Autowired
    ReservationService reservationService;

    @Autowired
    RoomService roomService;

    @Test
    public void testFindAll() throws Exception {
        List<ReservationDto> reservationDtos = reservationService.findAll();

        Assert.assertEquals(reservationDtos.size(), 4);
    }

    @Test
    public void testFindByCriteria() throws Exception {
        List<ReservationDto> reservationDtos1 = reservationService.findByCriteria(Restrictions.eq("customerName", "Mahatma Gandhi"));

        Assert.assertEquals(reservationDtos1.size(), 1);

        List<ReservationDto> reservationDtos2 = reservationService.findByCriteria(Restrictions.eq("id", 999L));

        Assert.assertTrue(reservationDtos2.isEmpty());
    }

    @Test
    public void testFind() throws Exception {
        Assert.assertNotNull(reservationService.find(2L));
        Assert.assertNull(reservationService.find(999L));
    }

    @Test
    public void testCreate() throws Exception {
        ReservationDto reservationDto = new ReservationDtoImpl();
        reservationDto.setCustomerEmail("new@email.com");
        reservationDto.setCustomerName("John Doe");
        reservationDto.setCustomerPhone("777 542 654");
        reservationDto.setReservationFrom(new GregorianCalendar(2013, 12, 24).getTime());
        reservationDto.setReservationTo(new GregorianCalendar(2013, 12, 28).getTime());
        reservationDto.setRoomByRoomId(roomService.find(1L));

        reservationService.create(reservationDto);

        List<ReservationDto> reservationDtos = reservationService.findByCriteria(Restrictions.eq("customerName", "John Doe"));

        Assert.assertEquals(reservationDtos.size(), 1);
    }

    @Test
    public void testUpdate() throws Exception {
        ReservationDto reservationDto = reservationService.find(1L);
        reservationDto.setCustomerName("New Name");

        reservationService.update(reservationDto);

        List<ReservationDto> reservationDtos = reservationService.findByCriteria(Restrictions.eq("customerName", "New Name"));

        Assert.assertEquals(reservationDtos.size(), 1);
    }

    @Test
    public void testDelete() throws Exception {
        reservationService.delete(reservationService.find(1L));

        Assert.assertNull(reservationService.find(1L));
    }
}
