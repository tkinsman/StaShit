package edu.matc.entity;

import edu.matc.persistence.StorageLocationDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 10/19/16.
 */
public class StorageLocationTest {

    private final Logger testLog = Logger.getLogger("debugLogger");
    private StorageLocationDao storageLocationDao;
    private StorageLocation storageLocationById;
    private StorageLocation storageLocationUpdate;
    private StorageLocation storageLocationDelete;
    int storageLocUpdateId;
    int storageLocGetId;
    int storageLocDeleteId;

    @Before
    public void setup() {
        storageLocationDao = new StorageLocationDao();
        storageLocationById = new StorageLocation("Getting one location test", "1234 get one", "Madison", "WI", "45330", "Get One SL", "toddName");
        storageLocGetId = storageLocationDao.addStorageLocation(storageLocationById);
        storageLocationUpdate = new StorageLocation("Update location test", "1234 update one", "Madison", "WI", "45330", "Update SL", "toddName");
        storageLocUpdateId = storageLocationDao.addStorageLocation(storageLocationUpdate);
        storageLocationDelete = new StorageLocation("Delete location test", "1234 delete one", "Madison", "WI", "11111", "Delete SL", "toddName");
        storageLocDeleteId = storageLocationDao.addStorageLocation(storageLocationDelete);
    }


    @Test
    public void getAllStorageLocationsTest() {
        List<StorageLocation> storageLocations = storageLocationDao.getAllStorageLocations();
        testLog.info("All storage locations test results: " + storageLocations);
        assertNotNull("Did not get all storage locs", storageLocations);
    }

    @Test
    public void getOneStorageLocationTest() {
        StorageLocation storageLocation = storageLocationDao.getStorageLocation(storageLocGetId);
        testLog.info("The gotten storage loc by id tes: " + storageLocation);
        assertNotNull("Did not get one storage loc by id", storageLocation);
    }

    @Test
    public void addOneStorageLocationTest() {
        assertNotNull("Storage location not added", storageLocGetId);

    }

    @Test
    public void updateOneStorageLocationTest() {
        StorageLocation storageLocation = storageLocationDao.getStorageLocation(storageLocUpdateId);
        storageLocation.setCity("Lime Ridge");
        storageLocationDao.updateStorageLocation(storageLocation);

        String upadatedCity = storageLocationDao.getStorageLocation(storageLocUpdateId).getCity();

        assertEquals("The storage loc update did not work", "Lime Ridge", upadatedCity);
    }

    @Test
    public void deleteOneStorageLocationTest() {
        int sucInt = storageLocationDao.deleteStorageLocation(storageLocDeleteId);

        testLog.info("Storage location delete sucInt should be 1: " + sucInt);

        assertTrue("The storage loc delete test failed", sucInt == 1 );


    }


}