package edu.matc.controller;

import edu.matc.persistence.SessionFactoryProvider;
import edu.matc.persistence.UserDao;
import org.hibernate.Session;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by toddkinsman on 11/2/16.
 */
@WebServlet(
        name = "logout",
        urlPatterns = { "/logout" }
)
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        HttpSession session = req.getSession();

        session.invalidate();

        String url = "/index.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }
}
