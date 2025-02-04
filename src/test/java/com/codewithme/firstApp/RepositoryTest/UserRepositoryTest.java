package com.codewithme.firstApp.RepositoryTest;

import com.codewithme.firstApp.Model.User;
import com.codewithme.firstApp.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void findByUserIdShouldReturnCorrectUser(){
        User testUser = new User();
        testUser.setUserName("abooda");
        testUser.setUserEmail("abooda@gmail.com");
        testUser.setUserPassword("jgrg");
        testUser.setUserRole("ddv");

        userRepository.save(testUser);

        User actualUser = userRepository.findByUserId(testUser.getUserId());

        assertNotNull(actualUser);
        assertEquals(testUser.getUserId(),actualUser.getUserId());
        assertEquals(testUser.getUserName(),actualUser.getUserName());
        assertEquals(testUser.getUserEmail(),actualUser.getUserEmail());
    }

}
