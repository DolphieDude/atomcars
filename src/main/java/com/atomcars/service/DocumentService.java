package com.atomcars.service;

import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import com.atomcars.repository.DocumentRepository;
import com.atomcars.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public void uploadDocument(Long userId, MultipartFile file) {
        CompleteUser user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        Document document = new Document();
        document.setUser(user);
        try {
            document.setFileData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        documentRepository.save(document);
    }
}
