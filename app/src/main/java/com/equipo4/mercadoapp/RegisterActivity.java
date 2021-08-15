package com.equipo4.mercadoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.equipo4.mercadoapp.model.User;
import com.equipo4.mercadoapp.sqlite.OpenHelper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity implements OnMapReadyCallback {

    //UI
    TextInputEditText name, username, email, phone, password, passwordRepeat;
    Button register;

    //SQLite
    OpenHelper helper;

    //Fragment
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_register);

        init();
        events();
    }

    private void events() {
        register.setOnClickListener(v -> {
            if(name.getText().toString().equals("") || username.getText().toString().equals("") ||
                    email.getText().toString().equals("") || phone.getText().toString().equals("") ||
                    password.getText().toString().equals("") || password.getText().toString().equals("")){
                Snackbar.make(v, "Datos incompletos\nPor favor llenar todos los espacios", Snackbar.LENGTH_SHORT).show();
                return;
            }
            if(password.getText().toString().equals(passwordRepeat.getText().toString()))
                registrarUser();
            else
                Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        });
    }

    private void registrarUser() {
        User user = new User(name.getText().toString(), username.getText().toString(),
                email.getText().toString(), password.getText().toString(),
                phone.getText().toString());
        long rows = helper.insert(User.TABLE, user.getContentValues());
        if(rows > 0)
            Toast.makeText(this, "Se registro el usuario correctamente", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No se registro el usuario :C", Toast.LENGTH_SHORT).show();
    }

    private void init(){
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        email = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        passwordRepeat = findViewById(R.id.passwordRepeat);
        register = findViewById(R.id.registerFarmer);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.location);
        mapFragment.getMapAsync(this);
        helper = new OpenHelper(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}