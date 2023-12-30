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
    public UserDto signup(UserDto userDto) {
        CompleteUser user = new CompleteUser(userDto.getName(), userDto.getEmail());
        // Additional user setup logic if needed
        userRepository.save(user);
        System.out.println("User saved with ID: " + user.getId());

        // Convert the CompleteUser to UserDto and return it
        return convertToDto(user);
    }

    private UserDto convertToDto(CompleteUser user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        // Add other fields as needed
        return userDto;
    }

}
