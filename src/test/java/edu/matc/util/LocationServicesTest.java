package edu.matc.util;

import edu.matc.entity.MapStorageLocation;
import edu.matc.entity.StorageLocation;
import edu.matc.persistence.DatabaseSetupDao;
import edu.matc.persistence.StorageLocationDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 12/5/16.
 */
public class LocationServicesTest {

    private final Logger log = Logger.getLogger(this.getClass());

    DatabaseSetupDao setupDao;
    List<StorageLocation> storageLocationList;
    StorageLocation storageLocation1;
    StorageLocation storageLocation2;
    StorageLocationDao storageLocationDao;
    LocationServices locationServices;

    @Before
    public void setup() {
        storageLocationDao = new StorageLocationDao();
        setupDao = new DatabaseSetupDao();

        setupDao.clearAllDataFromStorageLocation();
        locationServices = new LocationServices();

        storageLocation1 = new StorageLocation("Test desc 1", "4754 Valor Way", "Madison", "WI", "53718", "Test Loc", "testService");
        storageLocation2 = new StorageLocation("Test desc 2", "S4563 County Road G", "La valle", "WI", "53941", "Test Loc 2", "testService");

        storageLocationDao.addStorageLocation(storageLocation1);
        storageLocationDao.addStorageLocation(storageLocation2);




    }

    @Test
    public void convertStorageLocsToMapLocs() throws Exception {
        storageLocationList = new ArrayList<>();
        storageLocationList = storageLocationDao.getStorageLocationsByUserName("testService");
        List<MapStorageLocation> mapStorageLocations;
        String json;

        log.info("The locations for sercie test" + storageLocationList);

        mapStorageLocations = locationServices.convertStorageLocsToMapLocs(storageLocationList);
        json = locationServices.createGeoJsonObject(mapStorageLocations);

        log.info("The string json obj" + json);
    }

    @Test
    public void geoJsonCreationTest() {



    }

}