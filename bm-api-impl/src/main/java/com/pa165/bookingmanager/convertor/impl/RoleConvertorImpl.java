package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component("roleConvertor")
public class RoleConvertorImpl extends GenericConvertorImpl<RoleEntity, RoleDto>
{
    /**
     * Properties to be ignored by BeanUtils.copyProperties method
     */
    private String[] ignoreProperties = {"usersById"};

    /**
     * {@inheritDoc}
     */
    public RoleDto convertEntityToDto(RoleEntity roleEntity) {
        if (roleEntity == null) {
            throw new IllegalArgumentException("RoleEntity can't be null.");
        }

        RoleDto roleDto = new RoleDtoImpl();
        BeanUtils.copyProperties(roleEntity, roleDto, ignoreProperties);

        return roleDto;
    }

    /**
     * {@inheritDoc}
     */
    public RoleEntity convertDtoToEntity(RoleDto roleDto) {
        if (roleDto == null) {
            throw new IllegalArgumentException("RoleDto can't be null.");
        }

        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDto, roleEntity, ignoreProperties);

        return roleEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void convertDtoToEntity(RoleDto roleDto, RoleEntity roleEntity) {
        if (roleDto == null){
            throw new IllegalArgumentException("RoleDto can't be null.");
        }

        if (roleEntity == null){
            throw new IllegalArgumentException("RoleEntity can't be null.");
        }

        BeanUtils.copyProperties(roleDto, roleEntity, ignoreProperties);
    }
}
