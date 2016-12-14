package edu.matc.controller;

import edu.matc.entity.UserRoles;
import edu.matc.persistence.SessionFactoryProvider;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserRoleDao;
import edu.matc.util.SignUpValidation;
import org.hibernate.Session;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.matc.entity.User;

/**
 * Created by toddkinsman on 10/23/16.
 */
@WebServlet(
        name = "adduser",
        urlPatterns = { "/adduser" }
)
public class AddUser extends HttpServlet {

    UserDao userDao = new UserDao();
    SignUpValidation signUpValidation = new SignUpValidation();

    /**
     *  Handles HTTP POST requests from signup form.
     *
     *@param  request               an httpServlet request
     *@param  response              an httpServlet response
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        UserRoleDao userRolesDao = new UserRoleDao();
        String url;

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zipcode");
        String phoneNumber = request.getParameter("phoneNumber");
        String emailAddress = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String userType = "registered-user";
        LocalDate today = LocalDate.now();
        boolean validData = true;
        boolean uniqueUsername = signUpValidation.isUserNameUnique(username);

        int userIdAdded = 0;

        validData = signUpValidation.validateUserData(username, firstName, lastName, address, city, state, zip, phoneNumber, emailAddress, validData);
        HttpSession session = request.getSession();


        /**
         *  Validate the new user information is valid otherwise outputs appropriate error message
         */
        if (validData && uniqueUsername) {

            User user = new User(userType, username, firstName, lastName, password, address, city, 0, today);

            userIdAdded = userDao.addUser(user);
            UserRoles userRoles = new UserRoles(username, userType);
            userRolesDao.addUserRole(userRoles);


            session.setAttribute("newUser", user);
            session.setAttribute("addUserMessage", "Successfully added user");
            session.setAttribute("username", username);

            url = "/userHome.jsp";

        } else {

            session.setAttribute("formMessage", "Username not unique, try with different user name.");
            session.setAttribute("addUserMessage", "Did not add user, try again");

            url = "/signUp.jsp";

        }



        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);




    }


}
