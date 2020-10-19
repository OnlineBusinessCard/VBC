package com.vbc.vbc.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 50, unique = false)
    private String firstName;

    @Column(nullable = false, length = 50, unique = false)
    private String lastName;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private boolean isOwner;

//    @OneToOne
//    private Card card;

    @OneToOne
    private CardOwner cardOwner;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "author_review")
    private List<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "author_lead")
    private List<Lead> leads;

    public User() {
    }

    public User(long id, String username, String email, String firstName, String lastName, String password, Card card) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
//        this.card = card;
    }

    public User(User copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.username = copy.username;
        this.password = copy.password;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
//        this.card = copy.card;
    }

    public User(long id, String username, String firstName, String lastName, String email, String password, boolean isOwner, CardOwner cardOwner, List<Review> reviews, List<Lead> leads) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isOwner = isOwner;
        this.cardOwner = cardOwner;
        this.reviews = reviews;
        this.leads = leads;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Card getCard() {
//        return card;
//    }
//
//    public void setCard(Card card) {
//        this.card = card;
//    }

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }

    public CardOwner getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(CardOwner cardOwner) {
        this.cardOwner = cardOwner;
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
