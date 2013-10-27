package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component("hotelConvertor")
public class HotelConvertorImpl extends GenericConvertorImpl<HotelEntity, HotelDto>
{
    /**
     * Properties to be ignored by BeanUtils.copyProperties method
     */
    private String[] ignoreProperties = {"roomsById", "reservationsById"};

    /**
     * {@inheritDoc}
     */
    public HotelDto convertEntityToDto(HotelEntity hotelEntity) {
        if (hotelEntity == null) {
            throw new IllegalArgumentException("HotelEntity can't be null.");
        }

        HotelDto hotelDto = new HotelDtoImpl();
        BeanUtils.copyProperties(hotelEntity, hotelDto, ignoreProperties);

        return hotelDto;
    }

    /**
     * {@inheritDoc}
     */
    public HotelEntity convertDtoToEntity(HotelDto hotelDto) {
        if (hotelDto == null){
            throw new IllegalArgumentException("HotelDto can't be null.");
        }

        HotelEntity hotelEntity = new HotelEntity();
        BeanUtils.copyProperties(hotelDto, hotelEntity, ignoreProperties);

        return hotelEntity;
    }

    /**
     * {@inheritDoc}
     */
    public void convertDtoToEntity(HotelDto hotelDto, HotelEntity hotelEntity){
        if (hotelDto == null){
            throw new IllegalArgumentException("HotelDto can't be null.");
        }

        if (hotelEntity == null){
            throw new IllegalArgumentException("HotelEntity can't be null.");
        }

        BeanUtils.copyProperties(hotelDto, hotelEntity, ignoreProperties);
    }
}
