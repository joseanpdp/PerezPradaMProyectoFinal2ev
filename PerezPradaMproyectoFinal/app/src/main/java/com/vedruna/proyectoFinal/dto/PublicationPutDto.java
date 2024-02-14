package com.vedruna.proyectoFinal.dto;

public class PublicationPutDto {
    private Long   id;
    private Long   userId;
    private String text;
    private String creationDate;
    private String editionDate;

    public PublicationPutDto() {
    }

    public PublicationPutDto(Long id, Long userId, String text, String creationDate, String editionDate) {
        this.id = id;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
