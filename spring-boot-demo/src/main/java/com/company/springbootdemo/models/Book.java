package com.company.springbootdemo.models;

import javax.persistence.*;
import java.util.List;

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

    public Book() {
    }

    public Book(Integer id, String name, String description, String author, Float price, Integer stockCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.price = price;
        this.stockCount = stockCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public List<UserBook> getUserBookList() {
        return userBookList;
    }

    public void setUserBookList(List<UserBook> userBookList) {
        this.userBookList = userBookList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                '}';
    }
}
