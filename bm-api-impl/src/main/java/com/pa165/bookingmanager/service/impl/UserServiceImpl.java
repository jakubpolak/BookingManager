package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.convertor.impl.RoleConvertorImpl;
import com.pa165.bookingmanager.convertor.impl.UserConvertorImpl;
import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.entity.UserEntity;
import com.pa165.bookingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jana Polakova, Jakub Polak, Jan Hrubes
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService
{
    @Autowired
    UserDao userDao;

    @Autowired
    UserConvertorImpl userConvertor;

    @Autowired
    RoleConvertorImpl roleConvertor;

    /**
     * Constructor
     */
    public UserServiceImpl(){

    }

    /**
     * Constructor
     *
     * @param userDao user dao
     * @param userConvertor user convertor
     */
    public UserServiceImpl(UserDao userDao, UserConvertorImpl userConvertor){
        this.userDao = userDao;
        this.userConvertor = userConvertor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDto> findAll() {
        List<UserEntity> userEntities = userDao.findAll();
        List<UserDto> userDtos = null;

        if (userEntities != null){
            userDtos = userConvertor.convertEntityListToDtoList(userEntities);
        }

        return userDtos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDto> findAllAndRoles() {
        List<UserEntity> userEntities = userDao.findAll();
        List<UserDto> userDtos = null;

        if (userEntities != null){
            userDtos = new ArrayList<>();
            for (UserEntity userEntity : userEntities){
                UserDto userDto = userConvertor.convertEntityToDto(userEntity);
                RoleDto roleDto = roleConvertor.convertEntityToDto(userEntity.getRoleByRoleId());
                userDto.setRoleByRoleId(roleDto);
                userDtos.add(userDto);
            }
        }

        return userDtos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto findOneByEmail(String email){
        if (email == null){
            throw new IllegalArgumentException("Email can't be null.");
        }

        UserEntity userEntity = userDao.findOneByEmail(email);
        UserDto userDto = null;

        if (userEntity != null){
            userDto = userConvertor.convertEntityToDto(userEntity);
        }

        return userDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto find(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        UserEntity userEntity = userDao.find(id);
        UserDto userDto = null;

        if (userEntity != null){
            userDto = userConvertor.convertEntityToDto(userEntity);
        }

        return userDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void create(UserDto userDto) {
        if (userDto == null){
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        userDao.create(userConvertor.convertDtoToEntity(userDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void update(UserDto userDto) {
        if (userDto == null){
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        UserEntity userEntity = userDao.find(userDto.getId());

        if (userEntity != null){
            userConvertor.convertDtoToEntity(userDto, userEntity);
            userDao.update(userEntity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(UserDto userDto) {
        if (userDto == null){
            throw new IllegalArgumentException("UserDto can't be null.");
        }

        UserEntity userEntity = userDao.find(userDto.getId());

        if (userEntity != null){
            userDao.delete(userEntity);
        }
    }
}
