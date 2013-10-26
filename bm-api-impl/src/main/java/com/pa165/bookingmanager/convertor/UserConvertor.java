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
     * @param entity
     * @return user entity
     */
    public static UserDto convertEntityToDto(UserEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("UserEntity can't be null.");
        }

        UserDto dto = new UserDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Role Entity -> Role DTO
        RoleEntity roleEntity = entity.getRoleByRoleId();

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
     * @param dto
     * @return user entity
     */
    public static UserEntity convertDtoToEntity(UserDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto, entity);

        // Role DTO –> Role Entity
        RoleDto roleDto = dto.getRoleByRoleId();

        if (roleDto != null){
            entity.setRoleByRoleId(
                RoleConvertor.convertDtoToEntity(roleDto)
            );
        }

        return entity;
    }
}
