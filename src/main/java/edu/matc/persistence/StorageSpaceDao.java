package edu.matc.persistence;


import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toddkinsman on 10/18/16.
 */
public class StorageSpaceDao {

    private final Logger log = Logger.getLogger(this.getClass());
    private final Logger logHibr = Logger.getLogger("hibernateLogger");

    /**
     * Return list of storage spaces given a location
     *
     * @return All storage spaces for a location
     */
    public List<StorageSpace> getSpacesInTable() {

        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        storageSpaces = session.createCriteria(StorageSpace.class).list();

        return storageSpaces;

    }

//    /** Return list of storage spaces given a location
//     *
//     * @return All storage spaces for a location
//     *
//     */
//    public List<StorageSpace> getAllStorageSpacesforLocation(StorageLocation storageLocation) {
//
//        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        storageSpaces = (List <StorageSpace>) session.load(StorageSpace.class, storageLocation.getStorageLocId());
//
//        System.out.println("This is the storage spaces array: " + storageSpaces);
//
//        return storageSpaces;
//    }

    /**
     * Return list of storage spaces given a location
     *
     * @return All storage spaces for a location
     */
    public List<StorageSpace> getAllStorageSpacesforLocation(StorageLocation storageLocation) {

        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int storageLocId = storageLocation.getStorageLocId();
        storageSpaces = session.createSQLQuery("SELECT storage_space.storageSpaceId, storage_space.ssName, storage_space.ssType, storage_space.ssAvailability, storage_space.ssDescription, storage_space.ssRating, storage_space.storageLocationId FROM storage_space JOIN storage_location ON storage_space.storageLocationId = storage_location.storageLocationId WHERE storage_location.storageLocationId =" + storageLocId).addEntity(StorageSpace.class).list();

        //todo remove this sout
        System.out.println("this is the dao for ss: " + storageSpaces);
        return storageSpaces;

    }

    public StorageSpace getStorageSpaceForLocationSpaceId(StorageLocation storageLocation, int storageSpaceId) {

        StorageSpace storageSpace = new StorageSpace();

        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        int storageLocId = storageLocation.getStorageLocId();
//        storageSpace = session.createSQLQuery("SELECT storage_space.storageSpaceId, storage_space.ssName, storage_space.ssType, storage_space.ssAvailability, storage_space.ssDescription, storage_space.ssRating FROM storage_space JOIN storage_location ON storage_space.storageLocationId = storage_location.storageLocationId WHERE storage_location.storageLocationId =" + storageLocId + "AND storage_space.storageSpaceId=" + storageSpaceId).addEntity(StorageSpace.class);
        storageSpace = (StorageSpace) session.get(StorageSpace.class, storageSpaceId);

        return storageSpace;

    }

    public List<StorageSpace> getOneStorageSpaceOfLocation(StorageLocation storageLocation, int ssId) {

        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        int storageLocId = storageLocation.getStorageLocId();
        storageSpaces = session.createSQLQuery("SELECT storage_space.storageSpaceId, storage_space.ssName, storage_space.ssType, storage_space.ssAvailability, storage_space.ssDescription, storage_space.ssRating, storage_space.storageLocationId FROM storage_space JOIN storage_location ON storage_space.storageLocationId = storage_location.storageLocationId WHERE storage_location.storageLocationId =" + storageLocId + " AND storage_space.storageSpaceId =" + ssId).addEntity(StorageSpace.class).list();

        return storageSpaces;

    }

    public int addStorageSpaceToLocation(StorageSpace storageSpace) {


        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.save(storageSpace);
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

        int id = storageSpace.getStorageSpaceId();
        logHibr.trace("The id of the added storageSpace: " + id);
        return id;

    }

    public int updateStorageSpaceToLocation(StorageSpace storageSpace) {


        Transaction trns = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            session.update(storageSpace);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            log.info("The runtime exception of updated storage space: " + e);
        } finally {
            session.flush();
            session.close();
        }

        int id = storageSpace.getStorageSpaceId();
        logHibr.trace("The id of the added storageSpace: " + id);
        return id;

    }

    public void deleteStorageSpaceFromLocation(int ssId) {
        Transaction trns = null;
        int sucInt;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        try {
            trns = session.beginTransaction();
            StorageSpace storageSpace = (StorageSpace) session.load(StorageSpace.class, ssId);
            session.delete(storageSpace);
            session.getTransaction().commit();
            //todo figure out how to use sucInt
//            sucInt = 1
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            log.info("this is a delete exception for storage spaces: " + e);


        } finally {
            session.flush();
            session.close();
        }

    }


}
