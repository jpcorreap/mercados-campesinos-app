package com.equipo4.mercadoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //UI *create el 26/07/2021 para probes
    Button register, login, verCampaign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //*create el 26/07/2021 para probes
        init();
        events();
    }

    //*create el 26/07/2021 para probes
    private void events() {
        verCampaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click desde ver Campaña", Toast.LENGTH_SHORT).show();
            }
        });


//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Click desde registrarse", Toast.LENGTH_SHORT).show();
//            }
//        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Click desde Login", Toast.LENGTH_SHORT).show();
//            }
//        });
        verCampaign.setOnClickListener(this);
//        register.setOnClickListener(this);
//        login.setOnClickListener(this);

    }

    //*create el 26/07/2021 para probes
    private void init() {
//        register = findViewById(R.id.button_registrar);
//        login = findViewById(R.id.button_iniciarSesion);
        verCampaign = findViewById(R.id.button_verCampaña);

    }

    //*create el 26/07/2021 para probes
    @Override
    public void onClick(View v) {
        Intent pantalla = null;
        String msg = "";
        switch (v.getId()) {
            case R.id.button_verCampaña:
                msg = "Clic desde ver Campaña";
                pantalla = new Intent(this, VistaCampActivity.class);
                break;
//            case R.id.button_registrar:
//                msg = "Clic desde registrarse";
//                pantalla = new Intent(this, VistaCampActivity.class);
//                break;
//            case R.id.button_iniciarSesion:
//                msg = "Clic desde login";
//                pantalla = new Intent(this, VistaCampActivity.class);
//                break;

            default:
                throw new IllegalArgumentException();
        }
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

        //*creado el 26/07/2021 para pruebas
        startActivity(pantalla);

    }



}