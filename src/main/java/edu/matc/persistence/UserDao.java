package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toddkinsman on 9/21/16.
 */
public class UserDao {
    private final Logger logHibr = Logger.getLogger("hibernateLogger");
    private final Logger log = Logger.getLogger(this.getClass());


    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        session.close();
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {

        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("The runtime exception to add user: " + e);
        } finally {
            session.flush();
            session.close();
        }

        int id = user.getUserid();
        return id;
    }

    /**
     * delete a user by id
     * @param id
     */
    public int deleteUser(int id) {
        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            logHibr.trace("This is the id of user to delete: " + id);
            session.delete(user);
            session.getTransaction().commit();
            sucInt = 1;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            sucInt = 0;
            logHibr.trace("The runtime exception to delete user: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return sucInt;
    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(User user) {
        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("The runtime exception to update user: " + e);
        } finally {
            session.flush();
            session.close();
        }
    }

    /** Retrieve users by lastname
     *
     * @param lastName User's last name which is the search criteria
     * @return User
     */
    public List<User> getUsersByLastName(String lastName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("lastName", lastName));

        List<User> users = new ArrayList<>();
        users = criteria.list();

        session.close();

        return users;

    }

    /** Retrieve users by username
     *
     * @param userName User's last name which is the search criteria
     * @return User
     */
    public List<User> getUsersByUserName(String userName) {

        List<User> users = new ArrayList<User>();
        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            users = criteria.list();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("The runtime exception to update user: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return users;

    }

}
