package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.TestServiceSetup;
import com.pa165.bookingmanager.dao.UserDao;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jakub Polak
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsServiceImplTest extends TestServiceSetup
{
    @Mock
    UserDao userDao;

    @InjectMocks
    @Autowired
    UserDetailsService userDetailsService;

    @Test
    public void testLoadUserByUsername() throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername("admin@bm.com");

        Assert.assertEquals(userDetails.getUsername(), "admin@bm.com");
        Assert.assertEquals(userDetails.getPassword(), "f613a2ae7af9039d3a371abf0a65d4751e3aed23");
        Assert.assertEquals(userDetails.isAccountNonExpired(), true);
        Assert.assertEquals(userDetails.isCredentialsNonExpired(), true);
        Assert.assertEquals(userDetails.isAccountNonLocked(), true);
        Assert.assertEquals(userDetails.isEnabled(), true);
        Assert.assertEquals(userDetails.getAuthorities().size(), 3);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testUsernameNotFoundException() throws Exception {
        userDetailsService.loadUserByUsername("non-existing-user@bm.com");
    }
}
