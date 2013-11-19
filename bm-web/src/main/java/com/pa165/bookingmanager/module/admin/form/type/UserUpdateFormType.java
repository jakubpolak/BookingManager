package com.pa165.bookingmanager.module.admin.form.type;

import com.pa165.bookingmanager.module.admin.form.UserForm;

import javax.validation.constraints.NotNull;

/**
 * @author Jakub Polak
 */
public class UserUpdateFormType extends UserForm
{
    /**
     * User password
     */
    @NotNull
    private String password;

    /**
     * Get password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
