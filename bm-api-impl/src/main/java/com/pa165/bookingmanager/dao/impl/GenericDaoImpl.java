package com.pa165.bookingmanager.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import com.pa165.bookingmanager.dao.GenericDao;
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
        getCurrentSession().save(e);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void update(E e) {
        getCurrentSession().update(e);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
}
