package edu.matc.persistence;

import org.apache.log4j.Logger;
import edu.matc.entity.User;
import org.junit.After;
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
    DatabaseSetupDao databaseSetupDao;

    User userAdd;
    User userGet;
    User userDelete;
    User userUpdate;

    int deleteId;
    int updateId;
    int addId;
    int getUserId;


    private final Logger logDebug = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {

        userDao = new UserDao();
        databaseSetupDao = new DatabaseSetupDao();

        databaseSetupDao.clearAllDataFromUserTable();

        userGet = new User("admin", "getAUser", "johnFirst", "getlast", "password", "addresstest", "madison", 3, LocalDate.now());
        userDelete = new User("admin", "delUser", "SamFirst", "DeleteName", "password", "addresstest", "madison", 3, LocalDate.now());
        userAdd = new User("admin", "addUser", "jackFirst", "addName", "password", "addresstest", "madison", 3, LocalDate.now());
        userUpdate = new User("admin", "updateUser", "ulFirst", "updateNaem", "password", "addresstest", "madison", 3, LocalDate.now());

        updateId = userDao.addUser(userUpdate);
        deleteId = userDao.addUser(userDelete);
        addId = userDao.addUser(userAdd);
        getUserId = userDao.addUser(userGet);

    }

    @After
    public void cleanupTests() {
        databaseSetupDao.clearAllDataFromUserTable();
    }


    @Test
    public void getAllUsers() throws Exception {

        List<edu.matc.entity.User> users = userDao.getAllUsers();
        assertTrue(users.size() > 0);
        log.info("this is the get all users test" + users);

    }

    @Test
    public void getUser() throws Exception {

        User oneUser = userDao.getUser(updateId);
        String gottenName = oneUser.getFirstName();

        assertEquals("The get user test failed", "ulFirst", gottenName);

    }

    @Test
    public void addUser() throws Exception {

        User addedUser = new User();
        addedUser = userDao.getUser(addId);
        String addUserName = addedUser.getFirstName();

        assertEquals("The added user doesn't match test", "jackFirst", addUserName);

    }

    @Test
    public void deleteUser() throws Exception {

        int delConfirmation = userDao.deleteUser(deleteId);

        assertEquals("The deleteID is not correct", 1, delConfirmation);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user = userDao.getUser(updateId);
        user.setCity("Toddsville");
        userDao.updateUser(user);

        assertEquals("The updated didn't work", "Toddsville", user.getCity());
    }

    @Test
    public void getUsersByLastName() throws Exception {
        List<User> users = new ArrayList<User>();
        users = (List<User>) userDao.getUsersByLastName("SamLast");
        assertNotNull("No user found by last name", users);

    }

    @Test
    public void getUserByUserName() {

        List<User> users = new ArrayList<>();
        String userName = "getAUser";
        users = userDao.getUsersByUserName(userName);

        assertTrue("Failed to get user by username", users.size() == 1);
    }



}