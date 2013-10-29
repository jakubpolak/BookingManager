package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.dto.impl.UserDtoImpl;
import com.pa165.bookingmanager.service.RoleService;
import com.pa165.bookingmanager.service.UserService;
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
public class UserServiceImplTest  extends TestServiceSetup
{
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Test
    public void testFindAll() throws Exception {
        List<UserDto> userDtos = userService.findAll();

        Assert.assertEquals(userDtos.size(), 2);
    }

    @Test
    public void testFindByCriteria() throws Exception {
        List<UserDto> userDtos = userService.findByCriteria(Restrictions.eq("email", "admin@bm.com"));
        Assert.assertEquals(userDtos.size(), 1);

        List<UserDto> userDtos1 = userService.findByCriteria(Restrictions.eq("id", 999L));
        Assert.assertEquals(userDtos1.size(), 0);
    }

    @Test
    public void testFindOneByEmail() throws Exception {
        Assert.assertNotNull(userService.findOneByEmail("admin@bm.com"));
        Assert.assertNull(userService.findOneByEmail("undefined@email.com"));
    }

    @Test
    public void testFind() throws Exception {
        Assert.assertNotNull(userService.find(1L));
        Assert.assertNull(userService.find(999L));
    }

    @Test
    public void testCreate() throws Exception {
        UserDto userDto = new UserDtoImpl();
        userDto.setEmail("default@email.com");
        userDto.setPassword("passw");
        userDto.setRoleByRoleId(roleService.find(1L));

        userService.create(userDto);
        // TODO: user DAO does not save mandatory role attribute
        Assert.assertNotNull(userService.findOneByEmail("default@email.com"));
    }

    @Test
    public void testUpdate() throws Exception {
        UserDto userDto = userService.find(1L);
        userDto.setEmail("new@email.com");

        userService.update(userDto);

        Assert.assertNotNull(userService.findOneByEmail("new@email.com"));
    }

    @Test
    public void testDelete() throws Exception {
        userService.delete(userService.find(1L));
        Assert.assertNull(userService.find(1L));
    }
}
