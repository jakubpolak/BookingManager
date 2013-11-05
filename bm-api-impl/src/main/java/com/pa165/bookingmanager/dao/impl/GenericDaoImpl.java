package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

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
        // TODO: Throw custom exception that extends DataAccessException
        this.entityClass = entityClass;
    }

    /**
     * Get current session
     *
     * @return current session
     */
    public Session getCurrentSession() throws DataAccessException {
        return sessionFactory.getCurrentSession();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() throws DataAccessException {
        return getCurrentSession().createCriteria(entityClass).list();
    }

    /**
     *{@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public E find(I id) throws DataAccessException {
        // TODO: Throw custom exception that extends DataAccessException
        return (E) getCurrentSession().get(entityClass, id);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void create(E e) throws DataAccessException {
        // TODO: Throw custom exception that extends DataAccessException
        getCurrentSession().save(e);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void update(E e) throws DataAccessException {
        // TODO: Throw custom exception that extends DataAccessException
        getCurrentSession().update(e);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void delete(E e) throws DataAccessException {
        // TODO: Throw custom exception that extends DataAccessException
        getCurrentSession().delete(e);
    }
}
