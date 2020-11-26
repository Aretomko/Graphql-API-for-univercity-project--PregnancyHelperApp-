package com.example.demo.domen;

import javax.persistence.*;

@Entity
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Advice(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Advice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
