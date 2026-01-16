package com.inonu.stokmaliyet.Entity;

import java.time.LocalDate;

import com.inonu.stokmaliyet.Enum.EntrySourceType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class MaterialEntry extends BaseEntity {
    private Double quantity;
    private Double remainingQuantity;
    private Double unitPrice; 
    private Double totalPrice;
    private LocalDate entryDate;
    private LocalDate expiryDate; 
    private String companyName;
    private Double totalPriceIncludingVat;
    private Double unitPriceIncludingVat;
    private String description; 

    @Enumerated(EnumType.STRING)
    private EntrySourceType entrySourceType;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Double remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getTotalPriceIncludingVat() {
        return totalPriceIncludingVat;
    }

    public void setTotalPriceIncludingVat(Double totalPriceIncludingVat) {
        this.totalPriceIncludingVat = totalPriceIncludingVat;
    }

    public Double getUnitPriceIncludingVat() {
        return unitPriceIncludingVat;
    }

    public void setUnitPriceIncludingVat(Double unitPriceIncludingVat) {
        this.unitPriceIncludingVat = unitPriceIncludingVat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntrySourceType getEntrySourceType() {
        return entrySourceType;
    }

    public void setEntrySourceType(EntrySourceType entrySourceType) {
        this.entrySourceType = entrySourceType;
    }
}
