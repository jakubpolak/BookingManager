package com.pa165.bookingmanager.module.admin.form;

import com.pa165.bookingmanager.dto.RoleDto;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Jakub Polak
 */
public class UserForm
{
    /**
     * User email
     */
    @NotNull
    @NotEmpty
    @Email
    private String email;

    /**
     * User role by role id
     */
    private RoleDto roleByRoleId;

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
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
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
}
