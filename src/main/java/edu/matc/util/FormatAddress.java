package edu.matc.util;

import com.google.gson.Gson;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.PendingResult;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.GeolocationResult;
import com.google.maps.model.LatLng;
import edu.matc.entity.MapStorageLocation;
import edu.matc.entity.StorageLocation;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by toddkinsman on 11/28/16.
 */
public class FormatAddress extends Thread {

    private final Logger log = Logger.getLogger(this.getClass());

    List<MapStorageLocation> mapStorageLocationList;
    GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyB9dsnXqaTcY_9tp28DsNgSZ355jmMi2R4");
    LatLng location;

    public LatLng createFormattedAddress(String address, String city, String state, String zip) {
        GeocodingResult[] results =  new GeocodingResult[0];
        log.info("The results before try: " + results.length);

        double lat;
        double longitude;

        // Synchronous
        try {


            results =  GeocodingApi.geocode(context, address + city + state + zip).await();
            location = results[0].geometry.location;
            log.info("A successful google request!" + location.lat);

        } catch (Exception e) {
            // Handle error
            log.info("Failed Google Geocode Request" + e);


        }

        location = results[0].geometry.location;

        log.info("Location: " + location);


        return location;

    }


    public List<MapStorageLocation> generateDicOfLocationCoords(List<StorageLocation> storageLocations) {

        mapStorageLocationList = new ArrayList<MapStorageLocation>();
        log.info("Storage Loc size: " + storageLocations.size());

        for(StorageLocation storageLocationObj : storageLocations) {

            MapStorageLocation mapLocation;

            log.info("The format address storage loc: " + storageLocationObj);

            String locName = storageLocationObj.getStoLocName();
            String locDesc = storageLocationObj.getStoLocDescription();
            String address = storageLocationObj.getStoLocAddress();
            String city = storageLocationObj.getCity();
            String state = storageLocationObj.getStoLocState();
            String zip = storageLocationObj.getStoLocZip();

            mapLocation = new MapStorageLocation(locName, locDesc, address, city, state, zip);

            log.info("Map location object" + mapLocation);

            mapStorageLocationList.add(mapLocation);
            log.info("The storageLocLat object: " + mapStorageLocationList);

        }

        System.out.println("printing the storage object: " + mapStorageLocationList);
        log.info("The loop is done: " + mapStorageLocationList);

        return mapStorageLocationList;

    }


}
