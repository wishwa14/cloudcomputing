package com.satellite.app.controller;

import com.satellite.app.beans.SatelliteHealth;
import com.satellite.app.entity.Constellation;
import com.satellite.app.entity.Satellite;
import com.satellite.app.repository.SatelliteRepository;
import com.satellite.app.utils.SatelliteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author wishwah
 * @date 12/14/20
 */
@RestController
@RequestMapping("/satellite")
public class SatelliteController {

    @Autowired
    private SatelliteRepository satelliteRepository;

    private SatelliteUtil satelliteUtil;

    @PostMapping("/constellation/{id}")
    public String saveSatellite(@PathVariable Long id, @RequestBody Satellite satellite) {
        Constellation constellation = new Constellation();
        constellation.setConstellationId(id);
        satellite.setConstellation(constellation);
        satelliteRepository.save(satellite);
        return "Satellite added successfully: "+ satellite.getSatelliteId();
    }

    @GetMapping("/getAll")
    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getSatelliteById(@PathVariable Long id) {

        Optional<Satellite> satelliteOptional = satelliteRepository.findById(id);

        if(satelliteOptional.get() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(satelliteOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSatellite(@PathVariable Long id) {
        satelliteRepository.deleteById(id);
        return ResponseEntity.ok("Deleted Satellite Successfully: "+ id);
    }

    @GetMapping("/constellation/{id}")
    public ResponseEntity getAllSatellitesByConstellationId(@PathVariable Long id) {

        Optional<Satellite> satelliteOptional = satelliteRepository.findSatelliteByConsteliation(id);

        if(satelliteOptional.get() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(satelliteOptional);
    }

    @GetMapping("/{id}/health")
    public ResponseEntity getSatelliteHealth(@PathVariable Long id) {
        Optional<Satellite> satelliteOptional = satelliteRepository.findById(id);

        if(satelliteOptional.get() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(satelliteUtil.calculateSatelliteHealth(satelliteOptional));
    }
}
