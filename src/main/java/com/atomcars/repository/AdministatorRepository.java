package com.atomcars.repository;

import com.atomcars.entity.Administator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministatorRepository extends JpaRepository<Administator, Long> {
}