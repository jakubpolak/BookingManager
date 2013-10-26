package com.pa165.bookingmanager.convertor;

import com.pa165.bookingmanager.dto.HotelDto;
import com.pa165.bookingmanager.dto.ReservationDto;
import com.pa165.bookingmanager.dto.RoomDto;
import com.pa165.bookingmanager.dto.impl.ReservationDtoImpl;
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
     * @param roomEntity
     * @return room entity
     */
    public static RoomDto convertEntityToDto(RoomEntity roomEntity) {
        if (roomEntity == null) {
            throw new IllegalArgumentException("RoomEntity can't be null.");
        }

        RoomDto roomDto = new RoomDtoImpl();
        BeanUtils.copyProperties(roomEntity, roomDto, new String[] {"hotelByHotelId", "reservationsById"});

        HotelEntity hotelEntity = roomEntity.getHotelByHotelId();

        if (hotelEntity != null){
            // Hotel Entity -> Hotel DTO
            roomDto.setHotelByHotelId(
                HotelConvertor.convertEntityToDto(hotelEntity)
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
     * Convert DTO to entity
     *
     * @param roomDto
     * @return room entity
     */
    public static RoomEntity convertDtoToEntity(RoomDto roomDto) {
        if (roomDto == null) {
            throw new IllegalArgumentException("RoomDto can't be null.");
        }

        RoomEntity roomEntity = new RoomEntity();
        BeanUtils.copyProperties(roomDto, roomEntity, new String[] {"hotelByHotelId", "reservationsById"});

        // Hotel DTO -> Hotel Entity
        HotelDto hotelDto = roomDto.getHotelByHotelId();

        if (hotelDto != null){
            roomEntity.setHotelByHotelId(
                HotelConvertor.convertDtoToEntity(hotelDto)
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
