package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.ReservationConvertorImpl;
import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.service.ReservationService;
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
public class ReservationServiceImplTest extends TestServiceSetup
{
    @Mock
    private ReservationDao reservationDao;

    @Mock
    private ReservationConvertorImpl reservationConvertor;

    private ReservationService reservationService;

    @Before
    public void setup() throws Exception{
        super.setup();
        reservationService = new ReservationServiceImpl(reservationDao, reservationConvertor);
    }

    @Test
    public void testFindAll() throws Exception {
        List<ReservationEntity> reservationEntities = new ArrayList<>();
        List<ReservationDto> reservationDtos = new ArrayList<>();

        reservationEntities.add(new ReservationEntity());
        reservationDtos.add(new ReservationDtoImpl());

        when(reservationDao.findAll()).thenReturn(reservationEntities);
        when(reservationConvertor.convertEntityListToDtoList(reservationEntities)).thenReturn(reservationDtos);

        Assert.assertEquals(1, reservationService.findAll().size());
    }

    @Test
    public void testFind() throws Exception {
        ReservationEntity reservationEntity = new ReservationEntity();
        ReservationDto reservationDto = new ReservationDtoImpl();

        when(reservationDao.find(1L)).thenReturn(reservationEntity);
        when(reservationDao.find(999L)).thenReturn(null);
        when(reservationConvertor.convertEntityToDto(reservationEntity)).thenReturn(reservationDto);

        Assert.assertNotNull(reservationService.find(1L));

        Assert.assertNull(reservationService.find(999L));

    }

    @Test
    public void testFindByRoom() throws Exception {
         Assert.fail("Test needs to be implemented.");
    }
}
