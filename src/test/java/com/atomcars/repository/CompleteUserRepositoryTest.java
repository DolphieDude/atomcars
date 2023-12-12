package com.atomcars.repository;

import com.atomcars.entity.CompleteUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompleteUserRepositoryTest {

    @MockBean
    CompleteUserRepository mockUserRepo;

    @Test
    public void shouldGetUserById() {
        Long id = 5L;
        CompleteUser expected = new CompleteUser(id, "name", "email");

        CompleteUser mockUser = new CompleteUser(id, "name", "email");

        mockUserRepo.save(mockUser);

        CompleteUser actual = mockUserRepo.findById(id).orElse(null);

        assertEquals(expected, actual);
    }
}
