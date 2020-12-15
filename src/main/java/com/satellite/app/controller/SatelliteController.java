package com.satellite.app.controller;

import com.satellite.app.entity.Satellite;
import com.satellite.app.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author wishwah
 * @date 12/14/20
 */
@RestController
public class SatelliteController {

    @Autowired
    private SatelliteRepository satelliteRepository;

    @PostMapping("/addUser")
    public String saveUser(@RequestBody Satellite emp) {
        satelliteRepository.save(emp);
        return "User added successfully::"+emp.getSatelliteId();

    }

    @GetMapping("/users")
    public List<Satellite> getUsers() {
        return satelliteRepository.findAll();
    }

    @GetMapping("/findUser/{id}")
    public Optional<Satellite> getUser(@PathVariable Long id) {
        return satelliteRepository.findById(id);
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        satelliteRepository.deleteById(id);
        return "Deleted User Successfully::"+id;
    }
}
