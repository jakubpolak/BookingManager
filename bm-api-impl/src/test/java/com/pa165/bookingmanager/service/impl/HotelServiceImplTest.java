package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.HotelConvertorImpl;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.service.HotelService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
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

    private HotelService hotelService;

    @Before
    public void setup() throws Exception{
        super.setup();
        hotelService = new HotelServiceImpl(hotelDao, hotelConvertor);
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
        HotelDto hotelDto = new HotelDtoImpl();

        when(hotelDao.find(1L)).thenReturn(hotelEntity);
        when(hotelDao.find(999L)).thenReturn(null);
        when(hotelConvertor.convertEntityToDto(hotelEntity)).thenReturn(hotelDto);

        Assert.assertNotNull(hotelService.find(1L));

        Assert.assertNull(hotelService.find(999L));
    }

    @Test
    public void testFindWithRooms() throws Exception {
        Assert.fail("Test needs to be implemented");
    }
}
