package com.pa165.bookingmanager.dto;

import com.pa165.bookingmanager.dto.impl.RoleDtoImpl;

/**
 * @author Jan Hrubeš
 */
public class UserRestDto {
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
    private RoleDtoImpl roleByRoleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDtoImpl getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleDtoImpl roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
