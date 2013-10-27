package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Component
public class RoomConvertorImpl extends GenericConvertorImpl<RoomEntity, RoomDto>
{
    @Autowired
    HotelConvertorImpl hotelConvertor;

    /**
     * {@inheritDoc}
     */
    public RoomDto convertEntityToDto(RoomEntity roomEntity) {
        if (roomEntity == null) {
            throw new IllegalArgumentException("RoomEntity can't be null.");
        }

        RoomDto roomDto = new RoomDtoImpl();
        BeanUtils.copyProperties(roomEntity, roomDto, new String[] {"hotelByHotelId", "reservationsById"});

        HotelEntity hotelEntity = roomEntity.getHotelByHotelId();

        if (hotelEntity != null){
            // Hotel Entity -> Hotel DTO
            roomDto.setHotelByHotelId(
                hotelConvertor.convertEntityToDto(hotelEntity)
            );
        }

        // Reservation Entities -> Hotel DTOs
        List<ReservationEntity> reservationEntities = roomEntity.getReservationsById();

        if (reservationEntities != null){
            List<ReservationDto> reservationDtos = new ArrayList<>();

            for (ReservationEntity reservationEntity : reservationEntities){
                ReservationDto reservationDto = new ReservationDtoImpl();
                BeanUtils.copyProperties(reservationEntity, reservationDto, new String[] {"roomByRoomId"});
                reservationDto.setRoomByRoomId(roomDto);
                reservationDtos.add(reservationDto);
            }

            roomDto.setReservationsById(reservationDtos);
        }

        return roomDto;
    }

    /**
     * {@inheritDoc}
     */
    public RoomEntity convertDtoToEntity(RoomDto roomDto) {
        if (roomDto == null) {
            throw new IllegalArgumentException("RoomDto can't be null.");
        }

        RoomEntity roomEntity = new RoomEntity();
        BeanUtils.copyProperties(roomDto, roomEntity, new String[] {"hotelByHotelId", "reservationsById"});

        // Hotel DTO -> Hotel Entity
        HotelDto hotelDto = roomDto.getHotelByHotelId();

        if (hotelDto != null){
            roomEntity.setHotelByHotelId(
                hotelConvertor.convertDtoToEntity(hotelDto)
            );
        }

        // Reservation DTOs -> Reservationt Entities
        List<ReservationDto> reservationDtos = roomDto.getReservationsById();

        if (reservationDtos != null){
            List<ReservationEntity> reservationEntities = new ArrayList<>();

            for (ReservationDto reservationDto : reservationDtos){
                ReservationEntity reservationEntity = new ReservationEntity();
                BeanUtils.copyProperties(reservationDto, reservationEntity, new String[] {"roomByRoomId"});
                reservationEntity.setRoomByRoomId(roomEntity);
                reservationEntities.add(reservationEntity);
            }

            roomEntity.setReservationsById(reservationEntities);
        }

        return roomEntity;
    }
}
