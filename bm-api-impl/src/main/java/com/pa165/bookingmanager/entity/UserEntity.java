package com.pa165.bookingmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Jakub Polak
 */
@Entity
@Table(name = "\"USER\"", schema = "PA165")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, length = 10)
    private Long id;

    @Column(name = "EMAIL", nullable = false, length = 45)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private RoleEntity roleByRoleId;

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
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    /**
     * Set role by role id
     *
     * @param roleByRoleId role by role id
     */
    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    /**
     * Equals
     *
     * @param o object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (roleByRoleId != null ? !roleByRoleId.equals(that.roleByRoleId) : that.roleByRoleId != null) return false;

        return true;
    }

    /**
     * Hash code
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roleByRoleId != null ? roleByRoleId.hashCode() : 0);
        return result;
    }

    /**
     * To string
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "UserEntity{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", roleByRoleId=" + roleByRoleId +
            '}';
    }
}
