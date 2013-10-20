package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.service.RoomService;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jana Polakova
 */
@Service("roomService")
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService
{
    @Override
    public List<RoomDto> findAll() {
        return null;
    }

    @Override
    public List<RoomDto> findByCriteria(Criterion criterion) {
        return null;
    }

    @Override
    public RoomDto find(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void create(RoomDto roomDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void update(RoomDto roomDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(RoomDto roomDto) {

    }
}
