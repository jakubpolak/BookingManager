package com.pa165.bookingmanager.module.admin.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Jakub Polak
 */
public class ReservationForm
{
    /**
     * Reservation from
     */
    @NotNull
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date reservationFrom;

    /**
     * Reservation to
     */
    @NotNull
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date reservationTo;

    /**
     * Customer name
     */
    @NotNull
    @NotEmpty
    private String customerName;

    /**
     * Customer email
     */
    @NotNull
    @NotEmpty
    @Email
    private String customerEmail;

    /**
     * Customer phone
     */
    @NotNull
    @NotEmpty
    private String customerPhone;

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
}
