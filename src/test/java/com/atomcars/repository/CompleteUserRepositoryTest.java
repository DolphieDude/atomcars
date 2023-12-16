package com.atomcars.repository;

import com.atomcars.entity.Car;
import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import com.atomcars.entity.Violation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RepositoryTestConfig.class)
public class CompleteUserRepositoryTest {

    @MockBean
    private CompleteUserRepository completeUserRepository;

    @Test
    public void testSaveAndFindById() {
        CompleteUser user = new CompleteUser(101L, "Foo Bar", "foobar@mail.com");

        when(completeUserRepository.save(any(CompleteUser.class))).thenReturn(user);
        when(completeUserRepository.findById(eq(user.getId()))).thenReturn(Optional.of(user));

        CompleteUser savedUser = completeUserRepository.save(user);
        Optional<CompleteUser> foundUserOptional = completeUserRepository.findById(user.getId());

        verify(completeUserRepository).save(user);
        verify(completeUserRepository).findById(user.getId());

        assertEquals(user, savedUser);
        assertEquals(user, foundUserOptional.orElse(null));
    }

    @Test
    public void testFindByEmail() {
        String email = "foobar@mail.com";
        CompleteUser user = new CompleteUser(102L, "Foo Bar", email);

        when(completeUserRepository.findByEmail(eq(email))).thenReturn(user);

        CompleteUser foundUser = completeUserRepository.findByEmail(email);

        verify(completeUserRepository).findByEmail(email);

        assertEquals(user, foundUser);
    }

    @Test
    public void testFindByCurrentRideId() {
        CompleteUser user = new CompleteUser(101L, "Foo Bar", "foobar@mail.com");
        Long currentRideId = 123L;

        when(completeUserRepository.findByCurrentRideId(eq(currentRideId))).thenReturn(user);

        CompleteUser foundUser = completeUserRepository.findByCurrentRideId(currentRideId);

        verify(completeUserRepository).findByCurrentRideId(currentRideId);

        assertEquals(user, foundUser);
    }

    @Test
    public void testUpdateAllByCurrentRideId() {
        CompleteUser user = new CompleteUser(101L, "Foo Bar", "foobar@mail.com");
        Long currentRideId = 123L;

        when(completeUserRepository.updateAllByCurrentRideId(eq(currentRideId))).thenReturn(user);

        CompleteUser updatedUser = completeUserRepository.updateAllByCurrentRideId(currentRideId);

        verify(completeUserRepository).updateAllByCurrentRideId(currentRideId);

        assertEquals(user, updatedUser);
    }

    @Test
    public void testFindByDocumentsContaining() {
        Document document = new Document(111L);

        CompleteUser user1 = new CompleteUser(101L, "Foo Bar", "foobar@mail.com");
        user1.addDocument(document);

        CompleteUser user2 = new CompleteUser(202L, "BarFoo", "barfoo@com.mail");

        List<CompleteUser> expectedUsers = List.of(user1);

        when(completeUserRepository.findByDocumentsContaining(eq(document))).thenReturn(expectedUsers);

        List<CompleteUser> foundUsers = completeUserRepository.findByDocumentsContaining(document);

        verify(completeUserRepository).findByDocumentsContaining(document);

        assertEquals(expectedUsers, foundUsers);
    }

    @Test
    public void testFindByRideListIsNotNull() {
        CompleteUser user1 = new CompleteUser(101L, "Foo Bar", "foobar@mail.com");
        user1.startRide(new Car(), 0.0, 0.0);

        CompleteUser user2 = new CompleteUser(202L, "BarFoo", "barfoo@com.mail");

        List<CompleteUser> expectedUsers = List.of(user1);

        when(completeUserRepository.findByRideListIsNotNull()).thenReturn(expectedUsers);

        List<CompleteUser> foundUsers = completeUserRepository.findByRideListIsNotNull();

        verify(completeUserRepository).findByRideListIsNotNull();

        assertEquals(expectedUsers, foundUsers);
    }

    @Test
    public void testFindByViolationListIsNotEmpty() {
        Violation violation = new Violation("speeding");

        CompleteUser user1 = new CompleteUser(101L, "Foo Bar", "foobar@mail.com");
        user1.addViolation(violation);

        CompleteUser user2 = new CompleteUser(202L, "BarFoo", "barfoo@com.mail");

        List<CompleteUser> expectedUsers = List.of(user1);

        when(completeUserRepository.findByViolationListIsNotEmpty()).thenReturn(expectedUsers);

        List<CompleteUser> foundUsers = completeUserRepository.findByViolationListIsNotEmpty();

        verify(completeUserRepository).findByViolationListIsNotEmpty();

        assertEquals(expectedUsers, foundUsers);
    }
}
