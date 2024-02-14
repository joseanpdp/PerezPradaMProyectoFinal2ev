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
import com.vedruna.proyectoFinal.dto.PublicationPutDto;
import com.vedruna.proyectoFinal.interfaces.CRUDInterface;
import com.vedruna.proyectoFinal.model.Publication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateFragment extends Fragment {

    private CRUDInterface crudInterface;
    private Button buttonUpdate;
    private EditText idPut;
    private EditText textPut;
    private EditText creationDatePut;
    private EditText editionDatePut;

    public UpdateFragment() {
        // Constructor público vacío requerido
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        idPut = view.findViewById(R.id.idPut);
        textPut = view.findViewById(R.id.textPut);
        creationDatePut = view.findViewById(R.id.creationDatePut);
        editionDatePut = view.findViewById(R.id.editionDatePut);

        setupCreateButton(view);

        return view;
    }

    /**
     * Configura el botón de eliminación.
     * @param view La vista en la que se encuentra el botón.
     */
    private void setupCreateButton(View view) {
        buttonUpdate = view.findViewById(R.id.buttonUpdate);

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idString = idPut.getText().toString().trim();
                String textString = textPut.getText().toString().trim();
                String creationDateString = creationDatePut.getText().toString().trim();
                String editionDateString = editionDatePut.getText().toString().trim();
                if (!idString.isEmpty() && !textString.isEmpty() && !creationDateString.isEmpty() && !editionDateString.isEmpty()) {
                    PublicationPutDto dto = new PublicationPutDto(Long.parseLong(idString), LoginActivity.loggedUser.getId(), textString, "2024-02-14", "2024-02-14");
                    editPublication(Long.parseLong(idString), dto);
                } else {
                    Toast.makeText(getContext(), "No se ha encontrado ningún texto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void editPublication(long id, PublicationPutDto dto) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.65:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<Publication> call = crudInterface.update(id, dto);
        call.enqueue(new Callback<Publication>() {
            @Override
            public void onResponse(Call<Publication> call, Response<Publication> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err", response.message());
                    Toast.makeText(getContext(), "No se ha podido modificar la publicación", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getContext(), "Publicación modificada con éxito", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Publication> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                Toast.makeText(getContext(), "Error al modificar la publicación", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
