package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Polakova
 */
@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<UserEntity, Long> implements UserDao
{
    /**
     * Constructor
     */
    public UserDaoImpl(){
        super(UserEntity.class);
    }
}
