package com.codewithme.firstApp.Service;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@Builder
public class Book {

    private String bookId;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String bookDescription;
    private String bookCategory;
    private String bookReview;
    private double bookRating;

}
