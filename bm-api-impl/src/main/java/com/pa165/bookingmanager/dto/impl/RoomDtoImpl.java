package com.pa165.bookingmanager.dto.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Josef Stribny
 */
public class RoomDtoImpl  implements RoomDto
{
    /**
     * Id
     */
    private Long id;

    /**
     * Number
     */
    private String number;

    /**
     * Hotel by hotel id
     */
    private HotelDto hotelByHotelId;

    /**
     * Price
     */
    private BigDecimal price;

    /**
     * Reservation by id
     */
    private List<ReservationDto> reservationsById;

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
     * Get hotel by hotel id
     *
     * @return hotel by hotel id
     */
    public HotelDto getHotelByHotelId() {
        return hotelByHotelId;
    }

    /**
     * Set hotel by hotel id
     *
     * @param hotelByHotelId hotel by hotel id
     */
    public void setHotelByHotelId(HotelDto hotelByHotelId) {
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
     * Get reservations by id
     *
     * @return reservations by id
     */
    public List<ReservationDto> getReservationsById() {
        return reservationsById;
    }

    /**
     * Set reservations by id
     *
     * @param reservationsById reservations by id
     */
    public void setReservationsById(List<ReservationDto> reservationsById) {
        this.reservationsById = reservationsById;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomDtoImpl)) return false;

        RoomDtoImpl roomDto = (RoomDtoImpl) o;

        if (!hotelByHotelId.equals(roomDto.hotelByHotelId)) return false;
        if (!id.equals(roomDto.id)) return false;
        if (!number.equals(roomDto.number)) return false;
        if (!price.equals(roomDto.price)) return false;
        if (reservationsById != null ? !reservationsById.equals(roomDto.reservationsById) : roomDto.reservationsById != null)
            return false;

        return true;
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "RoomDtoImpl{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", hotelByHotelId=" + hotelByHotelId +
                ", price=" + price +
                ", reservationsById=" + reservationsById +
                '}';
    }
}
