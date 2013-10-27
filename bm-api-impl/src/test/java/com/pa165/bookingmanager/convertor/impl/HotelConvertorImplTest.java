package com.pa165.bookingmanager.convertor.impl;

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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class HotelConvertorImplTest extends TestSetup
{
    private HotelEntity hotelEntity;

    private HotelDto hotelDto;

    @Autowired
    private HotelConvertorImpl hotelConvertor;

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
        HotelDto hotelDto = hotelConvertor.convertEntityToDto(hotelEntity);

        Assert.assertEquals(hotelDto.getId(), hotelEntity.getId());
        Assert.assertEquals(hotelDto.getName(), hotelEntity.getName());
        Assert.assertEquals(hotelDto.getRoomsById().size(), 2);
    }

    @Test
    public void testConvertDtoToEntity() throws Exception {
        HotelEntity hotelEntity = hotelConvertor.convertDtoToEntity(hotelDto);

        Assert.assertEquals(hotelEntity.getId(), hotelDto.getId());
        Assert.assertEquals(hotelEntity.getName(), hotelDto.getName());
        Assert.assertEquals(hotelEntity.getRoomsById().size(), 2);
    }

    @Test
    public void testConvertEntityListToDtoList() throws Exception{
        HotelEntity hotelEntity1 = new HotelEntity();
        HotelEntity hotelEntity2 = new HotelEntity();

        List<HotelEntity> hotelEntities = new ArrayList<>();
        hotelEntities.add(hotelEntity1);
        hotelEntities.add(hotelEntity2);

        List<HotelDto> hotelDtos = hotelConvertor.convertEntityListToDtoList(hotelEntities);
        Assert.assertEquals(hotelDtos.size(), 2);
    }

    @Test
    public void testConvertDtoListToEntityList() throws Exception{
        HotelDto hotelDto1 = new HotelDtoImpl();
        HotelDto hotelDto2 = new HotelDtoImpl();

        List<HotelDto> hotelDtos = new ArrayList<>();
        hotelDtos.add(hotelDto1);
        hotelDtos.add(hotelDto2);

        List<HotelEntity> hotelEntities = hotelConvertor.convertDtoListToEntityList(hotelDtos);
        Assert.assertEquals(hotelEntities.size(), 2);
    }
}
