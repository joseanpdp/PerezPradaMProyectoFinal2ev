package com.vedruna.proyectoFinal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.vedruna.perezpradamproyectofinal.R;
import com.vedruna.proyectoFinal.interfaces.CRUDInterface;
import com.vedruna.proyectoFinal.model.Publication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeleteFragment extends Fragment {

    private CRUDInterface crudInterface;
    private Button buttonDelete;
    private EditText idPost;

    public DeleteFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        idPost = view.findViewById(R.id.idPost);

        setupDeleteButton(view);

        return view;
    }

    /**
     * Configura el botón de eliminación.
     * @param view La vista en la que se encuentra el botón.
     */
    private void setupDeleteButton(View view) {
        buttonDelete = view.findViewById(R.id.buttonDelete);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idString = idPost.getText().toString().trim();

                if (!idString.isEmpty()) {
                    long id = Long.parseLong(idString);
                    deletePost(id);
                } else {
                    Toast.makeText(getContext(), "Error al eliminar la publicación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Elimina la publicación del servidor.
     * @param id El ID de la publicación a eliminar.
     */
    public void deletePost(long id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.65:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        crudInterface = retrofit.create(CRUDInterface.class);
        Call<Void> call = crudInterface.deletePost(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Publicación eliminada con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Response err", response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                Toast.makeText(getContext(), "Error al eliminar la publicación", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
