package com.atomcars.controller;

import com.atomcars.dto.DocumentDto;
import com.atomcars.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument( @RequestParam("userId") Long userId, @RequestParam("file") MultipartFile file) {
        try {
            DocumentDto documentDto = new DocumentDto(file, userId);
            documentService.uploadDocument(documentDto);
            return new ResponseEntity<>("Document uploaded successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during document upload: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


