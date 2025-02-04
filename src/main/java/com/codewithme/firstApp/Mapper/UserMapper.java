package com.codewithme.firstApp.Mapper;

import com.codewithme.firstApp.DTO.UserDTO;
import com.codewithme.firstApp.Model.User;
import lombok.Data;

@Data
public class UserMapper {

    public static User mapUserDTOToUser(UserDTO userDTO){
        User userr = User.builder()
                .userId(userDTO.getUserId())
                .userEmail(userDTO.getUserEmail())
                .userName(userDTO.getUserName())
                .userPassword(userDTO.getUserPassword())
                .userRole(userDTO.getUserRole())
                .build();
        return userr;
    }

    public static UserDTO mapUserToUserDTO(User user){
        UserDTO userDTO = UserDTO.builder()
                         .userId(user.getUserId())
                         .userEmail(user.getUserEmail())
                         .userName(user.getUserName())
                         .userPassword(user.getUserPassword())
                         .userRole(user.getUserRole())
                         .build();
        return userDTO;
    }
}
