package com.pa165.bookingmanager.dao.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author Jakub Polak
 */
public class DaoException extends DataAccessException
{
    /**
     * Constructor
     *
     * @param msg message
     */
    public DaoException(String msg) {
        super(msg);
    }

    /**
     * Constructor
     *
     * @param msg message
     * @param cause cause
     */
    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
