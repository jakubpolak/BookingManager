package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.convertor.impl.HotelConvertorImpl;
import com.pa165.bookingmanager.dao.HotelDao;
import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.service.HotelService;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    HotelConvertorImpl hotelConvertor;

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
    public List<HotelDto> findByCriteria(Criterion criterion) {
        if (criterion == null){
            throw new IllegalArgumentException("Criterion can't be null.");
        }

        List<HotelEntity> hotelEntities = hotelDao.findByCriteria(criterion);
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
            hotelConvertor.convertEntityToDto(hotelEntity);
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

        hotelDao.update(hotelConvertor.convertDtoToEntity(hotelDto));
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

        hotelDao.delete(hotelConvertor.convertDtoToEntity(hotelDto));
    }
}
