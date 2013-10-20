package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.RoleDto;
import org.hibernate.criterion.Criterion;

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
     * Find by criteria
     *
     * @param criterion
     * @return list of role DTOs
     */
    List<RoleDto> findByCriteria(Criterion criterion);

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
