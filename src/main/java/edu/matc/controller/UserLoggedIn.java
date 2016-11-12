package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        HttpSession session = req.getSession();
        String sessionId = session.getId();

        String username = req.getRemoteUser();

        System.out.println("User name: " + username);

        session.setAttribute("username", username);
        session.setAttribute("addUserMessage", "Successfully logged in");



        String url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);

        dispatcher.forward(req, resp);


    }
}
