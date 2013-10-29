package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.UserConvertorImpl;
import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
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

    private UserServiceImpl userService;

    @Before
    public void setup() throws Exception {
        super.setup();
        userService = new UserServiceImpl(userDao, userConvertor);
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
    public void testFindOneByEmail() throws Exception {
        UserEntity userEntity = new UserEntity();
        UserDto userDto = new UserDtoImpl();

        when(userDao.find(1L)).thenReturn(userEntity);
        when(userDao.find(999L)).thenReturn(null);
        when(userConvertor.convertEntityToDto(userEntity)).thenReturn(userDto);

        Assert.assertNotNull(userService.find(1L));

        Assert.assertNull(userService.find(999L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindIllegalArgumentException() throws Exception {
        userService.find(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateIllegalArgumentException() throws Exception {
        userService.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateIllegalArgumentException() throws Exception {
        userService.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIllegalArgumentException() throws Exception {
        userService.delete(null);
    }
}
