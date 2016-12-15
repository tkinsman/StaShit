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
 * directs user to new signup
 * Created by toddkinsman on 11/2/16.
 */
@WebServlet(
        name = "signupnew",
        urlPatterns = { "/signupnew" }
)
public class SignUp extends HttpServlet {

    /**
     *  Handles the HTTP request to direct to a new user signup.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/signUp.jsp";

        HttpSession session = req.getSession();
        session.setAttribute("formMessage", "Sign Up User");

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);


    }
}
