package com.equipo4.mercadoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView register;
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

      /*  register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla= null;
                pantalla = new Intent( this, MainActivity.class);
                Toast.makeText( LoginActivity.this, "click", Toast.LENGTH_SHORT).show();

                startActivity(pantalla); */
        register.setOnClickListener(this);
            }


    @Override
    public void onClick(View v) {

        Intent pantalla = null;
        String msg = "";
        switch (v.getId()) {
            case R.id.registerMain:
                msg = "Clic";
                pantalla = new Intent(this, MainActivity.class);
                break;
            default:
                throw new IllegalArgumentException();
        }
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            startActivity(pantalla);

    }


    private void init(){

        register = findViewById(R.id.registerMain);
       // logiButton = findViewById(R.id.registerMain);


    }


}