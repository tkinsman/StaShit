package edu.matc.controller;

import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by toddkinsman on 10/23/16.
 */
@WebServlet(
        name = "signup",
        urlPatterns = { "/signup" }
)
public class AddUser {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/userHome.jsp";
        UserDao user = new UserDao();

        request.setAttribute("newUserDetails", user.getAllUsers());

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);



    }
}
