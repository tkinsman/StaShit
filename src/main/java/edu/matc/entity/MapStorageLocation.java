package edu.matc.entity;

import com.google.maps.model.LatLng;
import edu.matc.persistence.StorageLocationDao;
import edu.matc.util.FormatAddress;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toddkinsman on 12/4/16.
 */
public class MapStorageLocation {

    private String stoLocName;
    private String stoLocDesc;
    private String stoLocAddress;
    private String stoLocCity;
    private String stoLocState;
    private String stoLocZip;
    private double stoLocLatitude;
    private double stoLocLongitude;
    private LatLng coords;

    private final Logger log = Logger.getLogger(this.getClass());

    private FormatAddress formatAddress = new FormatAddress();

    public MapStorageLocation() {
    }

    public MapStorageLocation(String stoLocName, String stoLocDesc, String stoLocAddress, String stoLocCity, String stoLocState, String stoLocZip) {
        this.coords = formatAddress.createFormattedAddress(stoLocAddress, stoLocCity, stoLocState, stoLocZip);
        this.stoLocName = stoLocName;
        this.stoLocDesc = stoLocDesc;
        this.stoLocAddress = stoLocAddress;
        this.stoLocCity = stoLocCity;
        this.stoLocState = stoLocState;
        this.stoLocZip = stoLocZip;
        this.stoLocLatitude = (double) coords.lat;
        this.stoLocLongitude = (double) coords.lng;
        log.info("The Format Add lat constructor: " + this.stoLocLatitude);
        log.info("The coords costructor in MapStorageLoc: " + coords);

    }

    public String getStoLocName() {
        return stoLocName;
    }

    public void setStoLocName(String stoLocName) {
        this.stoLocName = stoLocName;
    }

    public String getStoLocDesc() {
        return stoLocDesc;
    }

    public void setStoLocDesc(String stoLocDesc) {
        this.stoLocDesc = stoLocDesc;
    }

    public String getStoLocAddress() {
        return stoLocAddress;
    }

    public void setStoLocAddress(String stoLocAddress) {
        this.stoLocAddress = stoLocAddress;
    }

    public String getStoLocCity() {
        return stoLocCity;
    }

    public void setStoLocCity(String stoLocCity) {
        this.stoLocCity = stoLocCity;
    }

    public String getStoLocState() {
        return stoLocState;
    }

    public void setStoLocState(String stoLocState) {
        this.stoLocState = stoLocState;
    }

    public String getStoLocZip() {
        return stoLocZip;
    }

    public void setStoLocZip(String stoLocZip) {
        this.stoLocZip = stoLocZip;
    }

    public double getStoLocLatitude() {
        return stoLocLatitude;
    }

    public void setStoLocLatitude(double stoLocLatitude) {
        this.stoLocLatitude = stoLocLatitude;
    }

    public double getStoLocLongitude() {
        return stoLocLongitude;
    }

    public void setStoLocLongitude(double stoLocLongitude) {
        this.stoLocLongitude = stoLocLongitude;
    }

}
