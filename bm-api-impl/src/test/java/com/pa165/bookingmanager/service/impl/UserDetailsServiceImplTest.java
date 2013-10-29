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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.mockito.Mockito.when;

/**
 * @author Jakub Polak
 */
public class UserDetailsServiceImplTest extends TestServiceSetup
{
    @Mock
    private UserDao userDao;

    @Mock
    private RoleConvertorImpl roleConvertor;

    @Mock
    private UserConvertorImpl userConvertor;

    private UserDetailsService userDetailsService;

    @Before
    public void setup() throws Exception{
        super.setup();

        userDetailsService = new UserDetailsServiceImpl(userDao, userConvertor, roleConvertor);
    }

    @Test
    public void testLoadUserByUsername() throws Exception {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ROLE_ADMIN");
        roleEntity.setId(1L);

        RoleDto roleDto = new RoleDtoImpl();
        roleDto.setName("ROLE_ADMIN");
        roleDto.setId(1L);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setEmail("admin@bm.com");
        userEntity.setPassword("f613a2ae7af9039d3a371abf0a65d4751e3aed23");
        userEntity.setRoleByRoleId(roleEntity);

        UserDto userDto = new UserDtoImpl();
        userDto.setId(1L);
        userDto.setEmail("admin@bm.com");
        userDto.setPassword("f613a2ae7af9039d3a371abf0a65d4751e3aed23");
        userDto.setRoleByRoleId(roleDto);

        when(userDao.findOneByEmail("admin@bm.com")).thenReturn(userEntity);
        when(roleConvertor.convertEntityToDto(roleEntity)).thenReturn(roleDto);
        when(userConvertor.convertEntityToDto(userEntity)).thenReturn(userDto);

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
