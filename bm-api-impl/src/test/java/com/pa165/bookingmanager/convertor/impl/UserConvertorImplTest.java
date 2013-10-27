package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.TestSetup;
import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.entity.UserEntity;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jakub Polak
 */

public class UserConvertorImplTest extends TestSetup
{
    private UserDto userDto;

    private UserEntity userEntity;

    @Autowired
    private UserConvertorImpl userConvertor;

    @Before
    public void setup(){
        RoleEntity roleEntity = new RoleEntity();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("user123456@me.com");
        userEntity.setPassword("7c4a8d09ca3762af61e59520943dc26494f8941b");
        userEntity.setRoleByRoleId(roleEntity);

        this.userEntity = userEntity;

        RoleDto roleDto = new RoleDtoImpl();

        UserDto userDto = new UserDtoImpl();
        userDto.setId(1L);
        userDto.setEmail("user123456@me.com");
        userDto.setPassword("7c4a8d09ca3762af61e59520943dc26494f8941b");
        userDto.setRoleByRoleId(roleDto);

        this.userDto = userDto;
    }

    @Test
    public void testConvertEntityToDto() throws Exception {
        UserDto userDto = userConvertor.convertEntityToDto(userEntity);

        Assert.assertEquals(userDto.getId(), userEntity.getId());
        Assert.assertEquals(userDto.getEmail(), userEntity.getEmail());
        Assert.assertEquals(userDto.getPassword(), userEntity.getPassword());
        Assert.assertNotNull(userDto.getRoleByRoleId());
    }

    @Test
    public void testConvertDtoToEntity() throws Exception {
        UserEntity userEntity = userConvertor.convertDtoToEntity(userDto);

        Assert.assertEquals(userEntity.getId(), userDto.getId());
        Assert.assertEquals(userEntity.getEmail(), userDto.getEmail());
        Assert.assertEquals(userEntity.getPassword(), userDto.getPassword());
        Assert.assertNotNull(userEntity.getRoleByRoleId());
    }
}
