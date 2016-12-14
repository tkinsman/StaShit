package edu.matc.service;

import edu.matc.entity.MapStorageLocation;
import edu.matc.entity.StorageLocation;
import edu.matc.entity.User;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.persistence.UserDao;
import edu.matc.util.LocationServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The service class that outlines all the endpoints needed for the Restful API
 *
 * Created by toddkinsman on 10/26/16.
 */
@Path("/UserService")
public class UserService {

    UserDao userDao = new UserDao();

    /**
     * The get all users endpoint
     * @return
     */
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        List<User> users = userDao.getAllUsers();
        return users;
    }

    /**
     * The get user by Id endpoint
     * @param userId
     * @return
     */
    @GET
    @Path("/users/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserWithId(@PathParam("param") int userId) {
        User user = userDao.getUser(userId);

        return Response.status(200).entity(user).build();
    }

    /**
     * The get user locations endpoint
     *
     * @param userName
     * @return
     */
    @GET
    @Path("/userlocations/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StorageLocation> getUserLocationsJson(@PathParam("userName") String userName){
        List<StorageLocation> storageLocations = new ArrayList<>();

        //Get storage locations
        List<MapStorageLocation> mapStorageLocations = new ArrayList<>();
        StorageLocationDao storageLocationDao = new StorageLocationDao();
        storageLocations = storageLocationDao.getStorageLocationsByUserName(userName);


        return storageLocations;
    }

    /**
     * The get user geoJSON locations
     *
     * @param userName
     * @return
     */
    @GET
    @Path("/userMaplocations/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMapLocationsJson(@PathParam("userName") String userName){
        List<StorageLocation> storageLocations = new ArrayList<>();
        LocationServices locationServices = new LocationServices();
        String json;

        //Get storage locations
        List<MapStorageLocation> mapStorageLocations = new ArrayList<>();
        StorageLocationDao storageLocationDao = new StorageLocationDao();
        storageLocations = storageLocationDao.getStorageLocationsByUserName(userName);

        //Send storage location to contructu map with lat long
        mapStorageLocations = locationServices.convertStorageLocsToMapLocs(storageLocations);
        json = locationServices.createGeoJsonObject(mapStorageLocations);

        return json;
    }





}
