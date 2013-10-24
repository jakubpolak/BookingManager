package com.pa165.bookingmanager.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Josef Stribny
 */
public interface RoomDto
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
     * Get number
     *
     * @return number
     */
    String getNumber();

    /**
     * Set number
     *
     * @param number
     */
    void setNumber(String number);

    /**
     * Get hotel by hotel id
     *
     * @return hotel by hotel id
     */
    HotelDto getHotelByHotelId();

    /**
     * Set hotel by hotel id
     *
     * @param hotelByHotelId hotel by hotel id
     */
    void setHotelByHotelId(HotelDto hotelByHotelId);

    /**
     * Get price
     *
     * @return price
     */
    BigDecimal getPrice();

    /**
     * Set price
     *
     * @param price
     */
    void setPrice(BigDecimal price);

    /**
     * Get reservations by id
     *
     * @return reservations by id
     */
    List<ReservationDto> getReservationsById();

    /**
     * Set reservations by id
     *
     * @param reservationsById reservations by id
     */
    void setReservationsById(List<ReservationDto> reservationsById);
}
