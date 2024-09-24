package com.example.librarymanagement.librarymanagement.bookDTO;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor


public class BookDTO {
    private Long id;
    @NotBlank(message = "title is required")
    @Size(min = 5,max = 20,message = "name should be in the given limit")
    private String title;
    @NotBlank(message = "theme should be mentioned")
    private String theme;
    @NotBlank(message = "author is required")
    @Size(min = 6,max = 20,message = "author name should be in the given range")
    private String author;
    @Digits(integer = 10,fraction = 0,message = "should be valid number")
    private String isbn;
    @NotBlank(message = "rating is required")
@Digits(integer = 2,fraction = 1,message = "souuld be single digirt or out of 5")
@DecimalMax(value = "10")
    private Float rating;



    public BookDTO() {}

    public BookDTO(Long id, String title, String author, String isbn, Float rating,String theme) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.rating = rating;
        this.theme = theme;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
