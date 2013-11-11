package com.pa165.bookingmanager.module.admin.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Jakub Polak
 */
public class HotelForm
{
    @NotEmpty(message="{field.not.empty}")
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
