package com.company.librarywebappspring.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "userBookList")
@Entity
@Table(name = "book")
public class Book { // JPA -> Entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock_count")
    private Integer stockCount;

    @OneToMany(mappedBy = "book")
    private List<UserBook> userBookList;

}
