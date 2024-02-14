package com.vedruna.proyectoFinal.interfaces;

import com.vedruna.proyectoFinal.dto.PublicationPostDto;
import com.vedruna.proyectoFinal.dto.PublicationPutDto;
import com.vedruna.proyectoFinal.model.Publication;
import com.vedruna.proyectoFinal.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para las publicaciones y usuarios en el sistema.
 */
public interface CRUDInterface {
    /**
     * Obtiene todas las publicaciones existentes en el sistema.
     * @return Una llamada que devuelve una lista de publicaciones.
     */
    @GET("api/publication")
    Call<List<Publication>> getAllPublications();

    /**
     * Obtiene todos los usuarios registrados en el sistema.
     * @return Una llamada que devuelve una lista de usuarios.
     */
    @GET("api/user")
    Call<List<User>> getAllUsers();

    /**
     * Crea una nueva publicación en el sistema.
     * @param publication La publicación a ser creada.
     * @return Una llamada que devuelve la publicación creada.
     */
    @POST("api/publication")
    Call<Publication> create(@Body PublicationPostDto publicationDto);

    /**
     * Actualiza una publicación existente en el sistema.
     * @param id El identificador de la publicación a ser actualizada.
     * @param publication La nueva información de la publicación.
     * @return Una llamada que devuelve la publicación actualizada.
     */
    @PUT("api/publication/{id}")
    Call<Publication> update(@Path("id") long id, @Body PublicationPutDto publicationDto);

    /**
     * Elimina una publicación del sistema.
     * @param publicationId El identificador de la publicación a ser eliminada.
     * @return Una llamada que indica si la eliminación fue exitosa o no.
     */
    @DELETE("api/publication/{id}")
    Call<Void> deletePost(@Path("id") long publicationId);
}
