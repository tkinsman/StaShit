package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 10/20/16.
 */
public class StorageSpaceDaoTest {

    private final Logger testingLog = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    private StorageLocationDao storageLocationDao;
    private StorageSpaceDao storageSpaceDao;
    private DatabaseSetupDao databaseSetupDao;

    private StorageLocation storageLocation;
    private StorageLocation storageLocationTwo;
    private int storageLocId;
    private int storageLocIdTwo;

    private StorageSpace storageSpaceGet;
    private StorageSpace storageSpaceUpdate;
    private StorageSpace storageSpaceDelete;

    private int ssGetId;
    private int ssUpdateId;
    private int ssDeleteId;

    private String username = "userStoLoc";

    private List<StorageSpace> storageSpaces;


    @Before
    public void setup() {
        storageSpaceDao = new StorageSpaceDao();
        storageLocationDao = new StorageLocationDao();
        databaseSetupDao = new DatabaseSetupDao();

        databaseSetupDao.clearAllDataFromStorageSpace();
        databaseSetupDao.clearAllDataFromStorageLocation();

        storageLocation = new StorageLocation("TestLoc for SS testing", "Address Tesing 124", "Verona", "WI", "43932", "Test SS SL Loc", username);
        storageLocationTwo = new StorageLocation("TestLoc2 for SS testing", "Address  5124", "Madison", "WI", "43932", "Test SS SL Loc", username);

        storageLocId = storageLocationDao.addStorageLocation(storageLocation);
        storageLocIdTwo = storageLocationDao.addStorageLocation(storageLocationTwo);

        storageSpaceGet = new StorageSpace("SS Get Setup", "Setup for ss testing", "Basement", Boolean.TRUE, 4, storageLocId);
        storageSpaceUpdate = new StorageSpace("SS Update Setup", "Setup for ss testing", "Basement", Boolean.TRUE, 4, storageLocIdTwo);
        storageSpaceDelete = new StorageSpace("SS Delete Setup", "Setup for ss testing", "Basement", Boolean.TRUE, 4, storageLocId);

        ssGetId = storageSpaceDao.addStorageSpaceToLocation(storageSpaceGet);
        ssUpdateId = storageSpaceDao.addStorageSpaceToLocation(storageSpaceUpdate);
        ssDeleteId = storageSpaceDao.addStorageSpaceToLocation(storageSpaceDelete);

        storageLocation = storageLocationDao.getStorageLocation(storageLocId);

    }

    @After
    public void databaseCleanup() {

        databaseSetupDao.clearAllDataFromStorageLocation();
        databaseSetupDao.clearAllDataFromStorageSpace();
    }

    @Test
    public void getAllStorageSpacesforLocation() throws Exception {

        List<StorageSpace> storageSpaces = storageSpaceDao.getAllStorageSpacesforLocation(storageLocation);
        testingLog.info("The storageSpaces for location: " + storageSpaces);
        assertTrue("No storageSpaces added", storageSpaces.size() > 0);

    }


    @Test
    public void getOneStorageSpaceOfLoc() {
        StorageSpace storageSpace = storageSpaceDao.getStorageSpaceForLocationSpaceId(ssGetId);
        testingLog.info("The storage space by loc and ssid " + storageSpace);

        assertNotNull("The storage space by sl and ssid didn't work", storageSpace);
    }

    @Test
    public void addStorageSpaceTest() {
        // addition happens in the setup() function and this confirms
        assertNotNull("Storage space not added", ssGetId);

    }

    @Test
    public void updateStorageSpaceTest() {

        storageSpaceUpdate.setSsDescription("Updated the description");
        storageSpaceDao.updateStorageSpaceToLocation(storageSpaceUpdate);

        StorageSpace storageSpaceUpCheck = storageSpaceDao.getStorageSpaceForLocationSpaceId(ssUpdateId);
        String updatedDesc = storageSpaceUpCheck.getSsDescription();

        testingLog.info("The updated desc: " + updatedDesc);
        assertEquals("The update was not successful", "Updated the description", updatedDesc);

    }

    @Test
    public void deleteStorageSpaceTest() {

        int deletedSucInt = storageSpaceDao.deleteStorageSpaceFromLocation(ssDeleteId);
        assertEquals("There was an error with deleting the ss", 1, deletedSucInt);

    }

    @Test
    public void getStorageSpacesForUsername() {

        List<StorageSpace> storageSpaces = new ArrayList<StorageSpace>();

        storageSpaces = storageSpaceDao.getAllRelatedStorageSpacesForUser(username);

        log.info("The storage spaces for the user are: " + storageSpaces.get(0).getSsName());

        assertEquals("Failed to get storagespaces for username", 3, storageSpaces.size());

    }


}