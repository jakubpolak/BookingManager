package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.UserDto;
import org.hibernate.criterion.Criterion;

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
     * Find by criteria
     *
     * @param criterion
     * @return list of user DTOs
     */
    List<UserDto> findByCriteria(Criterion criterion);

    /**
     * Find
     *
     * @param id
     * @return user DTO
     */
    UserDto find(Long id);

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
