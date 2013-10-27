package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component
public class ReservationConvertorImpl extends GenericConvertorImpl<ReservationEntity, ReservationDto>
{
    @Autowired
    RoomConvertorImpl roomConvertor;

    /**
     * {@inheritDoc}
     */
    public  ReservationDto convertEntityToDto(ReservationEntity reservationEntity) {
        if (reservationEntity == null) {
            throw new IllegalArgumentException("ReservationEntity can't be null.");
        }

        ReservationDto reservationDto = new ReservationDtoImpl();
        BeanUtils.copyProperties(reservationEntity, reservationDto, new String[] {"roomByRoomId"});

        // Room Entity -> Room DTO
        RoomEntity roomEntity = reservationEntity.getRoomByRoomId();

        if (roomEntity != null){
            reservationDto.setRoomByRoomId(
                roomConvertor.convertEntityToDto(roomEntity)
            );
        }

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
        BeanUtils.copyProperties(dto, entity, new String[] {"roomByRoomId"});

        // Room DTO -> Room Entity
        RoomDto roomDto = dto.getRoomByRoomId();

        if (roomDto != null){
            entity.setRoomByRoomId(
                roomConvertor.convertDtoToEntity(roomDto)
            );
        }

        return entity;
    }
}
