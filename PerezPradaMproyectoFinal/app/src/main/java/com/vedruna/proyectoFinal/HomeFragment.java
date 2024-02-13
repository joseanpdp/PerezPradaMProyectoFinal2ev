package com.vedruna.proyectoFinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vedruna.perezpradamproyectofinal.R;
import com.vedruna.proyectoFinal.adapters.PublicationsAdapter;
import com.vedruna.proyectoFinal.interfaces.CRUDInterface;
import com.vedruna.proyectoFinal.model.Publication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private List<Publication> publications;
    private CRUDInterface crudInterface;

    private ListView publicationListView;

    public HomeFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        publicationListView = view.findViewById(R.id.publicationList);
        getAll();
        return view;
    }

    /**
     * Método para obtener todas las publicaciones desde el servidor.
     * Utiliza Retrofit para hacer una llamada de red para recuperar los datos de las publicaciones.
     */
    private void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.65:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Publication>> call = crudInterface.getAllPublications();
        call.enqueue(new Callback<List<Publication>>() {
            @Override
            public void onResponse(Call<List<Publication>> call, Response<List<Publication>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }
                publications = response.body();
                PublicationsAdapter publicationsAdapter = new PublicationsAdapter(publications, getContext());
                publicationListView.setAdapter(publicationsAdapter);
                publications.forEach(p -> Log.i("Prods: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Publication>> call, Throwable t) {
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }
}
