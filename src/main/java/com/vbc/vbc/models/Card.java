package com.vbc.vbc.models;

import javax.persistence.*;


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

    @Column(length = 100, nullable = false, unique = true)
    private String email;

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


    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "userCard")
    private User user;

    public Card() {
    }

    public Card(long id, String title, String website, String phone, User user){
        this.id = id;
        this.title = title;
        this.website = website;
        this.phone = phone;
        this.user = user;
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
}
