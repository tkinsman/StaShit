package edu.matc.controller;

import edu.matc.entity.StorageSpace;
import edu.matc.persistence.StorageSpaceDao;

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
 * Created by toddkinsman on 11/29/16.
 */
@WebServlet(
        name = "storagespace",
        urlPatterns = { "/storagespace" }
)
public class DisplayStorageSpaces extends HttpServlet {

    // Todo move all this to the login controller

    private List<StorageSpace> storageSpaces;
    private StorageSpaceDao storageSpaceDao;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();


        storageSpaces = getStorageSpaces(278);
        session.setAttribute("storageSpaces", storageSpaces);


        String url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }

    public List<StorageSpace> getStorageSpaces(int userId) {

        storageSpaceDao = new StorageSpaceDao();
        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();

        //// TODO: 11/29/16 fixe the name of method
        storageSpaces = storageSpaceDao.getStorageSpacesForUserid(userId);

        return storageSpaces;

    }
}
