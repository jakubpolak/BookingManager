package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.dto.RoleDto;
import com.pa165.bookingmanager.service.RoleService;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jana Polakova
 */
@Service("roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService
{
    @Override
    public List<RoleDto> findAll() {
        return null;
    }

    @Override
    public List<RoleDto> findByCriteria(Criterion criterion) {
        return null;
    }

    @Override
    public RoleDto find(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void create(RoleDto roleDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void update(RoleDto roleDto) {

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(RoleDto roleDto) {

    }
}
