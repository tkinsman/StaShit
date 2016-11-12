package edu.matc.controller;

import edu.matc.entity.UserRoles;
import edu.matc.persistence.SessionFactoryProvider;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserRoleDao;
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

import edu.matc.entity.User;

/**
 * Created by toddkinsman on 10/23/16.
 */
@WebServlet(
        name = "adduser",
        urlPatterns = { "/adduser" }
)
public class AddUser extends HttpServlet {


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
        UserDao userDao = new UserDao();
        UserRoleDao userRolesDao = new UserRoleDao();


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
        int userIdAdded = 0;

        validData = validateUserData(username, firstName, lastName, address, city, state, zip, phoneNumber, emailAddress, validData);
        HttpSession session = request.getSession();
        System.out.println("You're in addUser with valid data saying: " + validData);
        if (validData) {

            User user = new User(userType, username, firstName, lastName, password, address, city, 0, today);

            userIdAdded = userDao.addUser(user);
            UserRoles userRoles = new UserRoles(username, userType);
            userRolesDao.addUserRole(userRoles);


            session.setAttribute("newUser", user);
            session.setAttribute("addUserMessage", "Successfully added user");
            session.setAttribute("username", username);


        } else {


            session.setAttribute("addUserMessage", "Did not add user, try again");


        }

        String url = "/userHome.jsp";

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);




    }

    private boolean validateUserData(String username, String firstName, String lastName,
                                     String address, String city, String state,
                                     String zip, String phoneNumber, String email, Boolean validData) {

        if (firstName == null || firstName.isEmpty()) {

            System.out.println("First Name has malformed data.");
            validData = false;

        } else if (lastName == null || lastName.isEmpty()) {

            System.out.println("Last Name has malformed data.");
            validData = false;

        } else if (username == null || username.isEmpty()) {

            System.out.println("username has malformed data.");
            validData = false;

        } else if (address == null || address.isEmpty()) {

            System.out.println("address has malformed data.");
            validData = false;

        } else if (city == null || city.isEmpty()) {

            System.out.println("City has malformed data.");
            validData = false;

        } else if (state == null || state.isEmpty()) {

            System.out.println("State has malformed data.");
            validData = false;

        } else if (zip == null || zip.isEmpty()) {

        System.out.println("Zipcode has malformed data.");
        validData = false;

        } else if (phoneNumber == null || phoneNumber.isEmpty()) {

            System.out.println("Phone number has malformed data.");
            validData = false;

        } else if (email == null || email.isEmpty()) {

            System.out.println("Email address has malformed data.");
            validData = false;

        }

        return validData;

    }

}
