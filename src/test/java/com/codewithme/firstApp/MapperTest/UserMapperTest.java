package com.codewithme.firstApp.MapperTest;


import com.codewithme.firstApp.DTO.UserDTO;
import com.codewithme.firstApp.Mapper.UserMapper;
import com.codewithme.firstApp.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {

    private UserDTO userDTO;
    private User user;

    @BeforeEach
    void setUp() {
        // Initialize the UserDTO object
        userDTO = UserDTO.builder()
                .userId(1L)
                .userEmail("test@example.com")
                .userName("Test User")
                .userPassword("password123")
                .userRole("USER")
                .build();

        // Initialize the User object with values to compare later
        user = User.builder()
                .userId(1L)
                .userEmail("test@example.com")
                .userName("Test User")
                .userPassword("password123")
                .userRole("USER")
                .build();
    }

    @Test
    void testMapUserDTOToUser() {
        // Call the method to map UserDTO to User
        User mappedUser = UserMapper.mapUserDTOToUser(userDTO);

        // Assert that all the fields match
        assertEquals(userDTO.getUserId(), mappedUser.getUserId());
        assertEquals(userDTO.getUserEmail(), mappedUser.getUserEmail());
        assertEquals(userDTO.getUserName(), mappedUser.getUserName());
        assertEquals(userDTO.getUserPassword(), mappedUser.getUserPassword());
        assertEquals(userDTO.getUserRole(), mappedUser.getUserRole());
    }

    @Test
    void testMapUserToUserDTO() {
        // Call the method to map User to UserDTO
        UserDTO mappedUserDTO = UserMapper.mapUserToUserDTO(user);

        // Assert that all the fields match
        assertEquals(user.getUserId(), mappedUserDTO.getUserId());
        assertEquals(user.getUserEmail(), mappedUserDTO.getUserEmail());
        assertEquals(user.getUserName(), mappedUserDTO.getUserName());
        assertEquals(user.getUserPassword(), mappedUserDTO.getUserPassword());
        assertEquals(user.getUserRole(), mappedUserDTO.getUserRole());
    }
}
