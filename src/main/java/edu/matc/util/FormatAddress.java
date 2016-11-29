package edu.matc.util;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

/**
 * Created by toddkinsman on 11/28/16.
 */
public class FormatAddress {



    public String createFormattedAddress() {

        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyB9dsnXqaTcY_9tp28DsNgSZ355jmMi2R4");
        GeocodingResult[] results = new GeocodingResult[0];

        try {
            results = GeocodingApi.geocode(context,
                    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String formattedAddress = results[0].formattedAddress;

        System.out.println("Print: " + results[0].geometry.location.lat);
        return formattedAddress;


    }


    public void createLatLong() {


    }


}
