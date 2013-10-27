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
        List<D> ds = new ArrayList<>();
        for (E e : es){
            ds.add(convertEntityToDto(e));
        }

        return ds;
    }
}
