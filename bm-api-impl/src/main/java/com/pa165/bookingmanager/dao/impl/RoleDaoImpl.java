package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.RoleDao;
import com.pa165.bookingmanager.entity.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Polakova
 */
@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoImpl<RoleEntity, Long> implements RoleDao
{
    /**
     * Constructor
     */
    public RoleDaoImpl(){
        super(RoleEntity.class);
    }
}
