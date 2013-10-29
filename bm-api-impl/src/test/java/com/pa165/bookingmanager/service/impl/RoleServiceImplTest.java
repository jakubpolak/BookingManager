package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;
import com.pa165.bookingmanager.service.RoleService;
import junit.framework.Assert;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Jakub Polak, Jan Hrubes
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplTest extends TestServiceSetup
{
    @Autowired
    RoleService roleService;

    @Test
    public void testFindAll() throws Exception {
        List<RoleDto> roleDtos = roleService.findAll();

        Assert.assertEquals(3, roleDtos.size());
    }

    @Test
    public void testFindByCriteria() throws Exception {
        List<RoleDto> roleDtos1 = roleService.findByCriteria(Restrictions.eq("name", "ROLE_ADMIN"));

        Assert.assertEquals(1, roleDtos1.size());

        List<RoleDto> roleDtos2 = roleService.findByCriteria(Restrictions.eq("name", "ROLE_DOES_NOT_EXIST"));

        Assert.assertTrue(roleDtos2.isEmpty());
    }

    @Test
    public void testFind() throws Exception {
        Assert.assertNotNull(roleService.find(1L));
        Assert.assertNull(roleService.find(999L));
    }

    @Test
    public void testCreate() throws Exception {
        RoleDto roleDto = new RoleDtoImpl();
        roleDto.setName("ROLE_NEW");
        roleService.create(roleDto);

        List<RoleDto> roleDtos = roleService.findByCriteria(Restrictions.eq("name", "ROLE_NEW"));

        Assert.assertEquals(1, roleDtos.size());
    }

    @Test
    public void testUpdate() throws Exception {
        RoleDto roleDto = roleService.find(1L);
        roleDto.setName("ROLE_UPDATED");

        roleService.update(roleDto);

        List<RoleDto> roleDtos = roleService.findByCriteria(Restrictions.eq("name", "ROLE_UPDATED"));

        Assert.assertEquals(1, roleDtos.size());
    }

    @Test
    public void testDelete() throws Exception {
        roleService.delete(roleService.find(1L));

        Assert.assertNull(roleService.find(1L));
    }
}
