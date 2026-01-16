package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inonu.stokmaliyet.Entity.PurchasedUnit;

public interface PurchasedUnitRepository extends JpaRepository<PurchasedUnit, Long> {
}
