package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplMockitoTest {

    @Mock
    private UserRepositoryMock userRepositoryMock;

    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userServiceImpl = new UserServiceImpl(userRepositoryMock);
    }

    @Test
    void testAddUser() {
        User user = new User();
        user.setName("Test User");

        // On simule la méthode save() pour qu'elle retourne l'utilisateur créé
        when(userRepositoryMock.save(user)).thenReturn(user);

        User result = userServiceImpl.addUser(user);

        assertNotNull(result);
        assertEquals("Test User", result.getName());
        verify(userRepositoryMock).save(user); // Vérifie que save a été appelé
    }

    @Test
    void testUpdateUser() {
        // Implemente un test pour updateUser ici
    }

    @Test
    void testDeleteUser() {
        // Implemente un test pour deleteUser ici
    }

    @Test
    void testRetrieveUser() {
        // Implemente un test pour retrieveUser ici
    }
}
