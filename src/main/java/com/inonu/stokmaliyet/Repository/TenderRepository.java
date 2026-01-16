package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inonu.stokmaliyet.Entity.Tender;

import java.util.List;

public interface TenderRepository extends JpaRepository<Tender, Long> {

    List<Tender> findTenderByActiveTrue();

}
