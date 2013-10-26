package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.TestSetup;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class RoomConvertorTest extends TestSetup
{
    private RoomEntity roomEntity;

    protected RoomDto roomDto;

    @Before
    public void setup()
    {
        HotelEntity hotelEntity = new HotelEntity();

        ReservationEntity reservationEntity1 = new ReservationEntity();
        ReservationEntity reservationEntity2 = new ReservationEntity();

        List<ReservationEntity> reservationEntities = new ArrayList<>();
        reservationEntities.add(reservationEntity1);
        reservationEntities.add(reservationEntity2);

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(1L);
        roomEntity.setNumber("100");
        roomEntity.setPrice(new BigDecimal(29.99));
        roomEntity.setHotelByHotelId(hotelEntity);
        roomEntity.setReservationsById(reservationEntities);

        this.roomEntity = roomEntity;

        HotelDto hotelDto = new HotelDtoImpl();

        ReservationDto reservationDto1 = new ReservationDtoImpl();
        ReservationDto reservationDto2 = new ReservationDtoImpl();

        List<ReservationDto> reservationDtos = new ArrayList<>();
        reservationDtos.add(reservationDto1);
        reservationDtos.add(reservationDto2);

        RoomDto roomDto = new RoomDtoImpl();
        roomDto.setId(1L);
        roomDto.setNumber("100");
        roomDto.setPrice(new BigDecimal(29.99));
        roomDto.setHotelByHotelId(hotelDto);
        roomDto.setReservationsById(reservationDtos);

        this.roomDto = roomDto;
    }

    @Test
    public void testConvertEntityToDto() throws Exception {
        RoomDto roomDto = RoomConvertor.convertEntityToDto(roomEntity);

        Assert.assertEquals(roomDto.getId(), roomEntity.getId());
        Assert.assertEquals(roomDto.getNumber(), roomEntity.getNumber());
        Assert.assertEquals(roomDto.getPrice(), roomEntity.getPrice());
        Assert.assertNotNull(roomDto.getHotelByHotelId());
        Assert.assertEquals(roomDto.getReservationsById().size(), 2);
    }

    @Test
    public void testConvertDtoToEntity() throws Exception {
        RoomEntity roomEntity = RoomConvertor.convertDtoToEntity(roomDto);

        Assert.assertEquals(roomEntity.getId(), roomDto.getId());
        Assert.assertEquals(roomEntity.getNumber(), roomDto.getNumber());
        Assert.assertEquals(roomEntity.getPrice(), roomDto.getPrice());
        Assert.assertNotNull(roomEntity.getHotelByHotelId());
        Assert.assertEquals(roomEntity.getReservationsById().size(), 2);
    }
}
