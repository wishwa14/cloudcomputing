package com.satellite.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wishwah
 * @date 12/16/20
 */
@Entity
@Table(name = "constellation")
public class Constellation {
    @Id
    @Column(name="constellation_id")
    private Long constellationId;
    private String constellationName;

    public Long getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(Long constellationId) {
        this.constellationId = constellationId;
    }

    public String getConstellationName() {
        return constellationName;
    }

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }
}
