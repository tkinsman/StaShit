package edu.matc.persistence;

import org.apache.log4j.Logger;
import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 9/21/16.
 */
public class UserDaoTest {
    UserDao userDao;
    User userGet;
    User userDelete;
    int deleteId;
    private final Logger logDebug = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        userDao = new UserDao();
        userGet = new User("admin", "samUser", "SamFirst", "SamGet", "password", "addresstest", "madison", 3, LocalDate.now());
        userDelete = new User("admin", "samUser", "SamFirst", "DeleteName", "password", "addresstest", "madison", 3, LocalDate.now());

        userDao.addUser(userGet);
        userDao.addUser(userDelete);
    }

    @Test
    public void getAllUsers() throws Exception {
        List<edu.matc.entity.User> users = userDao.getAllUsers();
        assertTrue(users.size() > 0);
        log.info("this is the get all users test" + users);
    }
//    Testing for exceptions
//    @Test(expected = <expected exception>)

    @Test
    public void getUser() throws Exception {

        int userIdToGet = userGet.getUserid();
        System.out.println("User Id to get: " + userIdToGet);
        User oneUser = userDao.getUser(userIdToGet);

//        assertNotNull("user not null from get user", oneUser);

        log.info("The user gotten is: " + oneUser);

    }

    @Test
    public void addUser() throws Exception {
        User testUser = new User("admin", "samUser", "SamFirst", "SamLast", "password", "addresstest", "madison", 3, LocalDate.now());
        userDao.addUser(testUser);
    }

    @Test
    public void deleteUser() throws Exception {
        deleteId = userDelete.getUserid();
        userDao.deleteUser(deleteId);

        assertTrue("The deleteID is not correct", deleteId > 0);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user = userDao.getUser(userDao.getAllUsers().size() - 2);
        user.setCity("Toddsville");
        userDao.updateUser(user);
        assertEquals("The updated didn't work: ", "Toddsville", user.getCity());
    }

    @Test
    public void getUsersByLastName() throws Exception {
        List<User> users = new ArrayList<User>();
        users = (List<User>) userDao.getUsersByLastName("SamLast");
        assertNotNull("No user found by last name", users);

    }

}