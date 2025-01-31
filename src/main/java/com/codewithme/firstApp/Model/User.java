  package com.codewithme.firstApp.Model;

import com.codewithme.firstApp.Request.BookRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;

    @PrePersist
    public void generateId() {
        this.userId = java.util.UUID.randomUUID().toString();
    }

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userRole;

  //  @Column(length = 500)
  //  private ArrayList<Book> userFavoriteBooks;

}
