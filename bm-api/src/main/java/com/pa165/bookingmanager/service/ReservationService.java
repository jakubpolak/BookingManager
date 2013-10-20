package com.pa165.bookingmanager.service;

import com.pa165.bookingmanager.dto.ReservationDto;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * @author Jakub Polak
 */
public interface ReservationService
{
    /**
     * Find all
     *
     * @return list of reservation DTOs
     */
    List<ReservationDto> findAll();


    /**
     * Find by criteria
     *
     * @param criterion
     * @return list of reservation DTOs
     */
    List<ReservationDto> findByCriteria(Criterion criterion);

    /**
     * Find
     *
     * @param id
     * @return reservation DTO
     */
    ReservationDto find(Long id);

    /**
     * Create
     *
     * @param reservationDto reservation DTO
     */
    void create(ReservationDto reservationDto);

    /**
     * Update
     *
     * @param reservationDto reservation DTO
     */
    void update(ReservationDto reservationDto);

    /**
     * Delete
     *
     * @param reservationDto reservation DTO
     */
    void delete(ReservationDto reservationDto);
}
