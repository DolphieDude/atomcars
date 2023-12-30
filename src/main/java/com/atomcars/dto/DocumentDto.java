package com.atomcars.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DocumentDto {
    private MultipartFile file;
    private Long userId;

    public DocumentDto(MultipartFile file, Long userId) {
        this.userId = userId;
        this.file = file;
    }
}

