package com.company.librarywebappspring.dto.books;

import com.company.librarywebappspring.models.Book;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookByIdDto {

    private Integer id;
    private String name;
    private String description;
    private String author;
    private Float price;
    private Integer stockCount;

    public static BookByIdDto fromEntity(Book book) {
        return BookByIdDto.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .description(book.getDescription())
                .price(book.getPrice())
                .stockCount(book.getStockCount())
                .build();
    }

}
