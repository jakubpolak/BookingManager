package com.pa165.bookingmanager.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Josef Stribny
 */
public interface RoleDto
{
    /**
     * Get id
     *
     * @return id
     */
    Long getId();

    /**
     * Set id
     *
     * @param id
     */
    void setId(Long id);

    /**
     * Get name
     *
     * @return name
     */
    String getName();

    /**
     * Set name
     *
     * @param name
     */
    void setName(String name);

    /**
     * Get users by id
     *
     * @return users by id
     */
    List<UserDto> getUsersById();

    /**
     * Set users by id
     *
     * @param usersById users by id
     */
    void setUsersById(List<UserDto> usersById);
}
