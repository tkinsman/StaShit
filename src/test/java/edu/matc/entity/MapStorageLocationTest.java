package edu.matc.entity;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 12/5/16.
 */
public class MapStorageLocationTest {

    private final Logger log = Logger.getLogger(this.getClass());

    private String locName;
    private String desc;
    private String address;
    private String city;
    private String state;
    private String zip;
    private MapStorageLocation mapStorageLocationGlobal;


    @Before
    public void setup() {
        locName = "Map Obj Test";
        desc = "The object desc";
        address = "4754 Valor Way";
        city = "Madison";
        state = "WI";
        zip = "53718";

        mapStorageLocationGlobal = new MapStorageLocation(locName, desc, address, city, state, zip);

    }


    @Test
    public void createMapLocTest() {
        MapStorageLocation mapStorageLocation = new MapStorageLocation(locName, desc, address, city, state, zip);
        log.info("The map loc entity test obj: " + mapStorageLocation);

    }

    @Test
    public void verifyObjectLatCoords() {

        double lat = mapStorageLocationGlobal.getStoLocLatitude();
        log.info("The latitude for global: " + lat);

    }

    @Test
    public void verifyObjectLongCoords() {

        double longitude = mapStorageLocationGlobal.getStoLocLongitude();
        log.info("The latitude for global: " + longitude);

    }

}