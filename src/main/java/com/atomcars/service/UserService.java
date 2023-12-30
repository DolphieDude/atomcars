package com.atomcars.service;

import com.atomcars.dto.UserDto;
import com.atomcars.entity.CompleteUser;
import com.atomcars.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void signup(UserDto userDto) {
        CompleteUser user = new CompleteUser(userDto.getName(), userDto.getEmail());
        // Additional user setup logic if needed
        userRepository.save(user);
        System.out.println("saved");
    }
}
