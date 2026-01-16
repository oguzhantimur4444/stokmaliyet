package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inonu.stokmaliyet.Entity.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
}
