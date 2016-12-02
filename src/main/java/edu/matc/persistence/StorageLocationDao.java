package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.criterion.Restrictions;

import java.util.*;
import java.util.ArrayList;

/**
 * Created by toddkinsman on 10/18/16.
 */
public class StorageLocationDao {

    private final Logger log = Logger.getLogger(this.getClass());


    /**
     * @return All storageLocations
     */
    public List<StorageLocation> getAllStorageLocations() {
        List<StorageLocation> storageLocations = new ArrayList<StorageLocation>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        storageLocations = session.createCriteria(StorageLocation.class).list();
        session.close();
        return storageLocations;

    }

    public StorageLocation getStorageLocation(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        StorageLocation storageLocation = (StorageLocation) session.get(StorageLocation.class, id);
        session.close();
        return storageLocation;

    }

    public int addStorageLocation(StorageLocation storageLocation) {
        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.save(storageLocation);
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            //Todo Take this print out!
            e.printStackTrace();
            log.info("There was a runtime exception to add storage loc: " + e);

        } finally {
            session.flush();
            session.close();
        }

        int id = storageLocation.getStorageLocId();
        return id;
    }

    public int updateStorageLocation(StorageLocation storageLocation) {

        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.update(storageLocation);
            session.getTransaction().commit();
            sucInt = 1;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            sucInt = 0;
            e.printStackTrace();
            log.info("The runtime exception to update storage location: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return sucInt;

    }

    public int deleteStorageLocation(int id) {
        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            StorageLocation storageLocation = (StorageLocation) session.load(StorageLocation.class, id);
            session.delete(storageLocation);
            session.getTransaction().commit();
            sucInt = 1;
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            log.info("this is a delete exception: " + e);
            sucInt = 0;

        } finally {
            session.flush();
            session.close();
        }

        return sucInt;

    }

    public List<StorageLocation> getStorageLocationsByUserName(String username) {

        List<StorageLocation> storageLocations = new ArrayList<StorageLocation>();
        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            Criteria criteria = session.createCriteria(StorageLocation.class);
            criteria.add(Restrictions.eq("userName", username));
            storageLocations = criteria.list();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            log.info("The runtime exception to storage location by user: " + e);
        } finally {
            session.flush();
            session.close();
        }

        return storageLocations;
    }

    public List getStorageLocationIdsForUser(String username) {

        List storageLocatIds = new ArrayList();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction trns = null;

        try {

            trns = session.beginTransaction();
            String hql = "SELECT storageLocId FROM storage_location sl WHERE sl.userName = :username";
            Query query = session.createQuery(hql);
            query.setString("username",username);
            storageLocatIds = query.list();
            session.getTransaction().commit();


        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            log.info("There was a runtime exception to get storageLocIds from username: " + e);

        } finally {
            session.flush();
            session.close();
        }

        return storageLocatIds;

    }


}
