package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.entity.HotelEntity;

/**
 * @author Josef Stribny
 */
public interface HotelConvertor extends Convertor<HotelEntity, HotelDto> {
    @Override
    public HotelDto convertEntityToDto(HotelEntity entity);

    @Override
    public HotelEntity convertDtoToEntity(HotelDto dto);
}
