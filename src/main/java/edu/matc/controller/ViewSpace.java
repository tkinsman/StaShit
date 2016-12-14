package edu.matc.controller;

import com.google.gson.Gson;
import com.google.maps.model.LatLng;
import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.persistence.StorageSpaceDao;
import edu.matc.util.FormatAddress;
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
 * Created by toddkinsman on 12/14/16.
 */
@WebServlet(
        name = "viewspace",
        urlPatterns = { "/viewspace" }
)
public class ViewSpace extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    private StorageSpaceDao storageSpaceDao;
    FormatAddress formatAddress;
    List<StorageLocation> storageLocation2;
    StorageSpace storageSpace;


    /**
     *  Handles HTTP GET to forward user to space details page
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        storageSpaceDao = new StorageSpaceDao();
        storageSpace = new StorageSpace();
        formatAddress = new FormatAddress();


        String url = "/storageSpaceView.jsp";
        String locIDString = req.getParameter("spaceId");
        int locIdint = Integer.parseInt(locIDString);

        HttpSession session = req.getSession();
        storageSpace = storageSpaceDao.getStorageSpaceForLocationSpaceId(locIdint);

        session.setAttribute("storageSpace", storageSpace);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);


    }
}
