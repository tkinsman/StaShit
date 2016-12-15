package edu.matc.controller;

import edu.matc.entity.StorageLocation;
import edu.matc.persistence.StorageLocationDao;
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

/**
 * Created by toddkinsman on 9/22/16.
 */
/**
 * Add Storage Location servlet to add new location to db using dao
 *
 *
 * @author Todd Kinsman
 * @since 10/27/16
 */
@WebServlet(
        name = "addlocation",
        urlPatterns = { "/addlocation" }
)
public class AddStorageLocation extends HttpServlet{

    StorageLocationDao storageLocationDao1;
    List<StorageLocation> storageLocationList;

    private final Logger log = Logger.getLogger(this.getClass());


    /**
     *  Handles HTTP POST requests for new location form.
     *
     *@param  req               an httpServlet request
     *@param  resp              an httpServlet response
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String url;
        HttpSession session = req.getSession();
        storageLocationDao1 = new StorageLocationDao();

        String stoLocName = req.getParameter("stoLocName");
        String stoLocDescription = req.getParameter("stoLocDescription");
        String stoLocAddress = req.getParameter("stoLocAddress");
        String city = req.getParameter("city");
        String state = req.getParameter("stoLocState");
        String zip = req.getParameter("stoLocZip");
        String username = req.getRemoteUser();
        StorageLocation storageLocation = new StorageLocation(stoLocDescription, stoLocAddress, city, state,
                zip, stoLocName, username);

        storageLocationDao1.addStorageLocation(storageLocation);
        storageLocationList = addStorageloc(username);

        session.setAttribute("storageLocations", storageLocationList);

        url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }

    /**
     *  Helper method to get all locations associated with a user.
     *
     * @param username
     * @return storage location object
     */
    public List<StorageLocation> addStorageloc(String username) {

        StorageLocationDao storageLocationDao = new StorageLocationDao();
        List<StorageLocation> storageLocations = new ArrayList<>();
        storageLocations = storageLocationDao.getStorageLocationsByUserName(username);

        return storageLocations;
    }



}
