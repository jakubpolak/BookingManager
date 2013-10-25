package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.entity.ReservationEntity;
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
        if (entity == null) return null;

        ReservationDto dto = new ReservationDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Room Entity -> Room DTO
        dto.setRoomByRoomId(
            RoomConvertor.convertEntityToDto(entity.getRoomByRoomId())
        );

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return reservation entity
     */
    public static ReservationEntity convertDtoToEntity(ReservationDto dto) {
        if (dto == null) return null;

        ReservationEntity entity = new ReservationEntity();
        BeanUtils.copyProperties(dto, entity);

        // Room DTO -> Room Entity
        entity.setRoomByRoomId(
            RoomConvertor.convertDtoToEntity(dto.getRoomByRoomId())
        );

        return entity;
    }
}
