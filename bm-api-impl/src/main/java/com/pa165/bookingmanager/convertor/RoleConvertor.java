package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
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
     * @param roleEntity
     * @return role entity
     */
    public static RoleDto convertEntityToDto(RoleEntity roleEntity) {
        if (roleEntity == null) {
            throw new IllegalArgumentException("RoleEntity can't be null.");
        }

        RoleDto roleDto = new RoleDtoImpl();
        BeanUtils.copyProperties(roleEntity, roleDto, new String[] {"usersById"});

        // User Entities -> User DTOs
        List<UserEntity> userEntities = roleEntity.getUsersById();

        if (userEntities != null){
            List<UserDto> userDtos = new ArrayList<>();

            for (UserEntity userEntity : userEntities){
                UserDto userDto = new UserDtoImpl();
                BeanUtils.copyProperties(userEntity, userDto, new String[] {"roleByRoleId"});
                userDto.setRoleByRoleId(roleDto);
                userDtos.add(userDto);
            }

            roleDto.setUsersById(userDtos);
        }

        return roleDto;
    }

    /**
     * Convert DTO to entity
     *
     * @param roleDto
     * @return role entity
     */
    public static RoleEntity convertDtoToEntity(RoleDto roleDto) {
        if (roleDto == null) {
            throw new IllegalArgumentException("RoleDto can't be null.");
        }

        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDto, roleEntity, new String[] {"usersById"});

        // User DTOs -> User Entities
        List<UserDto> userDtos = roleDto.getUsersById();

        if (userDtos != null){
            List<UserEntity> userEntities = new ArrayList<>();

            for (UserDto userDto : userDtos){
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(userDto, userEntity, new String[] {"roleByRoleId"});
                userEntity.setRoleByRoleId(roleEntity);
                userEntities.add(userEntity);
            }

            roleEntity.setUsersById(userEntities);
        }

        return roleEntity;
    }
}
