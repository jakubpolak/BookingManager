package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
import com.pa165.bookingmanager.entity.HotelEntity;
import com.pa165.bookingmanager.entity.ReservationEntity;
import com.pa165.bookingmanager.entity.RoomEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Polak
 */
public class RoomConvertor
{
    /**
     * Convert entity to DTO
     *
     * @param entity
     * @return room entity
     */
    public static RoomDto convertEntityToDto(RoomEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("RoomEntity can't be null.");
        }

        RoomDto dto = new RoomDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        HotelEntity hotelEntity = entity.getHotelByHotelId();

        if (hotelEntity != null){
            // Hotel Entity -> Hotel DTO
            dto.setHotelByHotelId(
                HotelConvertor.convertEntityToDto(hotelEntity)
            );
        }

        // Reservation Entities -> Hotel DTOs
        List<ReservationEntity> reservationEntities = entity.getReservationsById();

        if (reservationEntities != null){
            List<ReservationDto> reservationDtos = new ArrayList<>();

            for (ReservationEntity reservationEntity : reservationEntities){
                reservationDtos.add(
                    ReservationConvertor.convertEntityToDto(reservationEntity)
                );
            }

            dto.setReservationsById(reservationDtos);
        }

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return room entity
     */
    public static RoomEntity convertDtoToEntity(RoomDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("RoomDto can't be null.");
        }

        RoomEntity entity = new RoomEntity();
        BeanUtils.copyProperties(dto, entity);

        // Hotel DTO -> Hotel Entity
        HotelDto hotelDto = dto.getHotelByHotelId();

        if (hotelDto != null){
            entity.setHotelByHotelId(
                HotelConvertor.convertDtoToEntity(hotelDto)
            );
        }

        // Reservation DTOs -> Reservationt Entities
        List<ReservationDto> reservationDtos = dto.getReservationsById();

        if (reservationDtos != null){
            List<ReservationEntity> reservationEntities = new ArrayList<>();

            for (ReservationDto reservationDto : reservationDtos){
                reservationEntities.add(
                    ReservationConvertor.convertDtoToEntity(reservationDto)
                );
            }

            entity.setReservationsById(reservationEntities);
        }

        return entity;
    }
}
