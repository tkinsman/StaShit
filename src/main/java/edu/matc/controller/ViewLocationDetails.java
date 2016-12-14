package edu.matc.controller;

import com.google.gson.Gson;
import com.google.maps.model.LatLng;
import edu.matc.entity.StorageLocation;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.util.FormatAddress;
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
 * Servlet to direct user to full view of location
 * Created by toddkinsman on 12/2/16.
 */
@WebServlet(
        name = "viewlocation",
        urlPatterns = { "/viewlocation" }
)
public class ViewLocationDetails extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    private StorageLocationDao storageLocationDao;
    FormatAddress formatAddress;
    List<StorageLocation> storageLocation2;
    StorageLocation storageLocation;
    LatLng latLong;
    List<Double> location;

    /**
     *  Handles HTTP GET to forward user to locaitons details page
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        storageLocationDao = new StorageLocationDao();
        storageLocation = new StorageLocation();
        formatAddress = new FormatAddress();
        location = new ArrayList<>();

        String url = "/locationView.jsp";
        String locIDString = req.getParameter("locationId");
        int locIdint = Integer.parseInt(locIDString);

        HttpSession session = req.getSession();
        storageLocation = storageLocationDao.getStorageLocation(locIdint);

        latLong = formatAddress.createFormattedAddress(storageLocation.getStoLocAddress(), storageLocation.getCity(), storageLocation.getStoLocState(), storageLocation.getStoLocZip());

        session.setAttribute("storageLoc", storageLocation);


        String latLongjson = new Gson().toJson(latLong);

        log.info("The object with latLong" + latLongjson);

        location.add(latLong.lat);
        location.add(latLong.lng);

        log.info("The object with location" + location.size());
        session.setAttribute("lat", latLong.lat);
        session.setAttribute("longit", latLong.lng);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);


    }
}
