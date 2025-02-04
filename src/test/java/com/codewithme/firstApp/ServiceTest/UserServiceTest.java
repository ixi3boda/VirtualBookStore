package com.codewithme.firstApp.ServiceTest;


import com.codewithme.firstApp.Model.User;
import com.codewithme.firstApp.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deletingUserByUserIdShouldDeleteCorrectUser(){
        User testUser = new User();
        testUser.setUserId(1L);
        testUser.setUserName("hello");
        testUser.setUserEmail("hello@gmail.com");

        when(userService.deleteUserByUserId(1L)).thenReturn(testUser);

        User actualUser = userService.deleteUserByUserId(1L);

        assertNotNull(actualUser);
        assertEquals(testUser.getUserId(),actualUser.getUserId());
        assertEquals(testUser.getUserName(),actualUser.getUserName());
        assertEquals(testUser.getUserEmail(),actualUser.getUserEmail());

    }


}
