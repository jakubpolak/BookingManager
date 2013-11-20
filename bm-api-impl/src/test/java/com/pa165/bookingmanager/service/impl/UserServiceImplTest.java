package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.RoleConvertorImpl;
import com.pa165.bookingmanager.convertor.impl.UserConvertorImpl;
import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.entity.UserEntity;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author Jakub Polak, Jan Hrubes
 */
public class UserServiceImplTest  extends TestServiceSetup
{
    @Mock
    private UserDao userDao;

    @Mock
    private UserConvertorImpl userConvertor;

    @Mock
    private RoleConvertorImpl roleConvertor;

    private UserServiceImpl userService;

    @Before
    public void setup() throws Exception {
        super.setup();
        userService = new UserServiceImpl(userDao, userConvertor, roleConvertor);
    }

    @Test
    public void testFindAll() throws Exception {
        List<UserEntity> userEntities = new ArrayList<>();
        List<UserDto> userDtos = new ArrayList<>();

        userEntities.add(new UserEntity());
        userDtos.add(new UserDtoImpl());

        when(userDao.findAll()).thenReturn(userEntities);
        when(userConvertor.convertEntityListToDtoList(userEntities)).thenReturn(userDtos);

        Assert.assertEquals(1, userService.findAll().size());
    }

    @Test
    public void testFindAllAndRoles() throws Exception {
        List<UserEntity> userEntities = new ArrayList<>();
        UserEntity userEntity = new UserEntity();
        userEntities.add(userEntity);

        List<UserDto> userDtos = new ArrayList<>();
        UserDto userDto = new UserDtoImpl();
        userDtos.add(userDto);

        RoleDto roleDto = new RoleDtoImpl();
        RoleEntity roleEntity = new RoleEntity();

        when(userDao.findAll()).thenReturn(userEntities);
        when(userConvertor.convertEntityToDto(userEntity)).thenReturn(userDto);
        when(roleConvertor.convertEntityToDto(roleEntity)).thenReturn(roleDto);

        Assert.assertEquals(1, userDtos.size());
    }

    @Test
    public void testFindOneByEmail() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);

        UserDto userDto = new UserDtoImpl();
        userDto.setId(1L);

        when(userDao.find(userEntity.getId())).thenReturn(userEntity);
        when(userConvertor.convertEntityToDto(userEntity)).thenReturn(userDto);

        Assert.assertNotNull(userService.find(userDto.getId()));
    }

    @Test
    public void testFind() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);

        UserDto userDto = new UserDtoImpl();

        RoleEntity roleEntity = new RoleEntity();
        RoleDto roleDto = new RoleDtoImpl();

        when(userDao.find(userEntity.getId())).thenReturn(userEntity);
        when(userConvertor.convertEntityToDto(userEntity)).thenReturn(userDto);
        when(roleConvertor.convertEntityToDto(roleEntity)).thenReturn(roleDto);

        Assert.assertNotNull(userDto);
    }
}
