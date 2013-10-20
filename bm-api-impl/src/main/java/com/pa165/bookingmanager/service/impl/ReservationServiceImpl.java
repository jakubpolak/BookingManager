package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.service.ReservationService;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jana Polakova
 */
@Service("reservationService")
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService
{
    @Override
    public List<ReservationDto> findAll() {
        return null;
    }

    @Override
    public List<ReservationDto> findByCriteria(Criterion criterion) {
        return null;
    }

    @Override
    public ReservationDto find(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void create(ReservationDto reservationDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void update(ReservationDto reservationDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(ReservationDto reservationDto) {

    }
}
