package com.satellite.app.beans;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wishwah
 * @date 12/16/20
 */
public class SatelliteHealth {

    private Date birthTime;
    private String satelliteInAirDays;
    private BigDecimal batteryHealth;

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public BigDecimal getBatteryHealth() {
        return batteryHealth;
    }

    public void setBatteryHealth(BigDecimal batteryHealth) {
        this.batteryHealth = batteryHealth;
    }

    public String getSatelliteInAirDays() {
        return satelliteInAirDays;
    }

    public void setSatelliteInAirDays(String satelliteInAirDays) {
        this.satelliteInAirDays = satelliteInAirDays;
    }
}
