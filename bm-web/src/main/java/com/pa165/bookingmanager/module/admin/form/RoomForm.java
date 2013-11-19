package com.pa165.bookingmanager.module.admin.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Jakub Polak
 */
public class RoomForm
{
    /**
     * Room number
     */
    @NotNull
    @Size(min=1, max=10)
    private String number;

    /**
     * Room price
     */
    @NotNull
    private BigDecimal price;

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
     * @param number room number
     */
    public void setNumber(String number) {
        this.number = number;
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
     * @param price room price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
