package com.satellite.app.controller;

import com.satellite.app.entity.Constellation;
import com.satellite.app.repository.ConstellationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wishwah
 * @date 12/14/20
 */
@RestController
@RequestMapping("/constellation")
public class ConstellationController {

    @Autowired
    private ConstellationRepository constellationRepository;

    @PostMapping
    public String saveConstellation(@RequestBody Constellation constellation) {
        constellationRepository.save(constellation);
        return "Constellation added successfully: "+ constellation.getConstellationId();
    }

    @DeleteMapping("/{id}")
    public String deleteConstellation(@PathVariable Long id) {
        constellationRepository.deleteById(id);
        return "Deleted Constellation Successfully: "+ id;
    }
}