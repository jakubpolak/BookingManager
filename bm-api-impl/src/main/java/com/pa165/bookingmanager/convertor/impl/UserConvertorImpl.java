package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component("userConvertor")
public class UserConvertorImpl extends GenericConvertorImpl<UserEntity, UserDto>
{
    /**
     * Properties to be ignored by BeanUtils.copyProperties method
     */
    private String[] ignoreProperties = {"roleByRoleId"};

    /**
     * {@inheritDoc}
     */
    public UserDto convertEntityToDto(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("UserEntity can't be null.");
        }

        UserDto dto = new UserDtoImpl();
        BeanUtils.copyProperties(userEntity, dto, ignoreProperties);

        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public UserEntity convertDtoToEntity(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity, ignoreProperties);

        return userEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void convertDtoToEntity(UserDto userDto, UserEntity userEntity) {
        if (userDto == null){
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        if (userEntity == null){
            throw new IllegalArgumentException("UserEntity can't be null.");
        }

        BeanUtils.copyProperties(userDto, userEntity, ignoreProperties);
    }
}
