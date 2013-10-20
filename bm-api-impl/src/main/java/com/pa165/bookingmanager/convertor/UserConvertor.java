package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.entity.UserEntity;

/**
 * @author Josef Stribny
 */
public interface UserConvertor extends Convertor<UserEntity, UserDto> {
    @Override
    public UserDto convertEntityToDto(UserEntity entity);

    @Override
    public UserEntity convertDtoToEntity(UserDto dto);
}
