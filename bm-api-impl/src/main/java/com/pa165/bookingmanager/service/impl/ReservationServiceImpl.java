package com.pa165.bookingmanager.service.impl;

import com.pa165.bookingmanager.convertor.impl.ReservationConvertorImpl;
import com.pa165.bookingmanager.dao.ReservationDao;
import com.pa165.bookingmanager.dao.RoomDao;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import com.pa165.bookingmanager.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Jana Polakova, Jakub Polak, Jan Hrubes, Josef Stribny
 */
@Service("reservationService")
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService
{
    @Autowired
    ReservationDao reservationDao;
    
    @Autowired
    RoomDao roomDao;

    @Autowired
    ReservationConvertorImpl reservationConvertor;

    /**
     * Constructor
     */
    public ReservationServiceImpl(){

    }

    /**
     * Constructor
     *
     * @param reservationDao reservation dao
     * @param reservationConvertor reservation convertor
     * @param roomDao room dao
     */
    public ReservationServiceImpl(ReservationDao reservationDao, ReservationConvertorImpl reservationConvertor, RoomDao roomDao){
        if (reservationDao == null){
            throw new IllegalArgumentException("ReservationDao can't be null.");
        }
        this.reservationDao = reservationDao;

        if (reservationConvertor == null){
            throw new IllegalArgumentException("ReservationConvertor can't be null.");
        }

        this.reservationConvertor = reservationConvertor;

        if (roomDao == null){
            throw new IllegalArgumentException("RoomDao can't be null.");
        }

        this.roomDao = roomDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationDto> findAll() {
        List<ReservationEntity> reservationEntities = reservationDao.findAll();
        List<ReservationDto> reservationDtos = null;

        if (reservationEntities != null){
            reservationDtos = reservationConvertor.convertEntityListToDtoList(reservationEntities);
        }

        return reservationDtos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationDto find(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        ReservationEntity reservationEntity = reservationDao.find(id);
        ReservationDto reservationDto = null;

        if (reservationEntity != null){
            reservationDto = reservationConvertor.convertEntityToDto(reservationEntity);
        }

        return reservationDto;
    }

    /**
     * Find by room
     *
     * @param id
     * @return reservation dtos
     */
    @Override
    public List<ReservationDto> findByRoom(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Id can't be null.");
        }

        List<ReservationEntity> reservationEntities = reservationDao.findByRoom(id);
        List<ReservationDto> reservationDtos = null;

        if (reservationEntities != null){
            reservationDtos = reservationConvertor.convertEntityListToDtoList(reservationEntities);
        }

        return reservationDtos;
    }

    /**
     * {@inheritDoc}
     * @return 
     */
    @Override
    @Transactional(readOnly = false)
    public ReservationDto create(ReservationDto reservationDto) {
        if (reservationDto == null){
            throw new IllegalArgumentException("ReservationDto can't be null.");
        }
        ReservationEntity reservation = reservationConvertor.convertDtoToEntity(reservationDto);
        
        if(reservationDto.getRoomByRoomId() != null) {
        	reservation.setRoomByRoomId(
        		roomDao.find(reservationDto.getRoomByRoomId().getId())
        	);
        }
        
        if(!this.isRoomAvailable(reservation.getRoomByRoomId().getId(), reservation.getReservationFrom(), reservation.getReservationTo())){
        	throw new IllegalArgumentException("Reservation is conflicting with other reservation.");
        }
    	reservationDao.create(reservation);
    	System.out.println("Service:");
        System.out.println(reservation.toString());
    	reservationDto = reservationConvertor.convertEntityToDto(reservation);
    	return reservationDto;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void update(ReservationDto reservationDto) {
        if (reservationDto == null){
            throw new IllegalArgumentException("ReservationDto can't be null.");
        }

        ReservationEntity reservationEntity = reservationDao.find(reservationDto.getId());

        if (reservationEntity != null){
            reservationConvertor.convertDtoToEntity(reservationDto, reservationEntity);
            reservationDao.update(reservationEntity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(ReservationDto reservationDto) {
        if (reservationDto == null){
            throw new IllegalArgumentException("ReservationDto can't be null.");
        }

        ReservationEntity reservationEntity = reservationDao.find(reservationDto.getId());

        if (reservationEntity != null){
            reservationDao.delete(reservationEntity);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRoomAvailable(Long id, Date reservationFrom, Date reservationTo){
    	RoomEntity roomEntity = roomDao.find(id);

    	return reservationDao.isRoomAvailable(roomEntity, reservationFrom, reservationTo);
    }
}
