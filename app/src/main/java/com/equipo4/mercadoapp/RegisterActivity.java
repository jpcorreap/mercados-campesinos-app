package com.equipo4.mercadoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.equipo4.mercadoapp.model.User;
import com.equipo4.mercadoapp.sqlite.OpenHelper;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    //UI
    TextInputEditText name, username, email, phone, password, passwordRepeat;
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
                //Toast.makeText(RegisterActivity.this, "Listo para registrar", Toast.LENGTH_SHORT).show();
                registrarUser();
            else
                Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        });
    }

    private void registrarUser() {
        User user = new User(name.getText().toString(), username.getText().toString(),
                email.getText().toString(), password.getText().toString(),
                Long.parseLong(phone.getText().toString()));
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
        helper = new OpenHelper(this);
    }

}