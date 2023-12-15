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

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(classes = RepositoryTestConfig.class)
@DataJpaTest
@SpringBootTest(classes = RepositoryTestConfig.class)
public class CompleteUserRepositoryTest {

    @Autowired
    private CompleteUserRepository userRepo;

//    @Autowired
//    private EntityManager entityManager;
//    private UnitOfWork unitOfWork;

    @Test
    public void shouldGetUserById() {
//        this.unitOfWork = new UnitOfWorkImpl(entityManager);
        Long id = 5L;
        CompleteUser expected = new CompleteUser(id, "name", "email");

        CompleteUser mockUser = new CompleteUser(id, "name", "email");

//        this.unitOfWork.begin();
        userRepo.save(mockUser);

        CompleteUser actual = userRepo.findById(id).orElse(null);


//        mockUserRepo.save(mockUser);
//
//        CompleteUser actual = mockUserRepo.findById(id).orElse(null);

        assertEquals(expected, actual);
//        this.unitOfWork.dispose();
    }
}
