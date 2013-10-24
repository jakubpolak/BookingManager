package com.pa165.bookingmanager.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Josef Stribny
 */
public interface ReservationDto
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
     * Get room by room id
     *
     * @return room by room id
     */
    RoomDto getRoomByRoomId();

    /**
     * Set room by room id
     *
     * @param roomByRoomId room by room id
     */
    void setRoomByRoomId(RoomDto roomByRoomId);

    /**
     * Get reservation from
     *
     * @return reservation from
     */
    Date getReservationFrom();

    /**
     * Set reservation from
     *
     * @param reservationFrom reservation from
     */
    void setReservationFrom(Date reservationFrom);

    /**
     * Get reservation to
     *
     * @return reservation to
     */
    Date getReservationTo();

    /**
     * Set reservation to
     *
     * @param reservationTo reservation to
     */
    void setReservationTo(Date reservationTo);

    /**
     * Get customer name
     *
     * @return customer name
     */
    String getCustomerName();

    /**
     * Set customer name
     *
     * @param customerName customer name
     */
    void setCustomerName(String customerName);

    /**
     * Get customer email
     *
     * @return customer email
     */
    String getCustomerEmail();

    /**
     * Set customer email
     *
     * @param customerEmail customer email
     */
    void setCustomerEmail(String customerEmail);

    /**
     * Get customer phone
     *
     * @return customer phone
     */
    String getCustomerPhone();

    /**
     * Set customer phone
     *
     * @param customerPhone customer phone
     */
    void setCustomerPhone(String customerPhone);
}
