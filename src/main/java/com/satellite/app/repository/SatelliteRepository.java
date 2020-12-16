package com.satellite.app.repository;

import com.satellite.app.entity.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    @Query(
          value = "SELECT * FROM satellite t where t.constellation_id = :id",
          nativeQuery=true
    )
    Optional<Satellite> findSatelliteByConsteliation(@Param("id") Long id);
}