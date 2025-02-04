package com.codewithme.firstApp.ModelTest;

import com.codewithme.firstApp.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        // Initialize the User object with values
        user = User.builder()
                .userId(1L)
                .userName("Test User")
                .userEmail("test@example.com")
                .userPassword("password123")
                .userRole("USER")
                .build();
    }

    @Test
    void testUserBuilder() {
        // Assert that all the fields match the expected values
        assertEquals(1L, user.getUserId());
        assertEquals("Test User", user.getUserName());
        assertEquals("test@example.com", user.getUserEmail());
        assertEquals("password123", user.getUserPassword());
        assertEquals("USER", user.getUserRole());
    }

    @Test
    void testUserConstructor() {
        // Create a new User object using the constructor
        User userWithConstructor = new User(2L, "Constructor User", "constructor@example.com", "securePassword", "ADMIN");

        // Assert that all the fields match the expected values
        assertEquals(2L, userWithConstructor.getUserId());
        assertEquals("Constructor User", userWithConstructor.getUserName());
        assertEquals("constructor@example.com", userWithConstructor.getUserEmail());
        assertEquals("securePassword", userWithConstructor.getUserPassword());
        assertEquals("ADMIN", userWithConstructor.getUserRole());
    }

    @Test
    void testSettersAndGetters() {
        // Use the setters and assert the values after they are set
        user.setUserId(3L);
        user.setUserName("Updated User");
        user.setUserEmail("updated@example.com");
        user.setUserPassword("newPassword");
        user.setUserRole("MODERATOR");

        // Assert that the updated values match
        assertEquals(3L, user.getUserId());
        assertEquals("Updated User", user.getUserName());
        assertEquals("updated@example.com", user.getUserEmail());
        assertEquals("newPassword", user.getUserPassword());
        assertEquals("MODERATOR", user.getUserRole());
    }
}
