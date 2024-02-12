package com.vedruna.proyectoFinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vedruna.perezpradamproyectofinal.R;

public class LoginActivity extends AppCompatActivity {


    private EditText userName, userPassword;
    private Button buttonLogin;
    private TextView textViewError;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        buttonLogin = findViewById(R.id.loginButton);


        /*
        buttonLogin.setOnClickListener( (View v) -> {
            String username = userName.getText().toString();
            String password = userPassword.getText().toString();

            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Nombre o contraseña erróneos", Toast.LENGTH_SHORT).show();
                //textViewError.setText("Nombre o contraseña erróneos");
            }
        });
         */
    }
    public void login(View view) {
        String username = userName.getText().toString().trim();
        String password = userPassword.getText().toString();

        if (username.equals("admin") && password.equals("admin")) {
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
        }
    }
}