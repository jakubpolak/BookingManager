package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
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
        if (entity == null) return null;

        UserDto dto = new UserDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Role Entity -> Role DTO
        dto.setRoleByRoleId(
            RoleConvertor.convertEntityToDto(
                entity.getRoleByRoleId()
            )
        );

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return user entity
     */
    public static UserEntity convertDtoToEntity(UserDto dto) {
        if (dto == null) return null;

        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(dto, entity);

        // Role DTO –> Role Entity
        entity.setRoleByRoleId(
            RoleConvertor.convertDtoToEntity(
                dto.getRoleByRoleId()
            )
        );

        return entity;
    }
}
