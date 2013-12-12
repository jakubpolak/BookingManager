package com.restclient.client;

import com.restclient.model.Role;
import com.restclient.model.User;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Client that knows how to interact with the User REST web service
 * @author Jan Hrubeš
 */
public class UserClient extends BaseClient
{
    public UserClient(String url) {
        this.setBaseUrl(url + "/user");
    }

    /**
     * Queries the RESTful web service for all users
     *
     * @return List<User> users
     */
    public List<User> getUsers()
    {
        WebTarget userResource = this.getResource().path("");

        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        return builder.get( new GenericType<List<User>>() {});
    }

    /**
     * Queries the RESTful web service for the user with the specified id
     *
     * @param id        The id of the user to retrieve
     *
     * @return User     A User object representing the response from the RESTful web service
     */
    public User getUser( Long id )
    {
        WebTarget userResource = this.getResource().path(id.toString());

        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        return builder.get(User.class);
    }

    /**
     * Queries the RESTful web service for all roles
     *
     * @return List<Role> users
     */
    public List<Role> getRoles()
    {
        WebTarget userResource = this.getResource().path("roles");

        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        return builder.get( new GenericType<List<Role>>() {});
    }

    /**
     * Queries the RESTful web service for creating new user
     *
     * @param user  User entity to create
     * @return
     */
    public Response createUser(User user)
    {
        WebTarget userResource = this.getResource().path("create");
        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        Entity<User> entity = Entity.entity(user, MediaType.APPLICATION_JSON);

        return builder.post(entity);
    }

    /**
     * Queries the RESTful web service for deleting user
     *
     * @param id  User id to delete
     * @return
     */
    public Response deleteUser(Long id)
    {
        WebTarget userResource = this.getResource().path(id.toString());
        Invocation.Builder builder = userResource.request(MediaType.APPLICATION_JSON);

        return builder.delete();
    }

    /**
     * Queries the RESTful web service for updating user
     *
     * @param user  User entity to update
     * @return
     */
    public Response updateUser(User user)
    {
        WebTarget userResource = this.getResource().path(user.getId().toString());
        Invocation.Builder builder = userResource.request();

        Entity<User> entity = Entity.entity(user, MediaType.APPLICATION_JSON);

        return builder.put(entity);
    }
}