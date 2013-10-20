package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.entity.UserEntity;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jakub Polak
 */
@Service("userDetailsService")
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService
{
    /**
     * Data access object
     */
    @Autowired
    private UserDao userDao;

    /**
     * Load user by user name
     *
     * @param string unique identification of user, user email is used in this case
     * @return user
     * @throws UsernameNotFoundException in case that specified user email does not exist
     */
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException
    {
        UserEntity userEntity = userDao.findByCriteria(Restrictions.eq("email", string)).get(0);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
            userEntity.getEmail(),
            userEntity.getPassword(),
            enabled,
            accountNonExpired,
            credentialsNonExpired,
            accountNonLocked,
            getAuthorities(userEntity.getRoleByRoleId().getId().intValue())
        );
    }

    /**
     * Get authorities
     *
     * @param role user role
     * @return list of granted authority objects
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role)
    {
        return getGrantedAuthorities(getRoles(role));
    }

    public List<String> getRoles(Integer role)
    {
        List<String> roles = new ArrayList<>();

        if (role.intValue() == 1) {
            roles.add("ROLE_USER");
            roles.add("ROLE_RECEPTIONIST");
            roles.add("ROLE_ADMIN");
        } else if (role.intValue() == 2) {
            roles.add("ROLE_RECEPTIONIST");
            roles.add("ROLE_USER");
        } else if (role.intValue() == 3) {
            roles.add("ROLE_USER");
        }

        return roles;
    }

    /**
     * Get granted authorities
     *
     * @param roles user role
     * @return list of granted authority objects
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles)
    {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }
}