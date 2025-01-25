package com.codewithme.firstApp.Model;

import com.codewithme.firstApp.Service.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("singleton")
public class UserDatabase {

   private final ArrayList <User> users = new ArrayList<>();

   public ArrayList <User> getUsers(){
       return users;
   }


}
