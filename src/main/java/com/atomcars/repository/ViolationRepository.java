package com.atomcars.repository;

import com.atomcars.entity.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long> {
}