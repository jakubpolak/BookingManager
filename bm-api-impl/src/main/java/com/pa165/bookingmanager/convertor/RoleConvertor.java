package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.entity.RoleEntity;

/**
 * @author Josef Stribny
 */
public interface RoleConvertor extends Convertor<RoleEntity, RoleDto> {
    @Override
    public RoleDto convertEntityToDto(RoleEntity entity);

    @Override
    public RoleEntity convertDtoToEntity(RoleDto dto);
}
