package com.vedruna.proyectoFinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vedruna.perezpradamproyectofinal.R;
import com.vedruna.proyectoFinal.interfaces.CRUDInterface;
import com.vedruna.proyectoFinal.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * LoginActivity gestiona el proceso de inicio de sesión del usuario.
 * Recupera las credenciales del usuario, las verifica contra el servidor,
 * y redirige a MainActivity tras una autenticación exitosa.
 */
public class LoginActivity extends AppCompatActivity {

    private List<User> users;
    private CRUDInterface crudInterface;

    private EditText userName, userPassword;
    private Button buttonLogin;

    /**
     * El método onCreate se llama cuando la actividad está comenzando.
     * Inicializa el diseño de la actividad y recupera las referencias a los elementos de la interfaz de usuario.
     * @param savedInstanceState Un Bundle que contiene el estado previamente guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        buttonLogin = findViewById(R.id.loginButton);
    }

    /**
     * El método login se invoca cuando se hace clic en el botón de inicio de sesión.
     * Activa el proceso de autenticación llamando al método getAll().
     * @param view La vista que se ha clicado.
     */
    public void login(View view) {
        getAll();
    }

    /**
     * El método getAll obtiene todos los usuarios del servidor.
     * Utiliza Retrofit para hacer una llamada de red para recuperar los datos del usuario.
     */
    private void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.65:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<User>> call = crudInterface.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }
                users = response.body();
                verifyCredentials();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }

    /**
     * El método verifyCredentials compara el nombre de usuario y la contraseña introducidos con los datos de usuario recuperados del servidor.
     * Si las credenciales coinciden, se redirige a MainActivity; de lo contrario, se muestra un mensaje de error.
     */
    private void verifyCredentials() {
        String username = userName.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        boolean userFound = false;

        if (users != null) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    userFound = true;
                    break;
                }
            }
        }

        if (!userFound) {
            Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(LoginActivity.this, "Inicio de sesión correcto", Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        }
    }
}
