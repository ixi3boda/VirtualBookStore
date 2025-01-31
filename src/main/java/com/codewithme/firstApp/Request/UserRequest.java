package com.codewithme.firstApp.Request;

import com.codewithme.firstApp.Model.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class UserRequest {

    @JsonProperty("userId")
    private String userId;

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
