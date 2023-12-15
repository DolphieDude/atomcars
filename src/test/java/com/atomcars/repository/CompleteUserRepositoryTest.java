package com.atomcars.repository;

import com.atomcars.UnitOfWork;
import com.atomcars.UnitOfWorkImpl;
import com.atomcars.entity.CompleteUser;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ComponentScan(basePackages = {"com.atomcars.repository"})
public class CompleteUserRepositoryTest {

    @Autowired
    private CompleteUserRepository userRepo;

    @Test
    public void testSaveUser() {
        CompleteUser user = new CompleteUser(101L, "Foo", "Bar");
        userRepo.save(user);

        CompleteUser savedUser = userRepo.findById(user.getId()).orElse(null);
        assertNotNull(savedUser);
        assertEquals(user, savedUser);
    }
}
