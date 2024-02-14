package com.vedruna.proyectoFinal.dto;

public class PublicationPostDto {
    private long userId;
    private String text;
    private String creationDate;
    private String editionDate;

    public PublicationPostDto() {
    }

    public PublicationPostDto(long userId, String text, String creationDate, String editionDate) {
        this.userId = userId;
        this.text = text;
        this.creationDate = creationDate;
        this.editionDate = editionDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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
}
