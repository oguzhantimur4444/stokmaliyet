package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inonu.stokmaliyet.Entity.PurchaseType;

public interface PurchaseTypeRepository extends JpaRepository<PurchaseType, Long> {
}
