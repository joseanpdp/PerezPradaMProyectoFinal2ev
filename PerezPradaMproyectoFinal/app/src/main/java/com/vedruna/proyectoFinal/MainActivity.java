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

/*
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
 */

public class MainActivity extends AppCompatActivity {

    private TextView textViewBienvenida;

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