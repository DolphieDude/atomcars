package com.atomcars.repository;

import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompleteUserRepository extends JpaRepository<CompleteUser, Long> {
    CompleteUser findByEmail(String email);

    CompleteUser findByName(String name);

    CompleteUser findByCurrentRideId(Long currentRideId);

    List<CompleteUser> findByDocumentsContaining(Document document);

    List<CompleteUser> findByRideListIsNotNull();

    List<CompleteUser> findByViolationListIsNotEmpty();
}