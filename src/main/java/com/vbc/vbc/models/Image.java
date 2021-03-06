package com.vbc.vbc.models;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, length = 255)
    private String filestackUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "card")
    private Card card;

    public Image() {
    }

    public Image(long id, String filestackUrl, User user, Card card) {
        this.id = id;
        this.filestackUrl = filestackUrl;
        this.user = user;
        this.card = card;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilestackUrl() {
        return filestackUrl;
    }

    public void setFilestackUrl(String filestackUrl) {
        this.filestackUrl = filestackUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
