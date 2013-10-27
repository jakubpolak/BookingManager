package com.pa165.bookingmanager.dao;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jakub Polak
 */
public interface GenericDao<E, I extends Serializable>
{
    /**
     * Find all entities
     *
     * @return list of entities
     */
    List<E> findAll();

    /**
     * Find by criteria
     *
     * @param criterion criterion
     * @return entities
     */
    List<E> findByCriteria(Criterion criterion);

    /**
     * Find one entity by id
     *
     * @param i id
     * @return entity
     */
    E find(I i);

    /**
     * Save entity
     *
     * @param e entity
     */
    void create(E e);

    /**
     * Update entity
     *
     * @param e entity
     */
    void update(E e);

    /**
     * Delete entity
     *
     * @param e entity
     */
    void delete(E e);
}
