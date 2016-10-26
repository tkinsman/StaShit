package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by toddkinsman on 9/22/16.
 */

@Entity
@Table(name = "storage_space")
public class StorageSpace {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "storageSpaceId")
    private int storageSpaceId;

    @Column(name = "ssName")
    private String ssName;

    @Column(name = "ssDescription")
    private String ssDescription;

    @Column(name = "ssType")
    private String ssType;

    @Column(name = "ssAvailability")
    private Boolean ssAvailibility;

    @Column(name = "ssRating")
    private int ssRating;

    @Column(name = "storageLocationId")
    private int storageLocationId;

    public StorageSpace() {
    }


    public StorageSpace(String ssName, String ssDescription, String ssType, Boolean ssAvailibility, int ssRating, int storageLocationId) {
        this.ssName = ssName;
        this.ssDescription = ssDescription;
        this.ssType = ssType;
        this.ssAvailibility = ssAvailibility;
        this.ssRating = ssRating;
        this.storageLocationId = storageLocationId;

    }


    public int getStorageSpaceId() {
        return storageSpaceId;
    }

    public void setStorageSpaceId(int storageSpaceId) {
        this.storageSpaceId = storageSpaceId;
    }

    public String getSsName() {
        return ssName;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName;
    }

    public String getSsDescription() {
        return ssDescription;
    }

    public void setSsDescription(String ssDescription) {
        this.ssDescription = ssDescription;
    }

    public String getSsType() {
        return ssType;
    }

    public void setSsType(String ssType) {
        this.ssType = ssType;
    }

    public Boolean getSsAvailibility() {
        return ssAvailibility;
    }

    public void setSsAvailibility(Boolean ssAvailibility) {
        this.ssAvailibility = ssAvailibility;
    }

    public int getSsRating() {
        return ssRating;
    }

    public void setSsRating(int ssRating) {
        this.ssRating = ssRating;
    }

    public int getStorageLocationId() {
        return storageLocationId;
    }

    public void setStorageLocationId(int storageLocationId) {
        this.storageLocationId = storageLocationId;
    }
}
