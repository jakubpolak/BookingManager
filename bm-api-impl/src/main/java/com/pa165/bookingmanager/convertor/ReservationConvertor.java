package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author Jakub Polak
 */
public class ReservationConvertor
{
    /**
     * Convert entity to DTO
     *
     * @param reservationEntity
     * @return reservation entity
     */
    public static ReservationDto convertEntityToDto(ReservationEntity reservationEntity) {
        if (reservationEntity == null) {
            throw new IllegalArgumentException("ReservationEntity can't be null.");
        }

        ReservationDto reservationDto = new ReservationDtoImpl();
        BeanUtils.copyProperties(reservationEntity, reservationDto, new String[] {"roomByRoomId"});

        // Room Entity -> Room DTO
        RoomEntity roomEntity = reservationEntity.getRoomByRoomId();

        if (roomEntity != null){
            reservationDto.setRoomByRoomId(
                RoomConvertor.convertEntityToDto(roomEntity)
            );
        }

        return reservationDto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return reservation entity
     */
    public static ReservationEntity convertDtoToEntity(ReservationDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ReservationDto can't be null.");
        }

        ReservationEntity entity = new ReservationEntity();
        BeanUtils.copyProperties(dto, entity, new String[] {"roomByRoomId"});

        // Room DTO -> Room Entity
        RoomDto roomDto = dto.getRoomByRoomId();

        if (roomDto != null){
            entity.setRoomByRoomId(
                RoomConvertor.convertDtoToEntity(roomDto)
            );
        }

        return entity;
    }
}
