package com.atomcars.controller;

import com.atomcars.dto.UserDto;
import com.atomcars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto userDto) {
        try {
            userService.signup(userDto);
            return new ResponseEntity<>("User signed up successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during signup: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
