package com.satellite.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author wishwah
 * @date 12/14/20
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Long> ping() {
        return ResponseEntity.ok().body(System.currentTimeMillis());
    }
}