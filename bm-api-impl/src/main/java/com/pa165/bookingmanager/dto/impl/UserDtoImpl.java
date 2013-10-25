package com.pa165.bookingmanager.dto.impl;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.dto.UserDto;

/**
 * @author Josef Stribny
 */
public class UserDtoImpl implements UserDto
{
    /**
     * Id
     */
    private Long id;

    /**
     * Email
     */
    private String email;

    /**
     * Password
     */
    private String password;

    /**
     * Role by role id
     */
    private RoleDto roleByRoleId;

    /**
     * Get id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get role by role id
     *
     * @return role by role id
     */
    public RoleDto getRoleByRoleId() {
        return roleByRoleId;
    }

    /**
     * Set role by role id
     *
     * @param roleByRoleId role by role id
     */
    public void setRoleByRoleId(RoleDto roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDtoImpl)) return false;

        UserDtoImpl userDto = (UserDtoImpl) o;

        if (!email.equals(userDto.email)) return false;
        if (!id.equals(userDto.id)) return false;
        if (!password.equals(userDto.password)) return false;
        if (!roleByRoleId.equals(userDto.roleByRoleId)) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + roleByRoleId.hashCode();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserDtoImpl{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleByRoleId=" + roleByRoleId +
                '}';
    }
}
