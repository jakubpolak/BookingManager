package com.pa165.bookingmanager.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Josef Stribny
 */
public interface HotelDto extends Serializable
{
    /**
     * Get id
     *
     * @return id
     */
    Long getId();

    /**
     * Set id
     *
     * @param id
     */
    void setId(Long id);

    /**
     * Get name
     *
     * @return
     */
    String getName();

    /**
     * Set name
     *
     * @param name
     */
    void setName(String name);

    /**
     * Get rooms by id
     *
     * @return rooms by id
     */
    List<RoomDto> getRoomsById();

    /**
     * Set rooms by id
     *
     * @param roomsById
     */
    void setRoomsById(List<RoomDto> roomsById);
}
