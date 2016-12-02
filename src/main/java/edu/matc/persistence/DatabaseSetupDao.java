package edu.matc.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.matc.entity.*;
import edu.matc.entity.StorageSpace;
import edu.matc.entity.StorageLocation;

/**
 *
 *  This is the data access object for setting up the test database.
 *
 *  @author Todd Kinsman
 *  @since 10/18/16
 */
public class DatabaseSetupDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     *  Clears all data from the category table for clean testing
     */
    public void clearAllDataFromUserTable() {
        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {


            trns = session.beginTransaction();
            session.createQuery("DELETE FROM users").executeUpdate();
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("There was a runtime exception to clear users table: " + e);

        } finally {
            session.flush();
            session.close();
        }

    }

    /**
     *  clears all data from the affirmation table for clean testing
     */
    public void clearAllDataFromStorageLocation() {

        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.createQuery("DELETE FROM storage_location").executeUpdate();
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("There was a runtime exception to clear storage location table: " + e);

        } finally {
            session.flush();
            session.close();
        }

    }

    /**
     *  clears all data from the affirmation table for clean testing
     */
    public void clearAllDataFromStorageSpace() {

        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.createQuery("DELETE FROM storage_space").executeUpdate();
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("There was a runtime exception to clear affirmation table: " + e);

        } finally {
            session.flush();
            session.close();
        }

    }

    /**
     *  One function that calls functions to clear data from the category
     *  and affirmation tables
     */
    public void clearAllDatabaseTables() {

        clearAllDataFromStorageLocation();
        clearAllDataFromUserTable();
        clearAllDataFromStorageSpace();

    }

}
