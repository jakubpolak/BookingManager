package com.pa165.bookingmanager.convertor;

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

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class RoleConvertorTest extends TestSetup
{
    private RoleEntity roleEntity;

    private RoleDto roleDto;

    @Before
    public void setup(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(1L);
        roleEntity.setName("ROLE_ADMIN");

        UserEntity userEntity1 = new UserEntity();
        UserEntity userEntity2 = new UserEntity();

        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(userEntity1);
        userEntities.add(userEntity2);

        roleEntity.setUsersById(userEntities);

        this.roleEntity = roleEntity;

        RoleDto roleDto = new RoleDtoImpl();
        roleDto.setId(1L);
        roleDto.setName("ROLE_ADMIN");

        UserDto userDto1 = new UserDtoImpl();
        UserDto userDto2 = new UserDtoImpl();

        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(userDto1);
        userDtos.add(userDto2);

        roleDto.setUsersById(userDtos);

        this.roleDto = roleDto;
    }

    @Test
    public void testConvertEntityToDto() throws Exception {
        RoleDto roleDto = RoleConvertor.convertEntityToDto(roleEntity);

        Assert.assertEquals(roleEntity.getId(), roleDto.getId());
        Assert.assertEquals(roleEntity.getName(), roleDto.getName());
        Assert.assertEquals(2, roleDto.getUsersById().size());
    }

    @Test
    public void testConvertDtoToEntity() throws Exception {
        RoleEntity roleEntity = RoleConvertor.convertDtoToEntity(roleDto);

        Assert.assertEquals(roleDto.getId(), roleEntity.getId());
        Assert.assertEquals(roleDto.getName(), roleEntity.getName());
        Assert.assertEquals(2, roleEntity.getUsersById().size());
    }
}
