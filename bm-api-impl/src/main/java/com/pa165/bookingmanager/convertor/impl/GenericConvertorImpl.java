package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.convertor.GenericConvertor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
public abstract class GenericConvertorImpl<E, D extends Serializable> implements GenericConvertor<E, D>
{
    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> convertDtoListToEntityList(List<D> ds) {
        if (ds == null){
            throw new IllegalArgumentException("DTO list can't be null.");
        }

        List<E> es = new ArrayList<>();
        for (D d : ds){
            es.add(convertDtoToEntity(d));
        }

        return es;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<D> convertEntityListToDtoList(List<E> es) {
        if (es == null){
            throw new IllegalArgumentException("Entity list can't be null.");
        }

        List<D> ds = new ArrayList<>();
        for (E e : es){
            ds.add(convertEntityToDto(e));
        }

        return ds;
    }
}
