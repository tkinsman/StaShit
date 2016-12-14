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
 *
 * The format address class knows about the Google Maps Java client and aids in the geo coding of string address
 * that the user inputs
 *
 * Created by toddkinsman on 11/28/16.
 */
public class FormatAddress {

    private final Logger log = Logger.getLogger(this.getClass());

    List<MapStorageLocation> mapStorageLocationList;
    GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyB9dsnXqaTcY_9tp28DsNgSZ355jmMi2R4");
    LatLng location;

    /**
     * Creates a lat and long data point that is used to add map markers for google maps.
     *
     * @param address
     * @param city
     * @param state
     * @param zip
     * @return
     */
    public LatLng createFormattedAddress(String address, String city, String state, String zip) {
        GeocodingResult[] results =  new GeocodingResult[0];
        log.info("The results before try: " + results.length);

        double lat;
        double longitude;

        try {

            results =  GeocodingApi.geocode(context, address + city + state + zip).await();
            location = results[0].geometry.location;
            log.info("A successful google request!" + location.lat);

        } catch (Exception e) {

            log.info("Failed Google Geocode Request" + e);

        }

        location = results[0].geometry.location;
        log.info("Location: " + location);

        return location;

    }

}
