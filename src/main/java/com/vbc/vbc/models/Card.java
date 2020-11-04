package com.vbc.vbc.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50, unique = false)
    private String firstName;

    @Column(nullable = false, length = 50, unique = false)
    private String lastName;

//    @Column(length = 100, nullable = false, unique = true)
//    private String email;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
    private String company;

    @Column(nullable = false, length = 50)
    private String website;

    @Column
    private String phone;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false, length = 50)
    private String country;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card")
    private List<Image> images;

    public Card() {
    }

    public Card(long id, String title, String website, String phone, String firstName, String lastName, String company, String city, String state, String country, List<Image> images, User user){
        this.id = id;
        this.title = title;
        this.website = website;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.email = email;
        this.company = company;
        this.city = city;
        this.state = state;
        this.country = country;
//        this.cardOwner = cardOwner;
        this.images = images;
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    //    public CardOwner getCardOwner() {
//        return cardOwner;
//    }
//
//    public void setCardOwner(CardOwner cardOwner) {
//        this.cardOwner = cardOwner;
//    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
