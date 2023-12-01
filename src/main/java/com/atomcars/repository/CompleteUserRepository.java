package com.atomcars.repository;

import com.atomcars.entity.CompleteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteUserRepository extends JpaRepository<CompleteUser, Long> {
}