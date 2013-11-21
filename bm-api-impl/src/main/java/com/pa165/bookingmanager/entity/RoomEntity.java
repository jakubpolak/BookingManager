package com.pa165.bookingmanager.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jakub Polak
 */
@Entity
@Table(name = "ROOM", schema = "PA165")
public class RoomEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @Column(name = "NUMBER", nullable = false, length = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private HotelEntity hotelByHotelId;

    @Column(name = "PRICE", nullable = false, precision = 8, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "roomByRoomId", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationsById;

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
     * Get number
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Set number
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Get reservations by id
     *
     * @return reservations by id
     */
    public List<ReservationEntity> getReservationsById() {
        return reservationsById;
    }

    /**
     * Set reservations by id
     *
     * @param reservationsById reservations by id
     */
    public void setReservationsById(List<ReservationEntity> reservationsById) {
        this.reservationsById = reservationsById;
    }

    /**
     * Get hotel by hotel id
     *
     * @return hotel by hotel id
     */
    public HotelEntity getHotelByHotelId() {
        return hotelByHotelId;
    }

    /**
     * Set hotel by hotel id
     *
     * @param hotelByHotelId hotel by hotel id
     */
    public void setHotelByHotelId(HotelEntity hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    /**
     * Get price
     *
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Set price
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
        if (!(o instanceof RoomEntity)) return false;

        RoomEntity that = (RoomEntity) o;

        if (!hotelByHotelId.equals(that.hotelByHotelId)) return false;
        if (!id.equals(that.id)) return false;
        if (!number.equals(that.number)) return false;
        if (!price.equals(that.price)) return false;
        if (reservationsById != null ? !reservationsById.equals(that.reservationsById) : that.reservationsById != null)
            return false;

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
        result = 31 * result + number.hashCode();
        result = 31 * result + hotelByHotelId.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + (reservationsById != null ? reservationsById.hashCode() : 0);
        return result;
    }

    /**
     * To string
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "RoomEntity{" +
            "id=" + id +
            ", number='" + number + '}';
    }
}
