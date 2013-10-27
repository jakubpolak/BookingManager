package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Component("hotelConvertor")
public class HotelConvertorImpl extends GenericConvertorImpl<HotelEntity, HotelDto>
{
    /**
     * {@inheritDoc}
     */
    public HotelDto convertEntityToDto(HotelEntity hotelEntity) {
        if (hotelEntity == null) {
            throw new IllegalArgumentException("HotelEntity can't be null.");
        }

        HotelDto hotelDto = new HotelDtoImpl();
        BeanUtils.copyProperties(hotelEntity, hotelDto, new String[] {"roomsById"});

        // Room Entities -> Room DTOs
        List<RoomEntity> roomEntities = hotelEntity.getRoomsById();

        if (roomEntities != null){
            List<RoomDto> roomDtos = new ArrayList<>();

            for (RoomEntity roomEntity : roomEntities){
                RoomDto roomDto = new RoomDtoImpl();
                BeanUtils.copyProperties(roomEntity, roomDto);
                roomDto.setHotelByHotelId(hotelDto);
                roomDtos.add(roomDto);
            }

            hotelDto.setRoomsById(roomDtos);
        }

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
        BeanUtils.copyProperties(hotelDto, hotelEntity, new String[] {"roomsById"});

        // Room DTOs -> Room Entities
        List<RoomDto> roomDtos = hotelDto.getRoomsById();

        if (roomDtos != null){
            List<RoomEntity> roomEntities = new ArrayList<>();

            for (RoomDto roomDto : roomDtos){
                RoomEntity roomEntity = new RoomEntity();
                BeanUtils.copyProperties(roomDto, roomEntity);
                roomEntity.setHotelByHotelId(hotelEntity);
                roomEntities.add(roomEntity);
            }

            hotelEntity.setRoomsById(roomEntities);
        }

        return hotelEntity;
    }
}
