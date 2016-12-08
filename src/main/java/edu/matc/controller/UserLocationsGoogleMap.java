package edu.matc.controller;

import com.google.gson.Gson;
import edu.matc.entity.MapStorageLocation;
import edu.matc.entity.StorageLocation;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.util.FormatAddress;
import edu.matc.util.LocationServices;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toddkinsman on 12/4/16.
 */
@WebServlet(name = "userlocationsmap",
            urlPatterns = "/userlocationsmap"
)
public class UserLocationsGoogleMap extends HttpServlet{
    private final Logger log = Logger.getLogger(this.getClass());

    private StorageLocationDao storageLocationDao;
    List<StorageLocation> storageLocationList;
    FormatAddress formatAddress;
    StorageLocation storageLocation;
    List<MapStorageLocation> mapStorageLocationList;
    ArrayList latLong;
    LocationServices locationServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        locationServices = new LocationServices();
        mapStorageLocationList = new ArrayList<MapStorageLocation>();
        storageLocationList = new ArrayList<StorageLocation>();
        formatAddress = new FormatAddress();
        latLong = new ArrayList();
        String geoJsonForMap;

        String username = req.getRemoteUser();
        storageLocationList = getStorageLocations(username);

        log.info("The user name from googlemaps locs " + username);
        log.info("The storage location list from maps " + storageLocationList);

        mapStorageLocationList = locationServices.convertStorageLocsToMapLocs(storageLocationList);
        geoJsonForMap = locationServices.createGeoJsonObject(mapStorageLocationList);

        log.info("The map location list in servlet: " + mapStorageLocationList);

        Gson gson = new Gson();

        String jsonMapObj = gson.toJson(geoJsonForMap);

        log.info("The json string in user locaitons is: " + geoJsonForMap);



        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(geoJsonForMap);

    }




    public List<StorageLocation> getStorageLocations(String username) {

        storageLocationDao = new StorageLocationDao();
        List<StorageLocation> storageLocations = new ArrayList<StorageLocation>();

        //// TODO: 11/29/16 fixe the name of method
        storageLocations = storageLocationDao.getStorageLocationsByUserName(username);

        return storageLocations;

    }
}
