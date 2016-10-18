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
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        //TODO return a user for the given id
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        //TODO add the user and return the id of the inserted user

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
            e.printStackTrace();
            log.info("The runtime exception: " + e);
        } finally {
            session.flush();
            session.close();
        }

        int id = user.getUserid();
        //TODO take out printline and replace with log
        System.out.println("user ID of added: " + id);
        return id;
    }

    /**
     * delete a user by id
     * @param id
     */
    public void deleteUser(int id) {
        // TODO delete the user with the given id
        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            sucInt = 1;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            log.info("The runtime exception to delete user: " + e);
        } finally {
            session.flush();
            session.close();
        }
    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(User user) {
        // TODO update the user
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
            e.printStackTrace();
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
        return criteria.list();

    }

}
