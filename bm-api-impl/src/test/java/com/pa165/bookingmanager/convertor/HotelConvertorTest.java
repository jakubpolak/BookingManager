package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.TestSetup;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class HotelConvertorTest  extends TestSetup
{
    private HotelEntity hotelEntity;

    private HotelDto hotelDto;

    @Before
    public void setup(){
        RoomEntity roomEntity1 = new RoomEntity();
        RoomEntity roomEntity2 = new RoomEntity();

        List<RoomEntity> roomEntities = new ArrayList<>();
        roomEntities.add(roomEntity1);
        roomEntities.add(roomEntity2);

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(1L);
        hotelEntity.setName("Hotel Imperial");
        hotelEntity.setRoomsById(roomEntities);

        this.hotelEntity = hotelEntity;

        RoomDto roomDto1 = new RoomDtoImpl();
        RoomDto roomDto2 = new RoomDtoImpl();

        List<RoomDto> roomDtos = new ArrayList<>();
        roomDtos.add(roomDto1);
        roomDtos.add(roomDto2);

        HotelDto hotelDto = new HotelDtoImpl();
        hotelDto.setId(1L);
        hotelDto.setName("Hotel Imperial");
        hotelDto.setRoomsById(roomDtos);

        this.hotelDto = hotelDto;
    }

    @Test
    public void testConvertEntityToDto() throws Exception {
        HotelDto hotelDto = HotelConvertor.convertEntityToDto(hotelEntity);

        Assert.assertEquals(hotelDto.getId(), hotelEntity.getId());
        Assert.assertEquals(hotelDto.getName(), hotelEntity.getName());
        Assert.assertEquals(hotelDto.getRoomsById().size(), 2);
    }

    @Test
    public void testConvertDtoToEntity() throws Exception {
        HotelEntity hotelEntity = HotelConvertor.convertDtoToEntity(hotelDto);

        Assert.assertEquals(hotelEntity.getId(), hotelDto.getId());
        Assert.assertEquals(hotelEntity.getName(), hotelDto.getName());
        Assert.assertEquals(hotelEntity.getRoomsById().size(), 2);
    }
}
