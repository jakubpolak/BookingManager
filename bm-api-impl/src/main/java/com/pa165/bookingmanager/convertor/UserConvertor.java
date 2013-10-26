package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.entity.UserEntity;
import org.springframework.beans.BeanUtils;

/**
 * @author Jakub Polak
 */
public class UserConvertor
{
    /**
     * Convert entity to DTO
     *
     * @param userEntity
     * @return user entity
     */
    public static UserDto convertEntityToDto(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("UserEntity can't be null.");
        }

        UserDto dto = new UserDtoImpl();
        BeanUtils.copyProperties(userEntity, dto, new String[] {"roleByRoleId"});

        // Role Entity -> Role DTO
        RoleEntity roleEntity = userEntity.getRoleByRoleId();

        if (roleEntity != null){
            dto.setRoleByRoleId(
                RoleConvertor.convertEntityToDto(roleEntity)
            );
        }

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param userDto
     * @return user entity
     */
    public static UserEntity convertDtoToEntity(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity, new String[] {"roleByRoleId"});

        // Role DTO –> Role Entity
        RoleDto roleDto = userDto.getRoleByRoleId();

        if (roleDto != null){
            userEntity.setRoleByRoleId(
                RoleConvertor.convertDtoToEntity(roleDto)
            );
        }

        return userEntity;
    }
}
