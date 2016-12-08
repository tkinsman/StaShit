package edu.matc.controller;

import com.google.gson.Gson;
import com.google.maps.model.LatLng;
import edu.matc.entity.StorageLocation;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.util.FormatAddress;

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
import java.util.logging.Logger;

/**
 * Created by toddkinsman on 12/2/16.
 */
@WebServlet(
        name = "viewlocation",
        urlPatterns = { "/viewlocation" }
)
public class ViewLocationDetails extends HttpServlet {

//    private final Logger log = Logger.getLogger(this.getClass());

    private StorageLocationDao storageLocationDao;
    FormatAddress formatAddress;
    List<StorageLocation> storageLocation2;
    StorageLocation storageLocation;
    LatLng latLong;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        storageLocationDao = new StorageLocationDao();
        storageLocation = new StorageLocation();
        formatAddress = new FormatAddress();

        String url = "/locationView.jsp";
        String locIDString = req.getParameter("locationId");
        int locIdint = Integer.parseInt(locIDString);

        HttpSession session = req.getSession();
        storageLocation = storageLocationDao.getStorageLocation(locIdint);

        latLong = formatAddress.createFormattedAddress(storageLocation.getStoLocAddress(), storageLocation.getCity(), storageLocation.getStoLocState(), storageLocation.getStoLocZip());

        session.setAttribute("storageLoc", storageLocation);
        session.setAttribute("latLong", latLong);

        String latLongjson = new Gson().toJson(latLong);


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(latLongjson);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);


    }
}
