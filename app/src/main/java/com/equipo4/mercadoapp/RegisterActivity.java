package com.equipo4.mercadoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    //UI
    TextInputEditText name, username, mail, phone, password, passwordRepeat;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_register);

        init();
        events();
    }

    private void events() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password == passwordRepeat)
                    Toast.makeText(RegisterActivity.this, "Listo para registrar", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
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
    }

}