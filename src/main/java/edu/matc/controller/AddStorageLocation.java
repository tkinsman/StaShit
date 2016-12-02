package edu.matc.controller;

import edu.matc.entity.StorageLocation;
import edu.matc.persistence.StorageLocationDao;

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
@WebServlet(
        name = "addlocation",
        urlPatterns = { "/addlocation" }
)
public class AddStorageLocation extends HttpServlet{
    StorageLocationDao storageLocationDao;


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url;
        HttpSession session = req.getSession();

        List<StorageLocation> storageLocationList = new ArrayList<StorageLocation>();


        String stoLocName = req.getParameter("stoLocName");
        String stoLocDescription = req.getParameter("stoLocDescription");
        String stoLocAddress = req.getParameter("stoLocAddress");
        String city = req.getParameter("city");
        String state = req.getParameter("stoLocState");
        String zip = req.getParameter("stoLocZip");
        String username = req.getRemoteUser();
        storageLocationList = getStorageLocations(username);
        int addSuccess;

        StorageLocation storageLocation = new StorageLocation(stoLocDescription, stoLocAddress, city, state, zip, stoLocName, username);

//      todo: add validation for successful add and form falidation
        addSuccess = storageLocationDao.addStorageLocation(storageLocation);
        storageLocationList = storageLocationDao.getStorageLocationsByUserName(username);

        session.setAttribute("storageLocations", storageLocationList);

        url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

    public List<StorageLocation> getStorageLocations(String username) {

        storageLocationDao = new StorageLocationDao();
        List<StorageLocation> storageLocations = new ArrayList<StorageLocation>();

        //// TODO: 11/29/16 fixe the name of method
        storageLocations = storageLocationDao.getStorageLocationsByUserName(username);

        return storageLocations;

    }

}
