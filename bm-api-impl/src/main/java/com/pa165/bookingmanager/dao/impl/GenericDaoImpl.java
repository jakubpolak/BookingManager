package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class GenericDaoImpl<E, I extends Serializable> implements GenericDao<E, I>
{
    private Class<E> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Constructor
     */
    public GenericDaoImpl(Class<E> entityClass){
        this.entityClass = entityClass;
    }

    /**
     * Get current session
     *
     * @return current session
     */
    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        return getCurrentSession().createCriteria(entityClass).list();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public E find(I id) {
        if (id == null) {
            throw new IllegalArgumentException("Id can't be null.");
        }

        return (E) getCurrentSession().get(entityClass, id);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void create(E e) {
        if (e == null){
            throw new IllegalArgumentException("Entity can't be null.");
        }

        getCurrentSession().save(e);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void update(E e) {
        if (e == null){
            throw new IllegalArgumentException("Entity can't be null.");
        }

        getCurrentSession().update(e);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void delete(E e) {
        if (e == null){
            throw new IllegalArgumentException("Entity can't be null.");
        }

        getCurrentSession().delete(e);
    }
}
