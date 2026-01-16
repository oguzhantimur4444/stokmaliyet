package com.inonu.stokmaliyet.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class DirectProcurement {
    private Double Quantity;
    private Double remainingQuantity;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double unitPrice;
    private String companyName;
    private Double totalAmount;
    private boolean active = true;
    private boolean increased = false;

    public boolean isIncreased() {
        return increased;
    }

    public void setIncreased(boolean increased) {
        this.increased = increased;
    }

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnore
    private Product product; 

    @ManyToOne
    @JoinColumn(name = "purchaseUnit_id")
    private PurchasedUnit purchasedUnit; 


    @ManyToOne
    @JoinColumn(name = "purchaseType_id")
    private PurchaseType purchaseType;

    @OneToMany(mappedBy = "directProcurement")
    private List<MaterialEntry> materialEntries;

    @Enumerated(EnumType.STRING)
    @Column(name = "tender_type")
    private TenderType tenderType;


    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }

    public Double getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Double remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchasedUnit getPurchasedUnit() {
        return purchasedUnit;
    }

    public void setPurchasedUnit(PurchasedUnit purchasedUnit) {
        this.purchasedUnit = purchasedUnit;
    }

    public PurchaseType getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(PurchaseType purchaseType) {
        this.purchaseType = purchaseType;
    }


    public List<MaterialEntry> getMaterialEntries() {
        return materialEntries;
    }

    public void setMaterialEntries(List<MaterialEntry> materialEntries) {
        this.materialEntries = materialEntries;
    }

    public TenderType getTenderType() {
        return tenderType;
    }

    public void setTenderType(TenderType tenderType) {
        this.tenderType = tenderType;
    }
}
