package com.atomcars.controller;

import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import com.atomcars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new CompleteUser());
        return "signup"; // Assuming you have a Thymeleaf template named "signup-form.html"
    }

    @PostMapping()
    public String signUp(CompleteUser user, @RequestParam("file") MultipartFile file) {
        // Convert the basic user to a complete user and save to the databas

        // ... (any additional logic for creating a complete user)

        // Save the complete user to the database
        Document document = new Document();
        try {
            document.setKey(document.getId());
            document.setUser(user);
            document.setFileData(file.getBytes()); // Adjust based on your file storage strategy
        } catch (IOException e) {
            throw new RuntimeException("I am here");
        }
        user.addDocument(document);


        userService.signUp(user);

        return "redirect:/login";
    }
}
