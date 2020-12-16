package com.satellite.app.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author wishwah
 * @date 12/14/20
 */
@Entity
@Table(name = "satellite")
public class Satellite {
    @Id
    private Long satelliteId;
    private String satelliteName;
    private String satelliteCountry;
    private Long birthUnixTime;
    private BigDecimal altitudeDistance;
    private BigDecimal inclinationDegree;
    private Long batteryLife;

    @ManyToOne
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;

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

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    public Long getBirthUnixTime() {
        return birthUnixTime;
    }

    public void setBirthUnixTime(Long birthUnixTime) {
        this.birthUnixTime = birthUnixTime;
    }

    public BigDecimal getAltitudeDistance() {
        return altitudeDistance;
    }

    public void setAltitudeDistance(BigDecimal altitudeDistance) {
        this.altitudeDistance = altitudeDistance;
    }

    public BigDecimal getInclinationDegree() {
        return inclinationDegree;
    }

    public void setInclinationDegree(BigDecimal inclinationDegree) {
        this.inclinationDegree = inclinationDegree;
    }

    public Long getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(Long batteryLife) {
        this.batteryLife = batteryLife;
    }
}
