package com.company.librarywebappspring.dto.books;

import lombok.Data;

import javax.persistence.Column;

@Data
public class BookCreateUpdateDto {

    private String name;
    private String description;
    private String author;
    private Float price;
    private Integer stockCount;
}
