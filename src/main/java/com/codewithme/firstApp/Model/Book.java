package com.codewithme.firstApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String bookAuthor;

    @Column(nullable = false)
    private double bookPrice;

    @Column(length = 500)
    private String bookDescription;

    @Column(nullable = false)
    private String bookGenre;

    @Column(length = 1000)
    private String bookReview;

    @Column(nullable = false)
    private double bookRating;

    @Column(length = 1000)
    private String bookImage;

}

