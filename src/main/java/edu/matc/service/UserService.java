package edu.matc.service;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by toddkinsman on 10/26/16.
 */
@Path("/UserService")
public class UserService {

    UserDao userDao = new UserDao();

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        List<User> users = userDao.getAllUsers();
        return users;
    }

    @GET
    @Path("/users/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserWithId(@PathParam("param") int userId) {
        User user = userDao.getUser(userId);

        return Response.status(200).entity(user).build();
    }



}
