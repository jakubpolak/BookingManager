package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.HotelConvertorImpl;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.service.HotelService;
import com.pa165.bookingmanager.service.RoomService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author Jakub Polak, Jan Hrubes
 */
public class HotelServiceImplTest extends TestServiceSetup
{
    @Mock
    private HotelDao hotelDao;

    @Mock
    private HotelConvertorImpl hotelConvertor;

    @Mock
    private RoomService roomService;

    private HotelService hotelService;

    @Before
    public void setup() throws Exception{
        super.setup();
        hotelService = new HotelServiceImpl(hotelDao, hotelConvertor, roomService);
    }

    @Test
    public void testFindAll() throws Exception {
        List<HotelEntity> hotelEntities = new ArrayList<>();
        List<HotelDto> hotelDtos = new ArrayList<>();

        hotelEntities.add(new HotelEntity());
        hotelDtos.add(new HotelDtoImpl());

        when(hotelDao.findAll()).thenReturn(hotelEntities);
        when(hotelConvertor.convertEntityListToDtoList(hotelEntities)).thenReturn(hotelDtos);

        Assert.assertEquals(1, hotelService.findAll().size());
    }

    @Test
    public void testFind() throws Exception {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(1L);
        HotelDto hotelDto = new HotelDtoImpl();
        hotelDto.setId(1L);

        when(hotelDao.find(hotelEntity.getId())).thenReturn(hotelEntity);
        when(hotelConvertor.convertEntityToDto(hotelEntity)).thenReturn(hotelDto);

        Assert.assertNotNull(hotelService.find(hotelEntity.getId()));
    }

    @Test
    public void testFindByRoomId(){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(1L);
        HotelDto hotelDto = new HotelDtoImpl();
        hotelDto.setId(1L);
        Date from = new Date();
        Date to = new Date();
        List<RoomDto> roomDtos = new ArrayList<>();

        when(hotelDao.find(hotelEntity.getId())).thenReturn(hotelEntity);
        when(hotelConvertor.convertEntityToDto(hotelEntity)).thenReturn(hotelDto);
        when(roomService.findAvailableByHotel(hotelEntity.getId(), from, to)).thenReturn(roomDtos);

        Assert.assertEquals(hotelDto, hotelService.findWithAvailableRooms(hotelDto.getId(), from, to));
    }

    @Test
    public void testFindWithRooms() throws Exception {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(1L);
        HotelDto hotelDto = new HotelDtoImpl();
        hotelDto.setId(1L);
        List<RoomDto> roomDtos = new ArrayList<>();

        when(hotelDao.find(hotelEntity.getId())).thenReturn(hotelEntity);
        when(hotelConvertor.convertEntityToDto(hotelEntity)).thenReturn(hotelDto);
        when(roomService.findByHotel(hotelEntity.getId())).thenReturn(roomDtos);

        Assert.assertEquals(hotelDto, hotelService.findWithRooms(hotelDto.getId()));
    }

    @Test
    public void testFindWithAvailableRooms(){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(1L);
        HotelDto hotelDto = new HotelDtoImpl();
        hotelDto.setId(1L);
        List<RoomDto> roomDtos = new ArrayList<>();
        Date from = new Date();
        Date to = new Date();

        when(hotelDao.find(hotelEntity.getId())).thenReturn(hotelEntity);
        when(hotelConvertor.convertEntityToDto(hotelEntity)).thenReturn(hotelDto);
        when(roomService.findAvailableByHotel(hotelEntity.getId(), from, to)).thenReturn(roomDtos);

        Assert.assertEquals(hotelDto, hotelService.findWithAvailableRooms(hotelDto.getId(), from, to));
    }
}
