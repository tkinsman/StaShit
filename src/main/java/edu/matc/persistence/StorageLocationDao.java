package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import org.apache.log4j.Logger;
import org.hibernate.Session;

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



}
