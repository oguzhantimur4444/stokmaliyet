package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inonu.stokmaliyet.Entity.Refectory;

public interface RefectoryRepository extends JpaRepository<Refectory, Long> {
    Refectory findByName(String name);
}
