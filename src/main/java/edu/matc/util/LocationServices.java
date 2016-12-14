package edu.matc.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.maps.model.LatLng;
import edu.matc.entity.MapStorageLocation;
import edu.matc.entity.StorageLocation;
import org.apache.log4j.Logger;

import javax.json.JsonObjectBuilder;
import java.util.*;

/**
 *
 * The Location services class convers the MapStorageLocation objects to a geoJson object for use in location creation on
 * the google maps.
 * Created by toddkinsman on 12/5/16.
 */
public class LocationServices {

    private final Logger log = Logger.getLogger(this.getClass());
    FormatAddress formataddress;


    private List<MapStorageLocation> mapStorageLocationList;

    /**
     * Creates teh List of MapStorageLocation objects for geoJson conversion
     *
     * @param storageLocationList
     * @return
     */
    public List<MapStorageLocation> convertStorageLocsToMapLocs(List<StorageLocation> storageLocationList) {
        LatLng location;
        mapStorageLocationList = new ArrayList<MapStorageLocation>();
        formataddress = new FormatAddress();
        MapStorageLocation mapStorageLocation;

        for (StorageLocation storageLoc : storageLocationList) {
            mapStorageLocation = new MapStorageLocation();
            log.info("Looping to convert map");



            log.info("Created MapStorLoc object empty construcotor");

            String locName = storageLoc.getStoLocName();
            String locDesc = storageLoc.getStoLocDescription();
            String address = storageLoc.getStoLocAddress();
            String city = storageLoc.getCity();
            String state = storageLoc.getStoLocState();
            String zip = storageLoc.getStoLocZip();

            log.info("The set locName is: " + locName);

            location = formataddress.createFormattedAddress(address, city, state, zip);
            log.info("The coords size for this is: " + location);

            if (location != null) {

                log.info("Coords not null in LocServices");

                double lat = location.lat;
                double longitude = location.lng;

                log.info("The lat is in sercies: " + lat);
                log.info("The long is in sercies: " + longitude);

                mapStorageLocation.setStoLocName(locName);
                mapStorageLocation.setStoLocDesc(locDesc);
                mapStorageLocation.setStoLocAddress(address);
                mapStorageLocation.setStoLocCity(city);
                mapStorageLocation.setStoLocState(state);
                mapStorageLocation.setStoLocZip(zip);
                mapStorageLocation.setStoLocLatitude(lat);
                mapStorageLocation.setStoLocLongitude(longitude);

                log.info("the map location is: " + mapStorageLocation);

                addMapLocation(mapStorageLocation);

                log.info("Map storage location list: " + mapStorageLocationList);
            }

        }

        log.info("The list size for mapLocs: " + mapStorageLocationList.size());
        return mapStorageLocationList;

    }

    /**
     * Creates the geoJson object for google maps
     *
     * @param mapStorageLocations
     * @return
     */
    public String createGeoJsonObject(List<MapStorageLocation> mapStorageLocations) {

        Gson gson = new Gson();
        Map<Object, Object> featureCollection = new HashMap<Object, Object>();
        featureCollection.put("type", "FeatureCollection");
        List<Object> features = new ArrayList<Object>();

        log.info("The size of the mapstorageloc: " + mapStorageLocations.size());

        for (MapStorageLocation storageLoc : mapStorageLocations) {

            if(storageLoc != null) {

                Map<Object, Object> geometry = new HashMap<Object, Object>();
                Map<Object, Object> properties = new HashMap<Object, Object>();
                Map<Object, Object> newFeature = new HashMap<Object, Object>();
                JsonArray JSONArrayCoord = new JsonArray();



                JsonElement lat;
                JsonElement lng;
                lat = gson.toJsonTree(storageLoc.getStoLocLatitude());
                lng = gson.toJsonTree(storageLoc.getStoLocLongitude());

                JSONArrayCoord.add(lat);
                JSONArrayCoord.add(lng);

                properties.put("name", storageLoc.getStoLocName());

                geometry.put("type", "Point");
                geometry.put("coordinates", JSONArrayCoord);

                newFeature.put("type", "Feature");
                newFeature.put("geometry", geometry);
                newFeature.put("properties", properties);

                features.add(newFeature);
            }
        }

        featureCollection.put("features", features);

        String jsonGeoObj = gson.toJson(featureCollection);
        log.info("The geo json object: " + jsonGeoObj);

        return jsonGeoObj;

    }


    /**
     * Helper method to add mapLocation to List of map locations
     * @param mapstorageLoc
     */
    private void addMapLocation(MapStorageLocation mapstorageLoc) {

        this.mapStorageLocationList.add(mapstorageLoc);

    }


}
