package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Josef Stribny, Jakub Polak
 */

public class HotelConvertor
{
    /**
     * Convert entity to DTO
     *
     * @param entity
     * @return hotel entity
     */
    public static HotelDto convertEntityToDto(HotelEntity entity) {
        if (entity == null) return null;

        HotelDto dto = new HotelDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Room Entities -> Room DTOs
        List<RoomDto> roomDtos = new ArrayList<>();
        List<RoomEntity> roomEntities = entity.getRoomsById();

        for (RoomEntity roomEntity : roomEntities){
            roomDtos.add(
                RoomConvertor.convertEntityToDto(roomEntity)
            );
        }

        dto.setRoomsById(roomDtos);

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return hotel entity
     */
    public static HotelEntity convertDtoToEntity(HotelDto dto) {
        if (dto == null) return null;

        HotelEntity entity = new HotelEntity();
        BeanUtils.copyProperties(dto, entity);

        // Room DTOs -> Room Entities
        List<RoomDto> roomDtos = dto.getRoomsById();
        List<RoomEntity> roomEntities = new ArrayList<>();

        for (RoomDto roomDto : roomDtos){
            roomEntities.add(
                RoomConvertor.convertDtoToEntity(roomDto)
            );
        }

        entity.setRoomsById(roomEntities);

        return entity;
    }
}
