package com.pa165.bookingmanager.dto;

import java.io.Serializable;

/**
 * @author Josef Stribny
 */
public interface UserDto
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
     * Get email
     *
     * @return email
     */
    String getEmail();

    /**
     * Set email
     *
     * @param email
     */
    void setEmail(String email);

    /**
     * Get password
     *
     * @return password
     */
    String getPassword();

    /**
     * Set password
     *
     * @param password
     */
    void setPassword(String password);

    /**
     * Get role by role id
     *
     * @return role by role id
     */
    RoleDto getRoleByRoleId();

    /**
     * Set role by role id
     *
     * @param roleByRoleId role by role id
     */
    void setRoleByRoleId(RoleDto roleByRoleId);
}
