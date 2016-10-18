package edu.matc.controller;

import edu.matc.persistence.UserDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 * Created by toddkinsman on 10/5/16.
 */

@WebServlet (
        name = "allusers",
        urlPatterns = { "/allusers" }
)
public class DisplayAllUsers extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               an httpServlet request
     *@param  response              an httpServlet response
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/userTest.jsp";
        UserDao user = new UserDao();

        request.setAttribute("allusers", user.getAllUsers());

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);



    }


}
