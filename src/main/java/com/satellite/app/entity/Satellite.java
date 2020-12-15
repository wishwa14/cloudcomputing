package com.satellite.app.entity;

import javax.persistence.*;

/**
 * @author wishwah
 * @date 12/14/20
 */
@Entity
@Table(name = "satellite")
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long satelliteId;
    private String satelliteName;
    private String satelliteCountry;

    public Long getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(Long satelliteId) {
        this.satelliteId = satelliteId;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }

    public String getSatelliteCountry() {
        return satelliteCountry;
    }

    public void setSatelliteCountry(String satelliteCountry) {
        this.satelliteCountry = satelliteCountry;
    }
}
