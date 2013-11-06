package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.TestDaoSetup;
import com.pa165.bookingmanager.dao.RoleDao;
import com.pa165.bookingmanager.entity.RoleEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Josef Stribny
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleDaoImplTest extends TestDaoSetup
{
    @Autowired
    RoleDao roleDao;

    @Test
    public void testFindAll(){
        List<RoleEntity> roleEntities = roleDao.findAll();
        Assert.assertEquals(3, roleEntities.size());
    }

    @Test
    public void testFind(){
        Long id = 1L;
        RoleEntity roleEntity = roleDao.find(id);

        Assert.assertEquals(id, roleEntity.getId());
        Assert.assertEquals("ROLE_ADMIN", roleEntity.getName());
        Assert.assertEquals(1, roleEntity.getUsersById().size());
    }

    @Test
    public void testCreate(){
        RoleEntity role = new RoleEntity();
        role.setName("EDITOR");

        roleDao.create(role);

        RoleEntity roleEntity = roleDao.find(role.getId());
        Assert.assertNotNull(roleEntity);
    }

    @Test
    public void testUpdate(){
        Long id = 1L;

        RoleEntity roleEntity = roleDao.find(id);
        Assert.assertEquals("ROLE_ADMIN", roleEntity.getName());

        roleEntity.setName("ROLE_EDITOR");

        roleDao.update(roleEntity);

        RoleEntity roleEntityUpdated = roleDao.find(id);
        Assert.assertEquals("ROLE_EDITOR", roleEntityUpdated.getName());
    }

    @Test
    public void testDelete(){
        Long id = 1L;

        RoleEntity roleEntity = roleDao.find(id);

        roleDao.delete(roleEntity);

        RoleEntity roleEntityDeleted = roleDao.find(id);
        Assert.assertEquals(null, roleEntityDeleted);
    }
}
