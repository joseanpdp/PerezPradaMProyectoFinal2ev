package com.vedruna.proyectoFinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vedruna.perezpradamproyectofinal.R;
import com.vedruna.proyectoFinal.interfaces.CRUDInterface;
import com.vedruna.proyectoFinal.model.Publication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MainActivity sirve como el punto de entrada de la aplicación.
 * Administra la navegación y muestra diferentes fragmentos según la interacción del usuario.
 */
public class MainActivity extends AppCompatActivity {

    private TextView textViewBienvenida;

    /**
     * El método onCreate se llama cuando la actividad está comenzando.
     * Inicializa el diseño de la actividad y configura la navegación inferior.
     * @param savedInstanceState Un Bundle que contiene el estado previamente guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.homeFrag);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.homeFrag);
            } else if (item.getItemId() == R.id.navigation_add) {
                navController.navigate(R.id.addFrag);
            } else if (item.getItemId() == R.id.navigation_update) {
                navController.navigate(R.id.updateFrag);
                //getAll();
            } else if (item.getItemId() == R.id.navigation_delete) {
                navController.navigate(R.id.deleteFrag);
            } else if (item.getItemId() == R.id.navigation_logout) {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                this.finish();
            }
            return true;
        });
    }
}
