package com.codewithme.firstApp.DTO;

import com.codewithme.firstApp.Model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class UserDTO {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userEmail")
    private String userEmail;

    @JsonProperty("userPassword")
    private String userPassword;

    @JsonProperty("userRole")
    private String userRole;

    @JsonProperty("userFavouriteBooks")
    private ArrayList<Book> userFavoriteBooks;

}
