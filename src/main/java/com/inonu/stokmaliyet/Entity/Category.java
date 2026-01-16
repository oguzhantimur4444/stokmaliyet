package com.inonu.stokmaliyet.Entity;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Category {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
