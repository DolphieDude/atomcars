package com.atomcars.service;

import com.atomcars.dto.DocumentDto;
import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import com.atomcars.repository.DocumentRepository;
import com.atomcars.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public void uploadDocument(DocumentDto documentDto) {
        try {
            Long userId = documentDto.getUserId();
            MultipartFile file = documentDto.getFile();

            CompleteUser user = userRepository.findById(userId).orElse(null);

            Document document = new Document();
            byte[] fileData = file.getBytes();

            document.setFileData(fileData);
            document.setUser(user);

            documentRepository.insertDocument(fileData, userId);

            System.out.println("Document uploaded successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Error during document upload: " + e.getMessage());
        }
    }
}


