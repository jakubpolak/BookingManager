package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.convertor.impl.RoleConvertorImpl;
import com.pa165.bookingmanager.convertor.impl.UserConvertorImpl;
import com.pa165.bookingmanager.dao.RoleDao;
import com.pa165.bookingmanager.dao.UserDao;
import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;
import com.pa165.bookingmanager.entity.RoleEntity;
import com.pa165.bookingmanager.entity.UserEntity;
import com.pa165.bookingmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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

    @Autowired
    RoleDao roleDao;

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
            RoleDto roleDto = roleConvertor.convertEntityToDto(userEntity.getRoleByRoleId());
            userDto.setRoleByRoleId(roleDto);
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

        RoleDto roleDto = userDto.getRoleByRoleId();

        if (roleDto == null){
            throw new IllegalArgumentException("RoleDto can't be null.");
        }

        ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
        String encodedPassword = shaPasswordEncoder.encodePassword(userDto.getPassword(), "");
        userDto.setPassword(encodedPassword);

        UserEntity userEntity = userConvertor.convertDtoToEntity(userDto);
        RoleEntity roleEntity = roleConvertor.convertDtoToEntity(roleDto);

        userEntity.setRoleByRoleId(roleEntity);

        userDao.create(userEntity);
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

        RoleDto roleDto = userDto.getRoleByRoleId();

        if (roleDto == null){
            throw new IllegalArgumentException("RoleDto can't be null.");
        }

        UserEntity userEntity = userDao.find(userDto.getId());

        if (userEntity != null){
            if (!userDto.getPassword().equals("")){
                ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
                String encodedPassword = shaPasswordEncoder.encodePassword(userDto.getPassword(), "");
                userDto.setPassword(encodedPassword);
            } else {
                userDto.setPassword(userEntity.getPassword());
            }

            RoleEntity roleEntity = roleDao.find(roleDto.getId());
            userConvertor.convertDtoToEntity(userDto, userEntity);

            userEntity.setRoleByRoleId(roleEntity);
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
