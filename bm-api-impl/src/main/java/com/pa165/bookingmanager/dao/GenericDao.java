package com.pa165.bookingmanager.dao;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jakub Polak
 */
public interface GenericDao<E, I extends Serializable>
{
    /**
     * Find all
     *
     * @return list of entities
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    List<E> findAll() throws DataAccessException;

    /**
     * Find entity by entity id
     *
     * @param id entity id
     * @return entity
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
    E find(I id) throws DataAccessException;

    /**
     * Create entity
     *
     * @param e entity
     * @throws DataAccessException
     */
    void create(E e) throws DataAccessException;

    /**
     * Update entity
     *
     * @param e entity
     * @throws DataAccessException
     */
    void update(E e) throws DataAccessException;

    /**
     * Delete entity
     *
     * @param e entity
     * @throws DataAccessException
     */
    void delete(E e) throws DataAccessException;

    /**
     * Get current session
     *
     * @return current session
     * @throws DataAccessException
     */
    Session getCurrentSession() throws DataAccessException;
}
