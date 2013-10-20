package com.pa165.bookingmanager.convertor;

/**
 * @author Josef Stribny
 *
 * @param <E> entity
 * @param <D> DTO
 */
public interface Convertor<E, D> {

    /**
     * Convert entity to DTO
     * @param entity
     * @return DTO
     */
    public D convertEntityToDto(E entity);

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return entity
     */
    public E convertDtoToEntity(D dto);
}
