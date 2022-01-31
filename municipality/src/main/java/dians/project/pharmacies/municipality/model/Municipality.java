package dians.project.pharmacies.municipality.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double coordinatesLon;

    private double coordinatesLat;

    public Municipality(){}

    public Municipality(String name, double coordinatesLon, double coordinatesLat) {
        this.name = name;
        this.coordinatesLon = coordinatesLon;
        this.coordinatesLat = coordinatesLat;
    }
}
