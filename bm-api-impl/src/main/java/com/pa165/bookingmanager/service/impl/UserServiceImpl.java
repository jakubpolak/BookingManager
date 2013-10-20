package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.service.UserService;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jana Polakova
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService
{
    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public List<UserDto> findByCriteria(Criterion criterion) {
        return null;
    }

    @Override
    public UserDto find(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void create(UserDto userDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void update(UserDto userDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(UserDto userDto) {

    }
}
