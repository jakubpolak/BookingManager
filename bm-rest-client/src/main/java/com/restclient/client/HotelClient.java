package com.restclient.client;

import com.restclient.model.Hotel;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Client that knows how to interact with the Hotel REST web service
 *
 * @author Jan Hrubeš
 */

public class HotelClient extends BaseClient
{
    public HotelClient(String url) {
        this.setBaseUrl(url + "/hotel");
    }

    /**
     * Queries the RESTful web service for all hotels
     *
     * @return List<Hotel> hotels
     */
    public List<Hotel> getHotels()
    {
        WebTarget hotelResource = this.getResource().path("");

        Invocation.Builder builder = hotelResource.request(MediaType.APPLICATION_JSON);

        return builder.get( new GenericType<List<Hotel>>() {});
    }

    /**
     * Queries the RESTful web service for the hotel with the specified id
     *
     * @param id        The id of the hotel to retrieve
     *
     * @return          A Hotel object representing the response from the RESTful web service
     */
    public Hotel getHotel( Long id )
    {
        WebTarget hotelResource = this.getResource().path(id.toString());

        Invocation.Builder builder = hotelResource.request(MediaType.APPLICATION_JSON);

        return builder.get(Hotel.class);
    }

    /**
     * Queries the RESTful web service for creating new hotel
     *
     * @param hotel  Hotel entity to create
     * @return
     */
    public Response createHotel(Hotel hotel)
    {
        WebTarget hotelResource = this.getResource().path("create");
        Invocation.Builder builder = hotelResource.request();

        Entity<Hotel> entity = Entity.entity(hotel, MediaType.APPLICATION_JSON);

        return builder.post(entity);
    }

    /**
     * Queries the RESTful web service for deleting hotel
     *
     * @param id  Hotel id to delete
     * @return
     */
    public Response deleteHotel(Long id)
    {
        WebTarget hotelResource = this.getResource().path(id.toString());
        Invocation.Builder builder = hotelResource.request();

        return builder.delete();
    }

    /**
     * Queries the RESTful web service for updating hotel
     *
     * @param hotel  Hotel entity to update
     * @return
     */
    public Response updateHotel(Hotel hotel)
    {
        WebTarget hotelResource = this.getResource().path(hotel.getId().toString());
        Invocation.Builder builder = hotelResource.request();

        Entity<Hotel> entity = Entity.entity(hotel, MediaType.APPLICATION_JSON);

        return builder.put(entity);
    }
}