package edu.matc.controller;

import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by toddkinsman on 9/22/16.
 */
public class UserLoggedIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        UserDao userData = new UserDao();

        String searchTerm = req.getParameter("searchTerm");

        req.setAttribute("userone", userData.getUsersByLastName(searchTerm));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");


    }
}
