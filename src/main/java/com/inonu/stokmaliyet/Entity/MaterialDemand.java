package com.inonu.stokmaliyet.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inonu.stokmaliyet.Enum.DemandStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MaterialDemand {
    private Double quantity; // talep edilen malzeme miktarı
    private String userName;

    private String companyName; // talep edilen firmanın adı
    private LocalDate requestDate; // talep tarihi



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // talep edilen ürün
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tender_id", nullable = true)
    private Tender tender;
    
    @ManyToOne
    @JoinColumn(name = "directProcurement_id", nullable = true)
    private DirectProcurement directProcurement; // Hangi Doğrudan teminden talep yapılıyor


    @Enumerated(EnumType.STRING)
    @Column(name = "tender_type")
    private TenderType tenderType;


    @Enumerated(EnumType.STRING)
    private DemandStatus status = DemandStatus.PENDING;

    private String rejectionReason;


    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public DemandStatus getStatus() {
        return status;
    }

    public void setStatus(DemandStatus status) {
        this.status = status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public Tender getTender() {
        return tender;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }

    public DirectProcurement getDirectProcurement() {
        return directProcurement;
    }

    public void setDirectProcurement(DirectProcurement directProcurement) {
        this.directProcurement = directProcurement;
    }

    public TenderType getTenderType() {
        return tenderType;
    }

    public void setTenderType(TenderType tenderType) {
        this.tenderType = tenderType;
    }
}
