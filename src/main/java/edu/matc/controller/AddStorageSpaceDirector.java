package edu.matc.controller;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.User;
import edu.matc.persistence.StorageLocationDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toddkinsman on 11/30/16.
 */
public class AddStorageSpaceDirector extends HttpServlet {

    private String username;
    private StorageLocationDao storageLocationDao;
    private String url;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        List<StorageLocation> storageLocationList = new ArrayList<StorageLocation>();
        String username = req.getRemoteUser();
        storageLocationList = storageLocationDao.getStorageLocationsByUserName(username);

        HttpSession session = req.getSession();
        session.setAttribute("storageLocations", storageLocationList);

        url = "/addStorageSpace.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }
}
