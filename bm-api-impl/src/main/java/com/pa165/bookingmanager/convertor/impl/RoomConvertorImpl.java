package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component("roomConvertor")
public class RoomConvertorImpl extends GenericConvertorImpl<RoomEntity, RoomDto>
{
    /**
     * Properties to be ignored by BeanUtils.copyProperties method
     */
    private String[] ignoreProperties = {"hotelByHotelId", "reservationsById", "roomByRoomId"};

    /**
     * {@inheritDoc}
     */
    public RoomDto convertEntityToDto(RoomEntity roomEntity) {
        if (roomEntity == null) {
            throw new IllegalArgumentException("RoomEntity can't be null.");
        }

        RoomDto roomDto = new RoomDtoImpl();
        BeanUtils.copyProperties(roomEntity, roomDto, ignoreProperties);

        return roomDto;
    }

    /**
     * {@inheritDoc}
     */
    public RoomEntity convertDtoToEntity(RoomDto roomDto) {
        if (roomDto == null) {
            throw new IllegalArgumentException("RoomDto can't be null.");
        }

        RoomEntity roomEntity = new RoomEntity();
        BeanUtils.copyProperties(roomDto, roomEntity, ignoreProperties);

        return roomEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void convertDtoToEntity(RoomDto roomDto, RoomEntity roomEntity) {
        if (roomDto == null){
            throw new IllegalArgumentException("RoomDto can't be null.");
        }

        if (roomEntity == null){
            throw new IllegalArgumentException("RoomEntity can't be null.");
        }

        BeanUtils.copyProperties(roomDto, roomEntity, ignoreProperties);
    }
}
