package com.vedruna.proyectoFinal.interfaces;

import com.vedruna.proyectoFinal.model.Publication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CRUDInterface {
    @GET("api/publication")
    Call<List<Publication>> getAll();
}
