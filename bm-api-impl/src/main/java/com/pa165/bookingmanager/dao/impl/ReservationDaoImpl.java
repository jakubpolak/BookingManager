package com.pa165.bookingmanager.dao.impl;

import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.dao.exception.DaoException;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Jana Polakova, Josef Stribny
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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRoomAvailable(RoomEntity room, Date from, Date to){    	
    	Criteria criteria = getCurrentSession().createCriteria(ReservationEntity.class)
    	.add(Restrictions.eq("roomByRoomId", room))
    	.add(
    		Restrictions.disjunction()
    			.add(
    				Restrictions.conjunction()
    					.add(Restrictions.le("reservationFrom", from))
    					.add(Restrictions.gt("reservationTo", from))
    			)
    		    .add(
    		    	Restrictions.conjunction()
    					.add(Restrictions.lt("reservationFrom", to))
    					.add(Restrictions.ge("reservationTo", to))
    	    	)
    		    .add(
    		    	Restrictions.conjunction()
    					.add(Restrictions.ge("reservationFrom", from))
    					.add(Restrictions.le("reservationTo", to))
    		    )
    	);

    	Long result = (Long) criteria.setProjection(Projections.rowCount()).list().get(0);
    	    	
    	if(result == 0L) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
