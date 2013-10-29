package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.RoleDto;

import java.util.List;

/**
 * @author Jakub Polak
 */
public interface RoleService
{
    /**
     * Find all
     *
     * @return list of role DTOs
     */
    List<RoleDto> findAll();

    /**
     * Find
     *
     * @param id
     * @return role DTO
     */
    RoleDto find(Long id);

    /**
     * Create
     *
     * @param roleDto role DTO
     */
    void create(RoleDto roleDto);

    /**
     * Update
     *
     * @param roleDto role DTO
     */
    void update(RoleDto roleDto);

    /**
     * Delete
     *
     * @param roleDto role DTO
     */
    void delete(RoleDto roleDto);
}
