package com.vedruna.proyectoFinal.model;

/**
 * Clase que representa una publicación en el sistema.
 */
public class Publication {
    private Long id;
    // private User user;
    private String text;
    private String creationDate;
    private String editionDate;

    /**
     * Constructor de la clase Publication.
     * @param id El identificador único de la publicación.
     * @param text El texto de la publicación.
     * @param creationDate La fecha de creación de la publicación.
     * @param editionDate La fecha de edición de la publicación.
     */
    public Publication(Long id, String text, String creationDate, String editionDate) {
        this.id = id;
        // this.user = user;
        this.text = text;
        this.creationDate = creationDate;
        this.editionDate = editionDate;
    }

    /**
     * Obtiene el identificador único de la publicación.
     * @return El identificador único de la publicación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la publicación.
     * @param id El identificador único de la publicación.
     */
    public void setId(Long id) {
        this.id = id;
    }

    // Comentado por falta de uso en el código proporcionado
    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    */

    /**
     * Obtiene el texto de la publicación.
     * @return El texto de la publicación.
     */
    public String getText() {
        return text;
    }

    /**
     * Establece el texto de la publicación.
     * @param text El texto de la publicación.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Obtiene la fecha de creación de la publicación.
     * @return La fecha de creación de la publicación.
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Establece la fecha de creación de la publicación.
     * @param creationDate La fecha de creación de la publicación.
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Obtiene la fecha de edición de la publicación.
     * @return La fecha de edición de la publicación.
     */
    public String getEditionDate() {
        return editionDate;
    }

    /**
     * Establece la fecha de edición de la publicación.
     * @param editionDate La fecha de edición de la publicación.
     */
    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }

    /**
     * Devuelve una representación en forma de cadena de caracteres del objeto Publication.
     * @return Una cadena que representa al objeto Publication, incluyendo su id, texto,
     * fecha de creación y fecha de edición.
     */
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
