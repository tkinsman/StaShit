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
    StorageLocation addLoc;
    StorageLocation updateLoc;
    StorageLocation delLoc;
    StorageLocation getLoc;

    int updateId;
    int addId;
    int delId;
    int getId;

    DatabaseSetupDao databaseSetupDao;

    private final Logger logDebug = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        databaseSetupDao = new DatabaseSetupDao();
        databaseSetupDao.clearAllDataFromStorageLocation();

        storageLocDao = new StorageLocationDao();


        getLoc = new StorageLocation("The desc of get", "The Address", "Madison City", "The WI", "53811", "GetTest", "toddName");
        addLoc = new StorageLocation("The desc of add", "The Address", "Madison City", "The WI", "53811", "AddTest", "toddName");
        delLoc = new StorageLocation("The desc of del", "The Address", "Madison City", "The WI", "53811", "DelTest", "toddName");
        updateLoc = new StorageLocation("The desc of update", "The Address", "Madison City", "The WI", "53811", "UpdateTest", "toddName");

        addId = storageLocDao.addStorageLocation(addLoc);
        getId = storageLocDao.addStorageLocation(getLoc);
        updateId = storageLocDao.addStorageLocation(updateLoc);
        delId = storageLocDao.addStorageLocation(delLoc);

    }


    @Test
    public void getAllStorageLocations() throws Exception {

        List<StorageLocation> storageLocations = new ArrayList<StorageLocation>();
        storageLocations = storageLocDao.getAllStorageLocations();
        assertTrue("Did not get all storage locations for get all test", storageLocations.size() > 0);
    }

    @Test
    public void getOneStorageLocTest() {

        StorageLocation storageLocation = new StorageLocation();
        storageLocation = storageLocDao.getStorageLocation(getId);
        String gotName = storageLocation.getStoLocName();

        assertEquals("Get one storage location by id failed", "GetTest", gotName);
    }

    @Test
    public void addStorageLocTest() {

        assertNotNull("Add storage location failed",addId);

    }



    @Test
    public void updateStorageLocTest() {
        StorageLocation storageLocation = new StorageLocation();
        storageLocation = storageLocDao.getStorageLocation(updateId);
        String changeToTheName = "NowUpdatedTest";
        storageLocation.setStoLocName(changeToTheName);
        int sucInt = storageLocDao.updateStorageLocation(storageLocation);

        assertEquals("The update storage loc was not successful", 1, sucInt);
        logDebug.info("This is the debug logger");
    }

    @Test
    public void deleteLocationTest() {

        int sucInt = storageLocDao.deleteStorageLocation(delId);
        assertEquals("Failed to delete storage location test", 1, sucInt);
    }

}