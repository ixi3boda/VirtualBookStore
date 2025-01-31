package com.codewithme.firstApp.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class BookRequest {

    @JsonProperty("bookId")
    private String bookId;

    @JsonProperty("bookName")
    private String bookName;

    @JsonProperty("bookAuthor")
    private String bookAuthor;

    @JsonProperty("bookPrice")
    private double bookPrice;

    @JsonProperty("bookDescription")
    private String bookDescription;

    @JsonProperty("bookGenre")
    private String bookGenre;

    @JsonProperty("bookReview")
    private String bookReview;

    @JsonProperty("bookRating")
    private double bookRating;

    @JsonProperty("bookImage")
    private String bookImage;
}
