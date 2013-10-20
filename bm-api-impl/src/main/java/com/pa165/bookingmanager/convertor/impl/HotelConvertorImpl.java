package com.pa165.bookingmanager.convertor.impl;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;

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
            RoomDto roomDTO = new RoomDto();
            roomDTO.setId(room.getId());
            roomDTO.setNumber(room.getNumber());
            roomDTO.setPrice(room.getPrice());
            roomDTO.setHotelByHotelId(dto);

            // Convert associated reservations entities to DTO
            ArrayList<ReservationDto> reservationsById = new ArrayList<>();
            for (ReservationEntity reservation: room.getReservationsById()) {
                ReservationDto reservationDTO = new ReservationDto();
                reservationDTO.setId(reservation.getId());
                reservationDTO.setCustomerEmail(reservation.getCustomerEmail());
                reservationDTO.setCustomerName(reservation.getCustomerName());
                reservationDTO.setCustomerPhone(reservation.getCustomerPhone());
                reservationDTO.setReservationFrom(reservation.getReservationFrom());
                reservationDTO.setReservationTo(reservation.getReservationTo());
                reservationDTO.setRoomByRoomId(roomDTO);
                reservationsById.add(reservationDTO);
            }
            roomDTO.setReservationsById(reservationsById);

            roomsById.add(roomDTO);
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
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setId(room.getId());
            roomEntity.setNumber(room.getNumber());
            roomEntity.setPrice(room.getPrice());
            roomEntity.setHotelByHotelId(entity);

            // Convert associated reservations DTO to entities
            ArrayList<ReservationEntity> reservationsById = new ArrayList<>();
            for (ReservationDto reservation: room.getReservationsById()) {
                ReservationEntity reservationEntity = new ReservationEntity();
                reservationEntity.setId(reservation.getId());
                reservationEntity.setCustomerEmail(reservation.getCustomerEmail());
                reservationEntity.setCustomerName(reservation.getCustomerName());
                reservationEntity.setCustomerPhone(reservation.getCustomerPhone());
                reservationEntity.setReservationFrom(reservation.getReservationFrom());
                reservationEntity.setReservationTo(reservation.getReservationTo());
                reservationEntity.setRoomByRoomId(roomEntity);
                reservationsById.add(reservationEntity);
            }
            roomEntity.setReservationsById(reservationsById);

            roomsById.add(roomEntity);
        }

        entity.setRoomsById(roomsById);
        return entity;
    }
}
