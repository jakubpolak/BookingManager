package com.restclient.client;

import com.restclient.model.Hotel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.BadRequestException;
import java.util.List;


/**
 * Test that demonstrates how to use the HotelClient
 *
 * @author Jan Hrubeš
 */
public class HotelClientTest
{
    private HotelClient hotelClient;

    @Before
    public void setUp()
    {
        hotelClient = new HotelClient("http://bookingmanager.apiary.io");
//        hotelClient.setBaseUrl("http://localhost:8080/rest/hotel");
    }

    @After
    public void tearDown()
    {
        hotelClient = null;
    }

    @Test
    public void testGetHotel()
    {
        // Query for the book with id "123"
        Hotel hotel = hotelClient.getHotel(1L);

        // Run assertions against the response
        Assert.assertNotNull( "Hotel should not be null", hotel );
        Assert.assertEquals("Hotel id is incorrect", (Long) 1L, hotel.getId());
        Assert.assertEquals("Hotel name is incorrect", "Imperial", hotel.getName());
    }

    @Test
    public void testGetHotels()
    {
        // Query for the book with id "123"
        List<Hotel> hotels = hotelClient.getHotels();

        // Run assertions against the response
        Assert.assertNotNull( "Hotel should not be null", hotels );
        Assert.assertEquals( "Hotels count is incorrect", 3, hotels.size() );
    }

    @Test
    public void testCreateHotel()
    {
        // Query for the book with id "123"
        Hotel hotel = hotelClient.getHotel(1L);


        Hotel hotel2 = null;
        try {
            hotel2 = (Hotel) hotelClient.createHotel(hotel).getEntity();
        } catch (BadRequestException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            System.out.print(e.getMessage());
        }

        // Run assertions against the response
        Assert.assertNotNull( "Hotel should not be null", hotel2 );
        Assert.assertEquals("Hotels are not the same", hotel.getName(), hotel2.getName());
    }
}