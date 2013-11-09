package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.dao.exception.DaoException;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Jana Polakova
 */
@Repository("reservationDao")
public class ReservationDaoImpl extends GenericDaoImpl<ReservationEntity, Long> implements ReservationDao
{
    @Autowired
    private RoomDao roomDao;

    /**
     * Constructor
     */
    public ReservationDaoImpl(){
        super(ReservationEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<ReservationEntity> findByRoom(Long id) throws DataAccessException {
        if (id == null){
            throw new DaoException("Id can't be null.");
        }

        RoomEntity roomEntity = roomDao.find(id);
        List<ReservationEntity> reservationEntities = null;

        if (roomEntity != null){
            Criteria criteria = getCurrentSession().createCriteria(ReservationEntity.class);
            reservationEntities = criteria.add(Restrictions.eq("roomByRoomId", roomEntity)).list();
        }

        return reservationEntities;
    }
}
