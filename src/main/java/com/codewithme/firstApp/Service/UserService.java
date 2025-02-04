package com.codewithme.firstApp.Service;

import com.codewithme.firstApp.DTO.UserDTO;
import com.codewithme.firstApp.Mapper.UserMapper;
import com.codewithme.firstApp.Model.Book;
import com.codewithme.firstApp.Model.User;
import com.codewithme.firstApp.Repository.BookRepository;
import com.codewithme.firstApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    public User saveUser(UserDTO userDTO){
        User user = UserMapper.mapUserDTOToUser(userDTO);
        userRepository.save(user);
        return user;
    }

    public User deleteUserByUserId(Long userId){
        User user = userRepository.findByUserId(userId);
        if(user == null) return null;
        userRepository.delete(user);
        return user;
    }

 /*   @Autowired
    private CurrentUser currentUser;

    public boolean userSignup(String userEmail,String userPassword,String userName){
        for(User user:userRepository.findAll()){
            if(user.getUserEmail().equals(userEmail)){
                return false;
            }
        }
        ArrayList <Book> userFavoriteBooks = new ArrayList<>();
        User user = User.builder()
                .userEmail(userEmail)
                .userName(userName)
                .userPassword(userPassword)
                .userId("jngjrg")
                .userFavoriteBooks(userFavoriteBooks)
                .userRole("user")
                .build();
        userRepository.findAll().add(user);
        return true;
    }

    public boolean userLogin(String userEmail,String userPassword){
        for(User user:userRepository.findAll()){
            if(user.getUserEmail().equals(userEmail) && user.getUserPassword().equals(userPassword)){
                currentUser.setCurrentUser(user);
                return true;
            }
        }
        return false;
    } */

    

}
