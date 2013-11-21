package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.ReservationConvertorImpl;
import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import com.pa165.bookingmanager.service.ReservationService;
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
public class ReservationServiceImplTest extends TestServiceSetup
{
    @Mock
    private ReservationDao reservationDao;

    @Mock
    private ReservationConvertorImpl reservationConvertor;

    @Mock
    private RoomDao roomDao;

    private ReservationService reservationService;

    @Before
    public void setup() throws Exception{
        super.setup();
        reservationService = new ReservationServiceImpl(reservationDao, reservationConvertor, roomDao);
    }

    @Test
    public void testFindAll() throws Exception {
        List<ReservationEntity> reservationEntities = new ArrayList<ReservationEntity>();
        List<ReservationDto> reservationDtos = new ArrayList<ReservationDto>();

        reservationEntities.add(new ReservationEntity());
        reservationDtos.add(new ReservationDtoImpl());

        when(reservationDao.findAll()).thenReturn(reservationEntities);
        when(reservationConvertor.convertEntityListToDtoList(reservationEntities)).thenReturn(reservationDtos);

        Assert.assertEquals(1, reservationService.findAll().size());
    }

    @Test
    public void testFind() throws Exception {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setId(1L);
        ReservationDto reservationDto = new ReservationDtoImpl();
        reservationDto.setId(1L);

        when(reservationDao.find(reservationEntity.getId())).thenReturn(reservationEntity);
        when(reservationConvertor.convertEntityToDto(reservationEntity)).thenReturn(reservationDto);

        Assert.assertNotNull(reservationService.find(reservationDto.getId()));

    }

    @Test
    public void testFindByRoom() throws Exception{
        List<ReservationEntity> reservationEntities = new ArrayList<ReservationEntity>();
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setId(1L);
        reservationEntities.add(reservationEntity);

        List<ReservationDto> reservationDtos = new ArrayList<ReservationDto>();
        ReservationDto reservationDto = new ReservationDtoImpl();
        reservationDto.setId(1L);
        reservationDtos.add(reservationDto);

        when(reservationConvertor.convertEntityListToDtoList(reservationEntities)).thenReturn(reservationDtos);
        when(reservationDao.findByRoom(reservationEntity.getId())).thenReturn(reservationEntities);

        Assert.assertEquals(1, reservationService.findByRoom(reservationDto.getId()).size());
    }

    @Test
    public void testIsRoomAvailable() throws Exception{
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(1L);

        Date reservationFrom = new Date();
        Date reservationTo = new Date();

        when(roomDao.find(roomEntity.getId())).thenReturn(roomEntity);
        when(reservationDao.isRoomAvailable(roomEntity, reservationFrom, reservationTo)).thenReturn(true);

        Assert.assertEquals(true, reservationService.isRoomAvailable(roomEntity.getId(), reservationFrom, reservationTo));
    }
}
