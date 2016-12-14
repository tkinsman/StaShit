package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by toddkinsman on 12/2/16.
 */
@WebServlet(
        name = "editLocation",
        urlPatterns = { "/editLocation" }
)
public class EditLocation extends HttpServlet {

    /**
     *  Handles HTTP request to edit user, forwards to edit at add user form
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/addLocation.jsp";

        HttpSession session = req.getSession();
        session.setAttribute("formMessage", "Sign Up User");

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);


    }
}
