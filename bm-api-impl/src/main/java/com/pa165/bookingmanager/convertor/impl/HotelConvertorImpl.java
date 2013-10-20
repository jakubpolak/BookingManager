package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
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

        HotelDto dto = new HotelDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        // Convert associated room entities to DTO
        ArrayList<RoomDto> roomsById = new ArrayList<>();
        for (RoomEntity room: entity.getRoomsById()) {
            // TODO: Check if works
            RoomDto roomDto = new RoomDto();
            BeanUtils.copyProperties(room, roomDto);

            // TODO: Remove if BeanUtils.copyProperties works correctly
            /*
            roomDto.setId(room.getId());
            roomDto.setNumber(room.getNumber());
            roomDto.setPrice(room.getPrice());
            roomDto.setHotelByHotelId(dto);
            */

            // Convert associated reservations entities to DTO
            ArrayList<ReservationDto> reservationsById = new ArrayList<>();
            for (ReservationEntity reservation: room.getReservationsById()) {
                // TODO: Check if works
                ReservationDto reservationDto = new ReservationDto();
                BeanUtils.copyProperties(reservation, reservationDto);

                // TODO: Remove if BeanUtils.copyProperties works correctly
                /*
                reservationDto.setId(reservation.getId());
                reservationDto.setCustomerEmail(reservation.getCustomerEmail());
                reservationDto.setCustomerName(reservation.getCustomerName());
                reservationDto.setCustomerPhone(reservation.getCustomerPhone());
                reservationDto.setReservationFrom(reservation.getReservationFrom());
                reservationDto.setReservationTo(reservation.getReservationTo());
                resservationDto.setRoomByRoomId(roomDto);
                */

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
    public static HotelEntity convertDTOToEntity(HotelDto dto) {
        if (dto == null) {
            return null;
        }
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        // Convert associated rooms DTO to entities
        ArrayList<RoomEntity> roomsById = new ArrayList<>();
        for (RoomDto room: dto.getRoomsById()) {
            // TODO: Check if works
            RoomEntity roomEntity = new RoomEntity();
            BeanUtils.copyProperties(room, roomEntity);

            // TODO: Remove if BeanUtils.copyProperties works correctly
            /*
            roomEntity.setId(room.getId());
            roomEntity.setNumber(room.getNumber());
            roomEntity.setPrice(room.getPrice());
            roomEntity.setHotelByHotelId(entity);
            */

            // Convert associated reservations DTO to entities
            ArrayList<ReservationEntity> reservationsById = new ArrayList<>();
            for (ReservationDto reservation: room.getReservationsById()) {
                // TODO: Check if works
                ReservationEntity reservationEntity = new ReservationEntity();
                BeanUtils.copyProperties(room, roomEntity);

                // TODO: Remove if BeanUtils.copyProperties works correctly
                /*
                reservationEntity.setId(reservation.getId());
                reservationEntity.setCustomerEmail(reservation.getCustomerEmail());
                reservationEntity.setCustomerName(reservation.getCustomerName());
                reservationEntity.setCustomerPhone(reservation.getCustomerPhone());
                reservationEntity.setReservationFrom(reservation.getReservationFrom());
                reservationEntity.setReservationTo(reservation.getReservationTo());
                reservationEntity.setRoomByRoomId(roomEntity);
                */

                reservationsById.add(reservationEntity);
            }
            roomEntity.setReservationsById(reservationsById);

            roomsById.add(roomEntity);
        }

        entity.setRoomsById(roomsById);

        return entity;
    }
}
