package com.company.models;

public class Book { // JPA -> Entity

    private Integer id;
    private String name;
    private String description;
    private String author;
    private Float price;
    private Integer stockCount;

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
