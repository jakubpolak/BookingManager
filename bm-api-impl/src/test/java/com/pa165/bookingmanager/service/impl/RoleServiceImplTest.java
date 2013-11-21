package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.convertor.impl.ReservationConvertorImpl;
import com.pa165.bookingmanager.convertor.impl.RoleConvertorImpl;
import com.pa165.bookingmanager.dao.RoleDao;
import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.service.RoleService;
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
public class RoleServiceImplTest extends TestServiceSetup
{
    @Mock
    private RoleDao roleDao;

    @Mock
    private RoleConvertorImpl roleConvertor;

    @Mock
    private ReservationConvertorImpl reservationConvertor;

    private RoleService roleService;

    @Before
    public void setup() throws Exception {
        super.setup();
        roleService = new RoleServiceImpl(roleDao, roleConvertor);
    }

    @Test
    public void testFindAll() throws Exception {
        List<RoleEntity> roleEntities = new ArrayList<RoleEntity>();
        List<RoleDto> roleDtos = new ArrayList<RoleDto>();

        roleEntities.add(new RoleEntity());
        roleDtos.add(new RoleDtoImpl());

        when(roleDao.findAll()).thenReturn(roleEntities);
        when(roleConvertor.convertEntityListToDtoList(roleEntities)).thenReturn(roleDtos);

        Assert.assertEquals(1, roleService.findAll().size());
    }

    @Test
    public void testFind() throws Exception {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(1L);
        RoleDto roleDto = new RoleDtoImpl();
        roleDto.setId(1L);

        when(roleDao.find(roleEntity.getId())).thenReturn(roleEntity);
        when(roleConvertor.convertEntityToDto(roleEntity)).thenReturn(roleDto);

        Assert.assertNotNull(roleService.find(roleDto.getId()));
    }
}
