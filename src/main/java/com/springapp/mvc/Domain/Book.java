package com.springapp.mvc.Domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.Date;

/**
 * Created by админ on 29.02.2016.
 */

@XStreamAlias("book")
public class Book {

    @XStreamAlias("id")
    @XStreamAsAttribute
    private int id;

    @XStreamAlias("author")
    private String author;

    @XStreamAlias("title")
    private String title;

    @XStreamAlias("genre")
    private String genre;

    @XStreamAlias("price")
    private double price;

    @XStreamAlias("publish_date")
    private Date publishDate;

    @XStreamAlias("description")
    private String description;

    public Book(int id, String author, String title, String genre, double price, Date publishDate, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
    }

    public Book(String author, String title, String genre, double price, Date publishDate, String description) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publishDate = publishDate;
        this.description = description;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
