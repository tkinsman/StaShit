package edu.matc.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import edu.matc.entity.MapStorageLocation;
import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import edu.matc.entity.User;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.persistence.StorageSpaceDao;
import edu.matc.persistence.UserDao;
import edu.matc.util.LocationServices;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Todo remove password error from login jsp
/**
 * Created by toddkinsman on 9/22/16.
 *
 * Direct successful login to userhome
 */
@WebServlet(
        name = "userhome",
        urlPatterns = { "/userhome" }
)
public class UserLoggedIn extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private List<StorageSpace> storageSpaces;
    private List<StorageLocation> storageLocations;
    private StorageSpaceDao storageSpaceDao;
    private StorageLocationDao storageLocationDao;
    private LocationServices locationServices;
    private List<MapStorageLocation> mapStorageLocation;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        locationServices = new LocationServices();

        HttpSession session = req.getSession();
        String sessionId = session.getId();

        String username = req.getRemoteUser();
        storageLocations = getStorageLocations(username);
        mapStorageLocation = locationServices.convertStorageLocsToMapLocs(storageLocations);
        session.setAttribute("username", username);
        session.setAttribute("addUserMessage", "Successfully logged in");
        session.setAttribute("storageLocations", storageLocations);
        session.setAttribute("storageMapLocations", mapStorageLocation);


//        //Todo get user location from user
        storageSpaces = getStorageSpaces(username);
        session.setAttribute("storageSpaces", storageSpaces);

        String url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(req, resp);


    }

    public List<StorageSpace> getStorageSpaces(String username) {

        storageSpaceDao = new StorageSpaceDao();
        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();

        //// TODO: 11/29/16 fix the name of method
        storageSpaces = storageSpaceDao.getAllRelatedStorageSpacesForUser(username);

        return storageSpaces;

    }

    public List<StorageLocation> getStorageLocations(String username) {

         storageLocationDao = new StorageLocationDao();
        List<StorageLocation> storageLocations = new ArrayList<StorageLocation>();

        //// TODO: 11/29/16 fixe the name of method
        storageLocations = storageLocationDao.getStorageLocationsByUserName(username);

        return storageLocations;

    }
}
