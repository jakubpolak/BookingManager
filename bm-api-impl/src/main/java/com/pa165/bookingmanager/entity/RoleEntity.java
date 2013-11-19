package com.pa165.bookingmanager.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Jakub Polak
 */
@Entity
@Table(name = "ROLE", schema = "PA165")
public class RoleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "roleByRoleId")
    private List<UserEntity> usersById;

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
     * Get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get users by user id
     *
     * @return users by user id
     */
    public List<UserEntity> getUsersById() {
        return usersById;
    }

    /**
     * Set users by id
     * @param usersById
     */
    public void setUsersById(List<UserEntity> usersById) {
        this.usersById = usersById;
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
        if (!(o instanceof RoleEntity)) return false;

        RoleEntity that = (RoleEntity) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (usersById != null ? !usersById.equals(that.usersById) : that.usersById != null) return false;

        return true;
    }

    /**
     * Hash code
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (usersById != null ? usersById.hashCode() : 0);
        return result;
    }

    /**
     * To string
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "RoleEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
