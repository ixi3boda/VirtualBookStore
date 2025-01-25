package com.codewithme.firstApp.Service;

import com.codewithme.firstApp.Model.UserDatabase;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

@Data
@Builder
public class User {

    private UUID userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userRole;
    private ArrayList <String> userCart;


}
