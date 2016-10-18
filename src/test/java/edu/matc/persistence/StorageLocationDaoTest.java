package edu.matc.persistence;

import edu.matc.entity.StorageLocation;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 10/18/16.
 */
public class StorageLocationDaoTest {

    StorageLocationDao storageLocDao;

    private final Logger logDebug = Logger.getLogger("debugLogger");
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        storageLocDao = new StorageLocationDao();

    }


    @Test
    public void getAllStorageLocations() throws Exception {
        List<StorageLocation> storageLocations = storageLocDao.getAllStorageLocations();
//        assertTrue(storageLocations.size() > 0);
        log.info("this is the get all storage locs test" + storageLocations);
    }

}