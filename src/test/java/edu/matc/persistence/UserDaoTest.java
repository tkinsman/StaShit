package edu.matc.persistence;

import org.apache.log4j.Logger;
import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 9/21/16.
 */
public class UserDaoTest {
    UserDao userDao;
    private final Logger logDebug = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        userDao = new UserDao();
//        logDebug.debug("This is the before test");
    }

    @Test
    public void getAllUsers() throws Exception {
        List<edu.matc.entity.User> users = userDao.getAllUsers();
        assertTrue(users.size() > 0);
        log.info("this is the get all users test" + users);
    }

    @Test
    public void getUser() throws Exception {

    }

    @Test
    public void addUser() throws Exception {
        User testUser = new User("admin", "toddName", "password", "addresstest", "madison", 3, LocalDate.now());
        userDao.addUser(testUser);
    }

    @Test
    public void deleteUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void getUsersByLastName() throws Exception {

    }

}