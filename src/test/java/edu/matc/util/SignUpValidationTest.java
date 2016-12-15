package edu.matc.util;

import edu.matc.entity.User;
import edu.matc.persistence.DatabaseSetupDao;
import edu.matc.persistence.UserDao;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 12/14/16.
 */
public class SignUpValidationTest {

    SignUpValidation signUpValidation;
    UserDao userDao;
    DatabaseSetupDao databaseSetupDao;


    @Before
    public void setup() {
        userDao = new UserDao();
        signUpValidation = new SignUpValidation();
        User user = new User("admin", "same", "j", "j", "J", "j", "j", 0, LocalDate.now());
        userDao.addUser(user);

    }

    @After
    public void after() {
        databaseSetupDao = new DatabaseSetupDao();
        databaseSetupDao.clearAllDataFromUserTable();

    }
    @Test
    public void validateUserData() throws Exception {

        boolean validUser = signUpValidation.validateUserData("Name", "lastname", "address", "city", "state", "zip", "phone", "email", "true", true);

        assertTrue("User valid test failed", validUser);

    }

    @Test
    public void isUserNameUnique() throws Exception {

        String notUnique = "same";
        String unique = "different";
        boolean invalidName = signUpValidation.isUserNameUnique(notUnique);
        boolean validName = signUpValidation.isUserNameUnique(unique);

        assertFalse("Name was unique but tested for sameness", invalidName);
        assertTrue("Name was unique but tested for uniqueness", validName);


    }

    @Test
    public void validateNewSpaceTest() {
        boolean validSpace = signUpValidation.validateNewStorageSpace("name", "desc", "type", true, 0, 0);
        assertTrue("The space was not valid", validSpace);


    }

    @Test
    public void validateNewLocationTest() {
        boolean validLocation = signUpValidation.validateNewLocation("desc", "add", "city", "wi", "zip", "name", "name");

        assertTrue("Failed new location validate test", validLocation);
    }

}