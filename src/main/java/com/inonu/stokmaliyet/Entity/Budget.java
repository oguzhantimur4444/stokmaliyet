package com.inonu.stokmaliyet.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Budget extends BaseEntity{

    private String budgetName;
    private Double budgetAmount; 
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "budget")
    private List<MaterialEntry> materialEntryList;

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Double budgetAmount) {
        this.budgetAmount = budgetAmount;
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


    public List<MaterialEntry> getMaterialEntryList() {
        return materialEntryList;
    }

    public void setMaterialEntryList(List<MaterialEntry> materialEntryList) {
        this.materialEntryList = materialEntryList;
    }
}