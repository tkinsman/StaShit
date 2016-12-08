package edu.matc.util;

import com.google.maps.model.LatLng;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by toddkinsman on 12/2/16.
 */
public class FormatAddressTest {

    FormatAddress formatAddress;

    private String locName;
    private String desc;
    private String address;
    private String city;
    private String state;
    private String zip;

    private String locName1;
    private String desc1;
    private String address1;
    private String city1;
    private String state1;
    private String zip1;

    LatLng coords;
    LatLng coords1;

    private final Logger log = Logger.getLogger(this.getClass());
    @Before
    public void setup() {
        formatAddress = new FormatAddress();

        locName = "Map Obj Test";
        desc = "The object desc";
        address = "4754 Valor Way";
        city = "Madison";
        state = "WI";
        zip = "53718";

        locName1 = "Map Obj Test 2";
        desc1 = "The object desc";
        address1 = "S4563 County Road G";
        city1 = "La Valle";
        state1 = "WI";
        zip1 = "53941";
    }

    @Test
    public void geoCodeAddressTest() {

//        coords = formatAddress.createFormattedAddress(address, city, state, zip);
        coords1 = formatAddress.createFormattedAddress(address1, city1, state1, zip1);
//        log.info("The coords for the foramted address test: " + coords);
        log.info("The coords1 for the foramted address test: " + coords1);
    }



}