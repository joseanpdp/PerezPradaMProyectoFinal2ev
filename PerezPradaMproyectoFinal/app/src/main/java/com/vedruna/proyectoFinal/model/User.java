package com.vedruna.proyectoFinal.model;

import java.util.List;

/**
 * Clase que representa a un usuario en el sistema.
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String description;
    private List<Publication> publications;

    /**
     * Constructor de la clase User.
     * @param id El identificador único del usuario.
     * @param username El nombre de usuario del usuario.
     * @param password La contraseña del usuario.
     * @param email El correo electrónico del usuario.
     * @param description La descripción del usuario.
     * @param publications La lista de publicaciones del usuario.
     */
    public User(Long id, String username, String password, String email, String description, List<Publication> publications) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.description = description;
        this.publications = publications;
    }

    /**
     * Obtiene el identificador único del usuario.
     * @return El identificador único del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     * @param id El identificador único del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario del usuario.
     * @return El nombre de usuario del usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario del usuario.
     * @param username El nombre de usuario del usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password La contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la descripción del usuario.
     * @return La descripción del usuario.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del usuario.
     * @param description La descripción del usuario.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene la lista de publicaciones del usuario.
     * @return La lista de publicaciones del usuario.
     */
    public List<Publication> getPublications() {
        return publications;
    }

    /**
     * Establece la lista de publicaciones del usuario.
     * @param publications La lista de publicaciones del usuario.
     */
    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    /**
     * Devuelve una representación en forma de cadena de caracteres del objeto User.
     * @return Una cadena que representa al objeto User, incluyendo su id, nombre de usuario,
     * contraseña, correo electrónico, descripción y lista de publicaciones.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", publications=" + publications +
                '}';
    }
}
