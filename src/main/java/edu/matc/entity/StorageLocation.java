package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Tables;

import javax.persistence.*;

/**
 * Created by toddkinsman on 9/22/16.
 */


@Table
@Entity(name = "storage_location")
public class StorageLocation {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "storageLocationId")
    private int storageLocId;

    @Column(name = "locDescription")
    private String stoLocDescription;

    @Column(name = "locAddress")
    private String stoLocAddress;

    @Column(name = "locCity")
    private String city;

    @Column(name = "locState")
    private String stoLocState;

    @Column(name = "locZip")
    private String stoLocZip;

    @Column(name = "locName")
    private String stoLocName;

    @Column(name = "userName")
    private String userName;

    public StorageLocation() {
    }

    public StorageLocation(String stoLocDescription, String stoLocAddress, String city, String stoLocState, String stoLocZip, String stoLocName, String userName) {
        this.stoLocDescription = stoLocDescription;
        this.stoLocAddress = stoLocAddress;
        this.city = city;
        this.stoLocState = stoLocState;
        this.stoLocZip = stoLocZip;
        this.stoLocName = stoLocName;
        this.userName = userName;
    }

    public int getStorageLocId() {
        return storageLocId;
    }

    public void setStorageLocId(int storageLocId) {
        this.storageLocId = storageLocId;
    }

    public String getStoLocDescription() {
        return stoLocDescription;
    }

    public void setStoLocDescription(String stoLocDescription) {
        this.stoLocDescription = stoLocDescription;
    }

    public String getStoLocAddress() {
        return stoLocAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStoLocAddress(String stoLocAddress) {
        this.stoLocAddress = stoLocAddress;
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

    public String getStoLocName() {
        return stoLocName;
    }

    public void setStoLocName(String stoLocName) {
        this.stoLocName = stoLocName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
