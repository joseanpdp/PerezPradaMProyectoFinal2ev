package com.vedruna.proyectoFinal.model;

public class Publication {
    private Long id;

    // private User user;
    private String text;
    private String creationDate;
    private String editionDate;

    public Publication(Long id /*, User user*/, String text, String creationDate, String editionDate) {
        this.id = id;
        // this.user = user;
        this.text = text;
        this.creationDate = creationDate;
        this.editionDate = editionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                // ", user=" + user +
                ", text='" + text + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", editionDate='" + editionDate + '\'' +
                '}';
    }
}

