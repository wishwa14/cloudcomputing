package com.satellite.app.repository;

import com.satellite.app.entity.Constellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstellationRepository extends JpaRepository<Constellation, Long> {
}