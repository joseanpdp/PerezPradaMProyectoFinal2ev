package com.vedruna.proyectoFinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vedruna.perezpradamproyectofinal.R;
import com.vedruna.proyectoFinal.dto.PublicationPostDto;
import com.vedruna.proyectoFinal.interfaces.CRUDInterface;
import com.vedruna.proyectoFinal.model.Publication;

import java.time.LocalDate;
import java.time.LocalTime;

import kotlinx.coroutines.channels.ProduceKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Fragmento para agregar una nueva publicación.
 */
public class AddFragment extends Fragment {
    private CRUDInterface crudInterface;
    private Button buttonCreate;
    private EditText textCreate;

    public AddFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        textCreate = view.findViewById(R.id.textCreate);

        setupCreateButton(view);

        return view;
    }

    /**
     * Configura el botón de eliminación.
     * @param view La vista en la que se encuentra el botón.
     */
    private void setupCreateButton(View view) {
        buttonCreate = view.findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textString = textCreate.getText().toString().trim();
                if (!textString.isEmpty()) {
                    PublicationPostDto dto = new PublicationPostDto(LoginActivity.loggedUser.getId(), textString, "2024-02-14", "2024-02-14");
                    createPublication(dto);
                } else {
                    Toast.makeText(getContext(), "No se ha encontrado ningún texto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createPublication(PublicationPostDto dto) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.65:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<Publication> call = crudInterface.create(dto);
        call.enqueue(new Callback<Publication>() {
            @Override
            public void onResponse(Call<Publication> call, Response<Publication> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err", response.message());
                    Toast.makeText(getContext(), "No se ha podido crear la publicación", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getContext(), "Publicación creada con éxito", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Publication> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                Toast.makeText(getContext(), "Error al crear la publicación", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
