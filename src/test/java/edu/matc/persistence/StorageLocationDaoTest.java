package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 10/18/16.
 */
public class StorageLocationDaoTest {

    StorageLocationDao storageLocDao;
    StorageLocation storageLocation;
    StorageLocation setupStorageLoc;

    private final Logger logDebug = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        storageLocDao = new StorageLocationDao();
        setupStorageLoc = new StorageLocation("The desci", "The Address", "Madison City", "The WI", "53811", "Home Loc Test");
//        storageLocDao.addStorageLocation(setupStorageLoc);

    }


    @Test
    public void getAllStorageLocations() throws Exception {
        List<StorageLocation> storageLocations = storageLocDao.getAllStorageLocations();
//        assertTrue(storageLocations.size() > 0);
        log.info("this is the get all storage locs test" + storageLocations);
    }

//    @Test
//    public void getAllStorageSpace() {
//        storageLocDao.addStorageLocation(setupStorageLoc);
//        storageLocation = storageLocDao.getStorageLocation(0);
//
//        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();
//        storageSpaces = storageLocDao.getAllStorageSpacesforLocation(storageLocation);
//
//        //Todo take out print
//        System.out.println("This is the storage spaces array: " + storageSpaces);
//
//    }

    @Test
    public void testAddNewStorageLocation() {
        StorageLocation locToAdd = new StorageLocation("This is loc desc", "my adddy", "Madison", "WI", "53718", "HOME Store");
        storageLocDao.addStorageLocation(locToAdd);

        logDebug.info("This is the debug logger");
    }

}