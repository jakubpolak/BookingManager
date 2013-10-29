package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.UserDto;

import java.util.List;

/**
 * @author Jakub Polak
 */
public interface UserService
{
    /**
     * Find all
     *
     * @return list of user DTOs
     */
    List<UserDto> findAll();

    /**
     * Find
     *
     * @param id
     * @return user DTO
     */
    UserDto find(Long id);

    /**
     * Find one by email
     *
     * @param email user email
     * @return user DTO
     */
    UserDto findOneByEmail(String email);

    /**
     * Create
     *
     * @param userDto user DTO
     */
    void create(UserDto userDto);

    /**
     * Update
     *
     * @param userDto user DTO
     */
    void update(UserDto userDto);

    /**
     * Delete
     *
     * @param userDto user DTO
     */
    void delete(UserDto userDto);
}
