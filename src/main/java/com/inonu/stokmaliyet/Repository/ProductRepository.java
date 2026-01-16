package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inonu.stokmaliyet.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
