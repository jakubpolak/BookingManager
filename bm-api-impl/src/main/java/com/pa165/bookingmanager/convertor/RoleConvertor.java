package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.entity.UserEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class RoleConvertor
{
    /**
     * Convert entity to DTO
     *
     * @param entity
     * @return role entity
     */
    public static RoleDto convertEntityToDto(RoleEntity entity) {
        if (entity == null) return null;

        RoleDto dto = new RoleDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // User Entities -> User DTOs
        List<UserEntity> userEntities = entity.getUsersById();
        List<UserDto> userDtos = new ArrayList<>();

        for (UserEntity userEntity : userEntities){
            userDtos.add(
                UserConvertor.convertEntityToDto(userEntity)
            );
        }

        dto.setUsersById(userDtos);

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return role entity
     */
    public static RoleEntity convertDtoToEntity(RoleDto dto) {
        if (dto == null) return null;

        RoleEntity entity = new RoleEntity();
        BeanUtils.copyProperties(dto, entity);

        // User DTOs -> User Entities
        List<UserDto> userDtos = dto.getUsersById();
        List<UserEntity> userEntities = new ArrayList<>();

        for (UserDto userDto : userDtos){
            userEntities.add(
                UserConvertor.convertDtoToEntity(userDto)
            );
        }

        entity.setUsersById(userEntities);

        return entity;
    }
}
