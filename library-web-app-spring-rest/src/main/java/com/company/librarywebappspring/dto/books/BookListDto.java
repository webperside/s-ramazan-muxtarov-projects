package com.company.librarywebappspring.dto.books;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
public class BookListDto {

    // JSON -> Javascript
    // XML  ->
    private Integer id;
    private String name;
    private String author;
    private Float price;
}
