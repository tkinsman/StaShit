package edu.matc.controller;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.persistence.StorageSpaceDao;
import edu.matc.persistence.UserRoleDao;
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
import java.util.List;

/**
 * Created by toddkinsman on 9/22/16.
 */

@WebServlet(
        name = "addspace",
        urlPatterns = { "/addspace" }
)
public class AddStorageSpace extends HttpServlet {

    StorageSpaceDao storageSpaceDao;
    List<StorageSpace> storageSpaceList;

    private final Logger log = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url;
        HttpSession session = req.getSession();
        storageSpaceDao = new StorageSpaceDao();

        //TOdo: add to validagtion class
        String ssName = req.getParameter("ssName");
        String ssDescription = req.getParameter("ssDescription");
        String ssType = req.getParameter("ssType");
        int storageLocId = Integer.parseInt(req.getParameter("storageLocId"));
        String username = req.getRemoteUser();


        StorageSpace storageSpace = new StorageSpace(ssName, ssDescription, ssType, Boolean.FALSE, 0, storageLocId);

        // TODO: 11/30/16 add validation to the form
        storageSpaceDao.addStorageSpaceToLocation(storageSpace);
        storageSpaceList = storageSpaceDao.getAllRelatedStorageSpacesForUser(username);

        session.setAttribute("storageSpaces", storageSpaceList);


        url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);



    }
}
