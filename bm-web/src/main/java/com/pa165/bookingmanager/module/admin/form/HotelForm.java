package com.pa165.bookingmanager.module.admin.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Jakub Polak
 */
public class HotelForm
{
    @NotNull
    @Size(min=1, max=45)
    private String name;

    /**
     * Set name
     *
     * @param name hotel name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name
     *
     * @return hotel name
     */
    public String getName(){
        return name;
    }
}
