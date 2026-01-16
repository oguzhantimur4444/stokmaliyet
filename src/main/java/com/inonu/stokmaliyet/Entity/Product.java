package com.inonu.stokmaliyet.Entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Product extends BaseEntity{

    private String name; 
    private Double vatAmount;
    private Double criticalLevel;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "measurementType_id",nullable = false) 
    private MeasurementType measurementType;

    @OneToMany(mappedBy = "product")
    private List<MaterialEntry> materialEntry;

    @OneToMany(mappedBy = "product")
    private List<MaterialExit> materialExits;

    @OneToMany(mappedBy = "product")
    private List<MaterialDemand> materialDemands;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Double getCriticalLevel() {
        return criticalLevel;
    }

    public void setCriticalLevel(Double criticalLevel) {
        this.criticalLevel = criticalLevel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public List<MaterialEntry> getMaterialEntry() {
        return materialEntry;
    }

    public void setMaterialEntry(List<MaterialEntry> materialEntry) {
        this.materialEntry = materialEntry;
    }

    public List<MaterialExit> getMaterialExits() {
        return materialExits;
    }

    public void setMaterialExits(List<MaterialExit> materialExits) {
        this.materialExits = materialExits;
    }

    public List<MaterialDemand> getMaterialDemands() {
        return materialDemands;
    }

    public void setMaterialDemands(List<MaterialDemand> materialDemands) {
        this.materialDemands = materialDemands;
    }
}