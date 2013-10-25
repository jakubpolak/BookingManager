package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.RoomDtoImpl;
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
        if (entity == null) return null;

        RoomDto dto = new RoomDtoImpl();
        BeanUtils.copyProperties(entity, dto);

        // Hotel Entity -> Hotel DTO
        dto.setHotelByHotelId(
            HotelConvertor.convertEntityToDto(
                entity.getHotelByHotelId()
            )
        );

        // Reservation Entities -> Hotel DTOs
        List<ReservationDto> reservationDtos = new ArrayList<>();
        List<ReservationEntity> reservationEntities = entity.getReservationsById();

        for (ReservationEntity reservationEntity : reservationEntities){
            reservationDtos.add(
                ReservationConvertor.convertEntityToDto(reservationEntity)
            );
        }

        dto.setReservationsById(reservationDtos);

        return dto;
    }

    /**
     * Convert DTO to entity
     *
     * @param dto
     * @return room entity
     */
    public static RoomEntity convertDtoToEntity(RoomDto dto) {
        if (dto == null) return null;

        RoomEntity roomEntity = new RoomEntity();
        BeanUtils.copyProperties(dto, roomEntity);

        // Hotel DTO -> Hotel Entity
        roomEntity.setHotelByHotelId(
            HotelConvertor.convertDtoToEntity(
                    dto.getHotelByHotelId()
            )
        );

        // Reservation DTOs -> Reservationt Entities
        List<ReservationEntity> reservationEntities = new ArrayList<>();
        List<ReservationDto> reservationDtos = dto.getReservationsById();

        for (ReservationDto reservationDto : reservationDtos){
            reservationEntities.add(
                ReservationConvertor.convertDtoToEntity(reservationDto)
            );
        }

        roomEntity.setReservationsById(reservationEntities);

        return null;
    }
}
