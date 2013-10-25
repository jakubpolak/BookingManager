package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.HotelDtoImpl;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

/**
 * @author Josef Stribny
 */
public class HotelConvertorImpl {

    /**
     * Convert entity to DTO
     *
     * @param entity
     * @return hotel entity
     */
    public static HotelDto convertEntityToDto(HotelEntity entity) {
        if (entity == null) {
            return null;
        }

        HotelDto dto = new HotelDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Convert associated room entities to DTO
        ArrayList<RoomDto> roomsById = new ArrayList<>();
        for (RoomEntity room: entity.getRoomsById()) {
            RoomDto roomDto = new RoomDtoImpl();
            BeanUtils.copyProperties(room, roomDto);

            // Convert associated reservations entities to DTO
            ArrayList<ReservationDto> reservationsById = new ArrayList<>();
            for (ReservationEntity reservation: room.getReservationsById()) {
                ReservationDto reservationDto = new ReservationDtoImpl();
                BeanUtils.copyProperties(reservation, reservationDto);
                reservationsById.add(reservationDto);
            }

            roomDto.setReservationsById(reservationsById);
            roomsById.add(roomDto);
        }

        dto.setRoomsById(roomsById);

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return hotel entity
     */
    public static HotelEntity convertDtoToEntity(HotelDto dto) {
        if (dto == null) {
            return null;
        }

        HotelEntity entity = new HotelEntity();
        BeanUtils.copyProperties(dto, entity);

        // Convert associated rooms DTO to entities
        ArrayList<RoomEntity> roomsById = new ArrayList<>();
        for (RoomDto room: dto.getRoomsById()) {
            RoomEntity roomEntity = new RoomEntity();
            BeanUtils.copyProperties(room, roomEntity);

            // Convert associated reservations DTO to entities
            ArrayList<ReservationEntity> reservationsById = new ArrayList<>();
            for (ReservationDto reservation: room.getReservationsById()) {
                ReservationEntity reservationEntity = new ReservationEntity();
                BeanUtils.copyProperties(reservation, roomEntity);
                reservationsById.add(reservationEntity);
            }

            roomEntity.setReservationsById(reservationsById);
            roomsById.add(roomEntity);
        }

        entity.setRoomsById(roomsById);

        return entity;
    }
}
