package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
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

    private RoleService roleService;

    @Before
    public void setup() throws Exception {
        super.setup();
        roleService = new RoleServiceImpl(roleDao, roleConvertor);
    }

    @Test
    public void testFindAll() throws Exception {
        List<RoleEntity> roleEntities = new ArrayList<>();
        List<RoleDto> roleDtos = new ArrayList<>();

        roleEntities.add(new RoleEntity());
        roleDtos.add(new RoleDtoImpl());

        when(roleDao.findAll()).thenReturn(roleEntities);
        when(roleConvertor.convertEntityListToDtoList(roleEntities)).thenReturn(roleDtos);

        Assert.assertEquals(1, roleService.findAll().size());
    }

    @Test
    public void testFind() throws Exception {
        RoleEntity roleEntity = new RoleEntity();
        RoleDto roleDto = new RoleDtoImpl();

        when(roleDao.find(1L)).thenReturn(roleEntity);
        when(roleDao.find(999L)).thenReturn(null);
        when(roleConvertor.convertEntityToDto(roleEntity)).thenReturn(roleDto);

        Assert.assertNotNull(roleService.find(1L));

        Assert.assertNull(roleService.find(999L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindIllegalArgumentException() throws Exception {
        roleService.find(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateIllegalArgumentException() throws Exception {
        roleService.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateIllegalArgumentException() throws Exception {
        roleService.update(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIllegalArgumentException() throws Exception {
        roleService.delete(null);
    }
}
