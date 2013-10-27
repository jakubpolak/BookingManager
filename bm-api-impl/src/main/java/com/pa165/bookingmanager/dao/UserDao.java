package com.pa165.bookingmanager.dao;

import com.pa165.bookingmanager.entity.UserEntity;

/**
 * @author Jakub Polak
 */
public interface UserDao extends GenericDao<UserEntity, Long>
{
    /**
     * Find by email
     *
     * @param email user email
     * @return UserEntity
     */
    UserEntity findOneByEmail(String email);
}
