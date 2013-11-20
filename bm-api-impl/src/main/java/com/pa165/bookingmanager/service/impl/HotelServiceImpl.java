package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.convertor.impl.HotelConvertorImpl;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import com.pa165.bookingmanager.service.HotelService;
import com.pa165.bookingmanager.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jana Polakova, Jakub Polak
 */
@Service("hotelService")
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService
{
    @Autowired
    HotelDao hotelDao;
    
    @Autowired
    RoomDao roomDao;

    @Autowired
    HotelConvertorImpl hotelConvertor;
    
    @Autowired
    RoomService roomService;

    /**
     * Constructor
     */
    public HotelServiceImpl(){

    }

    /**
     * Constructor
     *
     * @param hotelDao hotel dao
     * @param hotelConvertor hotel convertor
     */
    public HotelServiceImpl(HotelDao hotelDao, HotelConvertorImpl hotelConvertor, RoomService roomService){
        if (hotelDao == null){
            throw new IllegalArgumentException("HotelDao can't be null.");
        }

        this.hotelDao = hotelDao;

        if (hotelConvertor == null){
            throw new IllegalArgumentException("HotelConvertor can't be null.");
        }

        this.roomService = roomService;

        if (roomService == null){
            throw new IllegalArgumentException("RoomService can't be null.");
        }

        this.hotelConvertor = hotelConvertor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<HotelDto> findAll() {
        List<HotelEntity> hotelEntities = hotelDao.findAll();
        List<HotelDto> hotelDtos = null;

        if (hotelEntities != null){
            hotelDtos = hotelConvertor.convertEntityListToDtoList(hotelEntities);
        }

        return hotelDtos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HotelDto find(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        HotelEntity hotelEntity = hotelDao.find(id);
        HotelDto hotelDto = null;

        if (hotelEntity != null){
            hotelDto = hotelConvertor.convertEntityToDto(hotelEntity);
        }

        return hotelDto;
    }
    
    /**
     * {@inheritDoc}
     */
    public HotelDto findByRoomId(Long id) {
    	if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        RoomEntity roomEntity = roomDao.find(id);
        HotelEntity hotelEntity = roomEntity.getHotelByHotelId();
        
        HotelDto hotelDto = null;

        if (hotelEntity != null){
            hotelDto = hotelConvertor.convertEntityToDto(hotelEntity);
        }

        return hotelDto;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public HotelDto findWithRooms(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        HotelEntity hotelEntity = hotelDao.find(id);
        HotelDto hotelDto = null;

        if (hotelEntity != null){
            hotelDto = hotelConvertor.convertEntityToDto(hotelEntity);
            hotelDto.setRoomsById(
                roomService.findByHotel(hotelEntity.getId())
            );
        }

        return hotelDto;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public HotelDto findWithAvailableRooms(Long id, Date from, Date to) {
        if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        HotelEntity hotelEntity = hotelDao.find(id);

        HotelDto hotelDto = null;
        if (hotelEntity != null){
            hotelDto = hotelConvertor.convertEntityToDto(hotelEntity);
            hotelDto.setRoomsById(
            	roomService.findAvailableByHotel(hotelEntity.getId(), from, to)
            );
        }

        return hotelDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void create(HotelDto hotelDto) {
        if (hotelDto == null){
            throw new IllegalArgumentException("HotelDto can't be null.");
        }

        hotelDao.create(hotelConvertor.convertDtoToEntity(hotelDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void update(HotelDto hotelDto) {
        if (hotelDto == null){
            throw new IllegalArgumentException("HotelDto can't be null.");
        }

        HotelEntity hotelEntity = hotelDao.find(hotelDto.getId());

        if (hotelEntity != null){
            hotelConvertor.convertDtoToEntity(hotelDto, hotelEntity);
            hotelDao.update(hotelEntity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(HotelDto hotelDto) {
        if (hotelDto == null){
            throw new IllegalArgumentException("HotelDto can't be null.");
        }

        HotelEntity hotelEntity = hotelDao.find(hotelDto.getId());

        if (hotelEntity != null){
            hotelDao.delete(hotelEntity);
        }
    }
}
