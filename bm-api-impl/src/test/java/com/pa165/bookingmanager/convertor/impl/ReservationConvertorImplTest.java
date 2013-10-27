package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.TestSetup;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.GregorianCalendar;

/**
 * @author Jakub Polak
 */
public class ReservationConvertorImplTest extends TestSetup
{
    private ReservationEntity reservationEntity;

    private ReservationDto reservationDto;

    @Autowired
    private ReservationConvertorImpl reservationConvertor;

    @Before
    public void setup(){
        RoomEntity roomEntity = new RoomEntity();

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setId(1L);
        reservationEntity.setCustomerPhone("+421 911 123 456");
        reservationEntity.setCustomerName("John Doe");
        reservationEntity.setCustomerEmail("user123456@me.com");
        reservationEntity.setRoomByRoomId(roomEntity);
        reservationEntity.setReservationFrom(new GregorianCalendar(1990, 10, 10).getTime());
        reservationEntity.setReservationTo(new GregorianCalendar(1990, 11, 10).getTime());

        this.reservationEntity = reservationEntity;

        RoomDto roomDto = new RoomDtoImpl();

        ReservationDto reservationDto = new ReservationDtoImpl();
        reservationDto.setId(1L);
        reservationDto.setCustomerPhone("+421 911 123 456");
        reservationDto.setCustomerName("John Doe");
        reservationDto.setCustomerEmail("user123456@me.com");
        reservationDto.setRoomByRoomId(roomDto);
        reservationDto.setReservationFrom(new GregorianCalendar(1990, 10, 10).getTime());
        reservationDto.setReservationTo(new GregorianCalendar(1990, 11, 10).getTime());

        this.reservationDto = reservationDto;
    }

    @Test
    public void testConvertEntityToDto() throws Exception {
        ReservationDto reservationDto = reservationConvertor.convertEntityToDto(reservationEntity);

        Assert.assertEquals(reservationDto.getId(), reservationEntity.getId());
        Assert.assertEquals(reservationDto.getCustomerEmail(), reservationEntity.getCustomerEmail());
        Assert.assertEquals(reservationDto.getCustomerName(), reservationEntity.getCustomerName());
        Assert.assertEquals(reservationDto.getCustomerPhone(), reservationEntity.getCustomerPhone());
        Assert.assertEquals(reservationDto.getReservationFrom(), reservationEntity.getReservationFrom());
        Assert.assertEquals(reservationDto.getReservationTo(), reservationEntity.getReservationTo());
        Assert.assertNotNull(reservationDto.getRoomByRoomId());
    }

    @Test
    public void testConvertDtoToEntity() throws Exception {
        ReservationEntity reservationEntity = reservationConvertor.convertDtoToEntity(reservationDto);

        Assert.assertEquals(reservationEntity.getId(), reservationDto.getId());
        Assert.assertEquals(reservationEntity.getCustomerEmail(), reservationDto.getCustomerEmail());
        Assert.assertEquals(reservationEntity.getCustomerName(), reservationDto.getCustomerName());
        Assert.assertEquals(reservationEntity.getCustomerPhone(), reservationDto.getCustomerPhone());
        Assert.assertEquals(reservationEntity.getReservationFrom(), reservationDto.getReservationFrom());
        Assert.assertEquals(reservationEntity.getReservationTo(), reservationDto.getReservationTo());
        Assert.assertNotNull(reservationEntity.getRoomByRoomId());
    }
}
