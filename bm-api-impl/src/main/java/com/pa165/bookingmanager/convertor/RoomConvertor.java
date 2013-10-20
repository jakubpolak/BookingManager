package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.entity.RoomEntity;

/**
 * @author Josef Stribny
 */
public interface RoomConvertor extends Convertor<RoomEntity, RoomDto> {
    @Override
    public RoomDto convertEntityToDto(RoomEntity entity);

    @Override
    public RoomEntity convertDtoToEntity(RoomDto dto);
}
