package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component("reservationConvertor")
public class ReservationConvertorImpl extends GenericConvertorImpl<ReservationEntity, ReservationDto>
{
    /**
     * Properties to be ignored by BeanUtils.copyProperties method
     */
    private String[] ignoreProperties = {"roomByRoomId"};

    /**
     * {@inheritDoc}
     */
    public  ReservationDto convertEntityToDto(ReservationEntity reservationEntity) {
        if (reservationEntity == null) {
            throw new IllegalArgumentException("ReservationEntity can't be null.");
        }

        ReservationDto reservationDto = new ReservationDtoImpl();
        BeanUtils.copyProperties(reservationEntity, reservationDto, ignoreProperties);

        return reservationDto;
    }

    /**
     * {@inheritDoc}
     */
    public  ReservationEntity convertDtoToEntity(ReservationDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ReservationDto can't be null.");
        }

        ReservationEntity entity = new ReservationEntity();
        BeanUtils.copyProperties(dto, entity, ignoreProperties);

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public void convertDtoToEntity(ReservationDto reservationDto, ReservationEntity reservationEntity){
        if (reservationDto == null){
            throw new IllegalArgumentException("HotelDto can't be null.");
        }

        if (reservationEntity == null){
            throw new IllegalArgumentException("ReservationEntity can't be null.");
        }

        BeanUtils.copyProperties(reservationDto, reservationEntity, ignoreProperties);
    }
}
