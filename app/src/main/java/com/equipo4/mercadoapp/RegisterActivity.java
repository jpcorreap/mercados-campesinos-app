package com.equipo4.mercadoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.equipo4.mercadoapp.sqlite.OpenHelper;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    //UI
    TextInputEditText name, username, mail, phone, password, passwordRepeat;
    Button register;

    //SQLite
    OpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_register);

        init();
        events();
    }

    private void events() {
        register.setOnClickListener(v -> {
            if(password.getText().toString().equals(passwordRepeat.getText().toString()))
                Toast.makeText(RegisterActivity.this, "Listo para registrar", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        });
    }

    private void init(){
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        mail = findViewById(R.id.mail);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        passwordRepeat = findViewById(R.id.passwordRepeat);
        register = findViewById(R.id.registerFarmer);
        helper = new OpenHelper(this);
    }

}