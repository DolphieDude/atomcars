package com.atomcars.repository;

import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO document (file_data, user_id) VALUES (?1, ?2)")
    void insertDocument(byte[] fileData, Long userId);
}