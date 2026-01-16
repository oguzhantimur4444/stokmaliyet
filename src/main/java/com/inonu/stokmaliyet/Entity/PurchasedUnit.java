package com.inonu.stokmaliyet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class PurchasedUnit extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "purchasedUnit")
    private List<MaterialEntry> materialEntry;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MaterialEntry> getMaterialEntry() {
        return materialEntry;
    }

    public void setMaterialEntry(List<MaterialEntry> materialEntry) {
        this.materialEntry = materialEntry;
    }
}