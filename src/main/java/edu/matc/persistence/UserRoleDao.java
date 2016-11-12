package edu.matc.persistence;


import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by toddkinsman on 11/4/16.
 */
public class UserRoleDao {

    private final Logger logHibr = Logger.getLogger("hibernateLogger");

    /** Return a list of all user roles
     *
     * @return All user roles
     *
     */
    public List<UserRoles> getAllUsers() {
        List<UserRoles> userRoles = new ArrayList<UserRoles>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        userRoles = session.createCriteria(UserRoles.class).list();
        return userRoles;
    }

    public int addUserRole(UserRoles userRoles) {

        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.save(userRoles);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            logHibr.info("The runtime exception to add user role: " + e);
        } finally {
            session.flush();
            session.close();
        }

        int id = userRoles.getUserRoleId();

        return id;

    }

    public int deleteUserRole(UserRoles userRoles) {

        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.delete(userRoles);
            session.getTransaction().commit();
            sucInt = 1;

        } catch (RuntimeException e) {

            if (trns != null) {
                trns.rollback();

            }
            logHibr.info("The delete user role didn't work: "  + e);
            sucInt = 0;
        } finally {
            session.flush();
            session.close();
        }

        return sucInt;
    }


    public int deleteUserRoleById(int userRoleId) {

        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            UserRoles userRoles = (UserRoles) session.load(UserRoles.class, userRoleId);
            session.delete(userRoles);
            session.getTransaction().commit();
            sucInt = 1;

        } catch (RuntimeException e) {

            if (trns != null) {
                trns.rollback();

            }
            logHibr.info("The delete user role didn't work: "  + e);
            sucInt = 0;
        } finally {
            session.flush();
            session.close();
        }

        return sucInt;
    }

}
