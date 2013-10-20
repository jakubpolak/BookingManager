package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.service.HotelService;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jana Polakova
 */
@Service("hotelService")
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService
{
    @Override
    public List<HotelDto> findAll() {
        return null;
    }

    @Override
    public List<HotelDto> findByCriteria(Criterion criterion) {
        return null;
    }

    @Override
    public HotelDto find(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void create(HotelDto hotelDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void update(HotelDto hotelDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(HotelDto hotelDto) {

    }
}
