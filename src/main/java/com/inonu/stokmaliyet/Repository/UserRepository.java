package com.inonu.stokmaliyet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inonu.stokmaliyet.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
