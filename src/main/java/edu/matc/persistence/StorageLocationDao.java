package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.Log;

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
        return storageLocations;

    }

    public StorageLocation getStorageLocation(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        StorageLocation storageLocation = (StorageLocation) session.get(StorageLocation.class, id);
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

    public void updateStorageLocation(StorageLocation storageLocation) {

        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.update(storageLocation);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            log.info("The runtime exception to update storage location: " + e);
        } finally {
            session.flush();
            session.close();
        }

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




}
