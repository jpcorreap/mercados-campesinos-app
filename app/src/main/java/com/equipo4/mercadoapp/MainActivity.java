package com.equipo4.mercadoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int GENERAL_REQUEST_CODE = 400;

    //UI *create el 26/07/2021 para probes
    Button register, login, verCampaign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Solicitar los permisos de la acplicación
        permissionRequest();
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
        register.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    //*create el 26/07/2021 para probes
    private void init() {
        register = findViewById(R.id.button_registrar);
        login = findViewById(R.id.button_iniciarSesion);
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
            case R.id.button_registrar:
                msg = "Clic desde registrarse";
                pantalla = new Intent(this, RegisterActivity.class);
                break;
            case R.id.button_iniciarSesion:
                msg = "Clic desde login";
                pantalla = new Intent(this, LoginActivity.class);
                break;

            default:
                throw new IllegalArgumentException();
        }
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

        //*creado el 26/07/2021 para pruebas
        startActivity(pantalla);

    }

    public void permissionRequest(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                GENERAL_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for(int a=0; a < grantResults.length;a++){
            if(PackageManager.PERMISSION_DENIED == grantResults[a])
                Toast.makeText(this, permissions[a]+" -> Rechazado", Toast.LENGTH_SHORT).show();
        }

    }



}