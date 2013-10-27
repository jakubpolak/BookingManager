package com.pa165.bookingmanager.convertor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jakub Polak, Josef Stribny, Jana Polakova
 *
 * @param <E> entity
 * @param <D> DTO
 */
public interface GenericConvertor<E, D extends Serializable>
{
    /**
     * Convert entity to DTO
     *
     * @param e entity
     * @return DTO
     */
    D convertEntityToDto(E e);

    /**
     * Convert dto to entity
     *
     * @param d DTO
     * @return entity
     */
    E convertDtoToEntity(D d);

    /**
     * Convert dto to entity
     *
     * @param d DTO
     * @param e entity
     */
    void convertDtoToEntity(D d, E e);

    /**
     * Dto list to entity list
     *
     * @param ds DTOs
     * @return List of entities
     */
    List<E> convertDtoListToEntityList(List<D> ds);

    /**
     * Entity list do DTO list
     *
     * @param es entities
     * @return List of DTOs
     */
    List<D> convertEntityListToDtoList(List<E> es);
}
