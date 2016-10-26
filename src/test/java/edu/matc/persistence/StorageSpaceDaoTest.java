package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import edu.matc.entity.StorageSpace;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 10/20/16.
 */
public class StorageSpaceDaoTest {

    StorageSpaceDao storageSpaceDao;
    StorageLocationDao storageLocationDao;
    StorageLocation storageLocation;
    StorageLocation storagelocationGet;
    StorageSpace storageSpaceSetup;
    StorageSpace storageSpaceSetup2;
    int storageLocId;
    List<StorageSpace> storageSpaceList;
    List<StorageSpace> storageSpaceListAll;

    @Before
    public void setup() {

        storageSpaceDao = new StorageSpaceDao();
        storageLocationDao = new StorageLocationDao();

        storageLocation = new StorageLocation("The storage location for the space", "355 Eagle ct", "Rolif", "IL", "63732", "ssTestLocation");
        storageLocId = storageLocationDao.addStorageLocation(storageLocation);

        System.out.println("This is the storeloc ID" + storageLocId);

        storageSpaceSetup = new StorageSpace("Todd Test Space", "The space to add desc", "The type basement", Boolean.TRUE, 3, storageLocId);
        storageSpaceSetup2 = new StorageSpace("Todd Test SpaceDelete", "The space to add desc", "The type basement", Boolean.TRUE, 3, storageLocId);

        storageSpaceDao.addStorageSpaceToLocation(storageSpaceSetup);
        storageSpaceList = new ArrayList<StorageSpace>();

    }

    @Test
    public void getAllStorageSpacesforLocation() throws Exception {

        storagelocationGet = storageLocationDao.getStorageLocation(storageLocId);
        storageSpaceList = storageSpaceDao.getAllStorageSpacesforLocation(storagelocationGet);
        System.out.println("This is the storage space list: " + storageSpaceList);
        System.out.println("This is the storage location list: " + storagelocationGet);

    }

    @Test
    public void getAllStorageSpaces() throws Exception {



    }

    @Test
    public void getOneStorageSpaceOfLoc() {


    }

}