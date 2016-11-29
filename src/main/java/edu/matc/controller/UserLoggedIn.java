package edu.matc.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import edu.matc.entity.StorageSpace;
import edu.matc.entity.User;
import edu.matc.persistence.StorageSpaceDao;
import edu.matc.persistence.UserDao;

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

    private List<StorageSpace> storageSpaces;
    private StorageSpaceDao storageSpaceDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);


        //Todo Remove this geocoding since have class to do this.
//        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyB9dsnXqaTcY_9tp28DsNgSZ355jmMi2R4");
//        GeocodingResult[] results = new GeocodingResult[0];
//        try {
//            results = GeocodingApi.geocode(context,
//                    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //todo remove this print
//        System.out.println(results[0].formattedAddress);


        HttpSession session = req.getSession();
        String sessionId = session.getId();

        String username = req.getRemoteUser();

        session.setAttribute("username", username);
        session.setAttribute("addUserMessage", "Successfully logged in");


//        //Todo get user location from user
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
