package com.atomcars.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DocumentUploadDto {
    private Long userId;
    private MultipartFile file;
    // Add other fields as needed

    // Constructors, getters, setters as required
}

