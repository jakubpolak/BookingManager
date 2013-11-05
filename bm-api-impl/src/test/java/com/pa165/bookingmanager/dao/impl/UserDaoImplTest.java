package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.TestDaoSetup;
import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.entity.UserEntity;
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
public class UserDaoImplTest extends TestDaoSetup
{
    @Autowired
    UserDao userDao;

    @Test
    public void testFindAll(){
        List<UserEntity> UserEntities = userDao.findAll();
        Assert.assertEquals(2, UserEntities.size());
    }

    @Test
    public void testFind(){
        Long id = 1L;

        UserEntity UserEntity = userDao.find(id);
        Assert.assertEquals(id, UserEntity.getId());
        Assert.assertEquals("admin@bm.com", UserEntity.getEmail());

        // Check associated role entity
        Assert.assertEquals("ROLE_ADMIN", UserEntity.getRoleByRoleId().getName());
    }

    @Test
    public void testCreate(){
        UserEntity user = new UserEntity();
        user.setEmail("bla@bla.cz");

        userDao.create(user);

        UserEntity UserEntity = userDao.find(user.getId());
        Assert.assertNotNull(UserEntity);
    }

    @Test
    public void testUpdate(){
        Long id = 2L;

        UserEntity userEntity = userDao.find(id);
        Assert.assertEquals("receptionist@bm.com", userEntity.getEmail());

        userEntity.setEmail("no-reply@bm.com");
        userEntity.setPassword("hfhalkdf56ds6adkdda6ajdks6a6s");

        userDao.update(userEntity);

        UserEntity userEntityUpdated = userDao.find(id);

        Assert.assertEquals("no-reply@bm.com", userEntityUpdated.getEmail());
        Assert.assertEquals("hfhalkdf56ds6adkdda6ajdks6a6s", userEntityUpdated.getPassword());
    }

    @Test
    public void testDelete(){
        Long id = 1L;

        UserEntity userEntity = userDao.find(id);

        userDao.delete(userEntity);

        UserEntity userEntityDeleted = userDao.find(id);
        Assert.assertEquals(userEntityDeleted, null);
    }

    @Test
    public void testFindOneByEmail(){
        UserEntity userEntity = userDao.findOneByEmail("admin@bm.com");
        Assert.assertNotNull(userEntity);
    }

    // TODO: Test DataAccessException
}
