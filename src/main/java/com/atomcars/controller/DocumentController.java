package com.atomcars.controller;

import com.atomcars.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload/{userId}")
    public ResponseEntity<String> uploadDocument(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
        try {
            documentService.uploadDocument(userId, file);
            return new ResponseEntity<>("Document uploaded successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during document upload: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

