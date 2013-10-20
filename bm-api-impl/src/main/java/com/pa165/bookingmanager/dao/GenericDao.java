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
    public List<E> findAll();

    /**
     * Find by criteria
     *
     * @param criterion criterion
     * @return entities
     */
    public List<E> findByCriteria(Criterion criterion);

    /**
     * Find one entity by id
     *
     * @param i id
     * @return entity
     */
    public E find(I i);

    /**
     * Save entity
     *
     * @param e entity
     */
    public void create(E e);

    /**
     * Update entity
     *
     * @param e entity
     */
    public void update(E e);

    /**
     * Delete entity
     *
     * @param e entity
     */
    public void delete(E e);
}
