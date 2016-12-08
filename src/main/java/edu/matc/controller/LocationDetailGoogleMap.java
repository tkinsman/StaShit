package edu.matc.controller;

import com.google.gson.Gson;
import edu.matc.entity.StorageLocation;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.util.FormatAddress;
import edu.matc.util.LocationServices;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Created by toddkinsman on 12/2/16.
 */
@WebServlet(
        name = "locationdetailjs",
        urlPatterns = { "/locationdetailjs" }
)
public class LocationDetailGoogleMap extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    private StorageLocationDao storageLocationDao;
    StorageLocation storageLocation;
    List<Double> latLong;
    LocationServices locationServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        locationServices = new LocationServices();
        storageLocationDao = new StorageLocationDao();
        storageLocation = new StorageLocation();


        String locIDString = req.getParameter("locationId");
        int locIdint = Integer.parseInt(locIDString);

        HttpSession session = req.getSession();
        storageLocation = storageLocationDao.getStorageLocation(locIdint);

        session.setAttribute("storageLoc", storageLocation);

        String latLongjson = new Gson().toJson(latLong);


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(latLongjson);

    }
}
