package com.inonu.stokmaliyet.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class MeasurementType extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "measurementType")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
