package com.satellite.app.utils;

import com.satellite.app.beans.SatelliteHealth;
import com.satellite.app.entity.Satellite;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author wishwah
 * @date 12/16/20
 */
public class SatelliteUtil {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static SatelliteHealth calculateSatelliteHealth(Optional<Satellite> satelliteOptional) {
        SatelliteHealth satelliteHealth = new SatelliteHealth();

        Satellite satellite = satelliteOptional.get();
        Date birthTime = new java.util.Date((long) satellite.getBirthUnixTime());
        Long airTime = System.currentTimeMillis() - satellite.getBirthUnixTime();
        satelliteHealth.setBirthTime(birthTime);


        //To calculate the days difference between two dates
        int diffInDays = (int)( (System.currentTimeMillis() - satellite.getBirthUnixTime())
              / (1000 * 60 * 60 * 24) );

        satelliteHealth.setSatelliteInAirDays(String.valueOf(diffInDays).concat(" days"));

        float usedBattery = (((float)airTime/(float)satellite.getBatteryLife())*100);

        BigDecimal batteryHealth = new BigDecimal(usedBattery);

        BigDecimal qualityBatteryHealth = new BigDecimal(100);


        BigDecimal batteryPercentage = new BigDecimal(df2.format(qualityBatteryHealth.subtract(batteryHealth)));
        satelliteHealth.setBatteryHealth(batteryPercentage);

        return satelliteHealth;
    }
}
