package com.atomcars.service;

import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testMakeUserPremium() {
        // Create a test user (you might need to mock or set up test data)
        User testUser = new CompleteUser();
        testUser.setName("TestUser");

        // Call the service method
        userService.makeUserPremium(testUser);

        // Perform assertions to check if the expected changes occurred
        assertEquals("PREMIUM TestUser", testUser.getName());
        // Add more assertions if needed
    }
}
