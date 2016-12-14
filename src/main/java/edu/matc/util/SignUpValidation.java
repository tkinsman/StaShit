package edu.matc.util;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that knows about form validation for signup.
 * Created by toddkinsman on 12/1/16.
 */
public class SignUpValidation {

    private final Logger log = Logger.getLogger(this.getClass());
    UserDao userDao = new UserDao();

    /**
     * Validates user information and returns boolean for evaluation
     *
     * @param username
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param phoneNumber
     * @param email
     * @param validData
     * @return
     */
    public boolean validateUserData(String username, String firstName, String lastName,
                                     String address, String city, String state,
                                     String zip, String phoneNumber, String email, Boolean validData) {

        if (firstName == null || firstName.isEmpty()) {

            log.info("First Name has malformed data.");
            validData = false;

        } else if (lastName == null || lastName.isEmpty()) {

            log.info("Last Name has malformed data.");
            validData = false;

        } else if (username == null || username.isEmpty()) {

            log.info("username has malformed data.");
            validData = false;

        } else if (address == null || address.isEmpty()) {

            log.info("address has malformed data.");
            validData = false;

        } else if (city == null || city.isEmpty()) {

            log.info("City has malformed data.");
            validData = false;

        } else if (state == null || state.isEmpty()) {

            log.info("State has malformed data.");
            validData = false;

        } else if (zip == null || zip.isEmpty()) {

            log.info("Zipcode has malformed data.");
            validData = false;

        } else if (phoneNumber == null || phoneNumber.isEmpty()) {

            log.info("Phone number has malformed data.");
            validData = false;

        } else if (email == null || email.isEmpty()) {

            log.info("Email address has malformed data.");
            validData = false;

        }

        return validData;

    }


    /**
     * Makes sure user name is unique for user creation
     * @param userName
     * @return
     */
    public Boolean isUserNameUnique(String userName) {

        List<User> userList = new ArrayList<User>();
        userList = userDao.getUsersByUserName(userName);
        Boolean uniqueName;

        if (userList.size() > 0) {

            uniqueName = false;

        } else {

            uniqueName = true;
        }

        return uniqueName;
    }
}
