package com.atomcars.repository;

import com.atomcars.entity.CompleteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<CompleteUser, Long> {
}
