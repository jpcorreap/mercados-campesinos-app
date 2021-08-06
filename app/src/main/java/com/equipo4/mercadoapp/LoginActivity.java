package com.equipo4.mercadoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView register, recover;
    EditText usuario, password;
    Button ingresar;
    CheckBox remember;
   // Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO check which view display
        setContentView(R.layout.activity_login);


        init();
        events();

    }

    private void events() {

        register.setOnClickListener(this);
        ingresar.setOnClickListener(this);
        recover.setOnClickListener(this);


            }


    @Override
    public void onClick(View v) {

        Intent pantalla = null;
        String msg = "";
        switch (v.getId()) {
            case R.id.ingresarLogin:
                msg = "Clic desde Ingresar";
                pantalla = new Intent(this, AppCompatActivity.class);
                break;
            case R.id.recoverLogin:
                msg = "Clic desde ¿Olvidaste la contraseña?";
                pantalla = new Intent(this, RememberActivity.class);
                break;
            case R.id.registerMain:
                msg = "Clic desde Registrar";
                pantalla = new Intent(this, RegisterActivity.class);
                break;
            default:
                throw new IllegalArgumentException();
        }
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            startActivity(pantalla);

    }


    private void init(){

        register = findViewById(R.id.registerMain);
        usuario = findViewById(R.id.usuarioLogin2);
        password = findViewById(R.id.passwordLogin2);
        remember = findViewById(R.id.rememberLogin);
        ingresar = findViewById(R.id.ingresarLogin);
        recover = findViewById(R.id.recoverLogin);


       // logiButton = findViewById(R.id.registerMain);


    }


}