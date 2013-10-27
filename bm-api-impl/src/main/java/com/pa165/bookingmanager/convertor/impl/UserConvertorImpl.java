package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component("userConvertor")
public class UserConvertorImpl extends GenericConvertorImpl<UserEntity, UserDto>
{
    @Autowired
    RoleConvertorImpl roleConvertor;

    /**
     * {@inheritDoc}
     */
    public UserDto convertEntityToDto(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("UserEntity can't be null.");
        }

        UserDto dto = new UserDtoImpl();
        BeanUtils.copyProperties(userEntity, dto, new String[] {"roleByRoleId"});

        // Role Entity -> Role DTO
        RoleEntity roleEntity = userEntity.getRoleByRoleId();

        if (roleEntity != null){
            dto.setRoleByRoleId(
                roleConvertor.convertEntityToDto(roleEntity)
            );
        }

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
        BeanUtils.copyProperties(userDto, userEntity, new String[] {"roleByRoleId"});

        // Role DTO –> Role Entity
        RoleDto roleDto = userDto.getRoleByRoleId();

        if (roleDto != null){
            userEntity.setRoleByRoleId(
                roleConvertor.convertDtoToEntity(roleDto)
            );
        }

        return userEntity;
    }
}
