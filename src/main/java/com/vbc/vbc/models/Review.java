package com.vbc.vbc.models;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length =50)
    private String title;

    @Column(nullable = true, columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;


    public Review() {
    }

    public Review(long id, String title, String content, double rating, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
