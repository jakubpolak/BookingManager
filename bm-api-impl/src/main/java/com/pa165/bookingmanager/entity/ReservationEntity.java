package com.pa165.bookingmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Jakub Polak
 */
@Entity
@Table(name = "RESERVATION", schema = "PA165")
public class ReservationEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, length = 10)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private RoomEntity roomByRoomId;

    @Column(name = "RESERVATION_FROM", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reservationFrom;

    @Column(name = "RESERVATION_TO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reservationTo;

    @Column(name = "CUSTOMER_NAME", nullable = false, length = 45)
    private String customerName;

    @Column(name = "CUSTOMER_EMAIL", nullable = false, length = 45)
    private String customerEmail;

    @Column(name = "CUSTOMER_PHONE", nullable = false, length = 20)
    private String customerPhone;

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
     * Get room by room id
     *
     * @return room by room id
     */
    public RoomEntity getRoomByRoomId() {
        return roomByRoomId;
    }

    /**
     * Set room by room id
     *
     * @param roomByRoomId room by room id
     */
    public void setRoomByRoomId(RoomEntity roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    /**
     * Get reservation from
     *
     * @return reservation from
     */
    public Date getReservationFrom() {
        return reservationFrom;
    }

    /**
     * Set reservation from
     *
     * @param reservationFrom reservation from
     */
    public void setReservationFrom(Date reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    /**
     * Get reservation to
     *
     * @return reservation to
     */
    public Date getReservationTo() {
        return reservationTo;
    }

    /**
     * Set reservation to
     *
     * @param reservationTo reservation to
     */
    public void setReservationTo(Date reservationTo) {
        this.reservationTo = reservationTo;
    }

    /**
     * Get customer name
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set customer name
     *
     * @param customerName customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get customer email
     *
     * @return customer email
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Set customer email
     *
     * @param customerEmail customer email
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Get customer phone
     *
     * @return customer phone
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Set customer phone
     *
     * @param customerPhone customer phone
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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
        if (!(o instanceof ReservationEntity)) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (customerEmail != null ? !customerEmail.equals(that.customerEmail) : that.customerEmail != null)
            return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (customerPhone != null ? !customerPhone.equals(that.customerPhone) : that.customerPhone != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reservationFrom != null ? !reservationFrom.equals(that.reservationFrom) : that.reservationFrom != null)
            return false;
        if (reservationTo != null ? !reservationTo.equals(that.reservationTo) : that.reservationTo != null)
            return false;
        if (roomByRoomId != null ? !roomByRoomId.equals(that.roomByRoomId) : that.roomByRoomId != null) return false;

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
        result = 31 * result + (roomByRoomId != null ? roomByRoomId.hashCode() : 0);
        result = 31 * result + (reservationFrom != null ? reservationFrom.hashCode() : 0);
        result = 31 * result + (reservationTo != null ? reservationTo.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        return result;
    }

    /**
     * To string
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "ReservationEntity{" +
            "id=" + id +
            ", roomByRoomId=" + roomByRoomId +
            ", reservationFrom=" + reservationFrom +
            ", reservationTo=" + reservationTo +
            ", customerName='" + customerName + '\'' +
            ", customerEmail='" + customerEmail + '\'' +
            ", customerPhone='" + customerPhone + '\'' +
            '}';
    }
}
