package com.restclient.client;

import com.restclient.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Test that demonstrates how to use the UserClient
 *
 * @author Jan Hrubeš
 */
public class UserClientTest
{
    private UserClient userClient;

    @Before
    public void setUp()
    {
        userClient = new UserClient("http://bookingmanager.apiary.io");
    }

    @After
    public void tearDown()
    {
        userClient = null;
    }

    @Test
    public void testGetUser()
    {
        // Query for the book with id "123"
        User user = userClient.getUser(1L);

        // Run assertions against the response
        Assert.assertNotNull( "user should not be null", user );
        Assert.assertEquals("User id is incorrect", (Long) 1L, user.getId());
        Assert.assertEquals("User name is incorrect", "john@doe.com", user.getEmail());
    }

    @Test
    public void testGetUsers()
    {
        // Query for the book with id "123"
        List<User> users = userClient.getUsers();

        // Run assertions against the response
        Assert.assertNotNull( "User should not be null", users );
        Assert.assertEquals( "Users count is incorrect", 1, users.size() );
    }
}