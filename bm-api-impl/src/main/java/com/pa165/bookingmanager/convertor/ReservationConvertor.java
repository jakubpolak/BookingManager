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
     * @param entity
     * @return reservation entity
     */
    public static ReservationDto convertEntityToDto(ReservationEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("ReservationEntity can't be null.");
        }

        ReservationDto dto = new ReservationDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Room Entity -> Room DTO
        RoomEntity roomEntity = entity.getRoomByRoomId();

        if (roomEntity != null){
            dto.setRoomByRoomId(
                RoomConvertor.convertEntityToDto(roomEntity)
            );
        }

        return dto;
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
        BeanUtils.copyProperties(dto, entity);

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
