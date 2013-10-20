package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.entity.ReservationEntity;

/**
 * @author Josef Stribny
 */
public interface ReservationConvertor extends Convertor<ReservationEntity, ReservationDto> {
    @Override
    public ReservationDto convertEntityToDto(ReservationEntity entity);

    @Override
    public ReservationEntity convertDtoToEntity(ReservationDto dto);
}
