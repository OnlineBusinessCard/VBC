package com.vbc.vbc.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "card_owner")
public class CardOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "LONGTEXT")
    private String bio;

    @Column
    private String phone;

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "cardOwner")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardOwner", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardOwner", fetch = FetchType.LAZY)
    private List<Lead> leads;

    public CardOwner() {
    }

    public CardOwner(long id, String bio, String phone, User user, List<Review> reviews, List<Lead> leads) {
        this.id = id;
        this.bio = bio;
        this.phone = phone;
        this.user = user;
        this.reviews = reviews;
        this.leads = leads;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }
}
