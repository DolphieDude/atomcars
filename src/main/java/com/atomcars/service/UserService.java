package com.atomcars.service;

import com.atomcars.entity.CompleteUser;
import com.atomcars.repository.CompleteUserRepository;
import com.atomcars.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final CompleteUserRepository userRepository;
    private final DocumentRepository documentRepository;

    public CompleteUser signUp(CompleteUser user) {
        // You might want to perform validation here before saving the user

        // Convert the basic user to a complete user and save to the database
        userRepository.save(user);  // Explicitly cast the result
        documentRepository.saveAll(user.getDocuments());

        return user;
    }
}
