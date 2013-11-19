package com.pa165.bookingmanager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Jakub Polak
 */
@Entity
@Table(name = "HOTEL", schema = "PA165")
public class HotelEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "hotelByHotelId", cascade = CascadeType.ALL)
    private List<RoomEntity> roomsById;

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
     * Get rooms by id
     *
     * @return rooms by id
     */
    public List<RoomEntity> getRoomsById() {
        return roomsById;
    }

    /**
     * Set rooms by id
     *
     * @param roomsById rooms by id
     */
    public void setRoomsById(List<RoomEntity> roomsById) {
        this.roomsById = roomsById;
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
        if (!(o instanceof HotelEntity)) return false;

        HotelEntity that = (HotelEntity) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (roomsById != null ? !roomsById.equals(that.roomsById) : that.roomsById != null) return false;

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
        result = 31 * result + (roomsById != null ? roomsById.hashCode() : 0);
        return result;
    }

    /**
     * To string
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "HotelEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", roomsById=" + roomsById +
            '}';
    }
}



