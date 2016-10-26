package edu.matc.service;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by toddkinsman on 10/26/16.
 */
@Path("/UserService")
public class UserService {

    UserDao userDao = new UserDao();

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers(){
        return userDao.getAllUsers();
    }

    @GET
    @Path("/users/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserWithId(@PathParam("param") int userId) {
        User user = userDao.getUser(userId);

        return user;
    }



}
