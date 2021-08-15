package com.equipo4.mercadoapp;
//create el 26/07/2021 para probes

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.equipo4.mercadoapp.fragments.Fragment_About;
import com.equipo4.mercadoapp.fragments.Fragment_LoginActivity;
import com.equipo4.mercadoapp.fragments.Fragment_RegisterActivity;
import com.equipo4.mercadoapp.fragments.Fragment_vistaCamp_activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VistaCampActivity extends AppCompatActivity  {
    //*create el 02/08/2021 para probes


    //*create el 10/08/2021 para test
    Fragment_vistaCamp_activity fragment_vistaCamp_activity = new Fragment_vistaCamp_activity();
    Fragment_LoginActivity fragment_loginActivity = new Fragment_LoginActivity();
    Fragment_RegisterActivity fragment_registerActivity = new Fragment_RegisterActivity();
    Fragment_About fragment_about = new Fragment_About();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistacamp);
        //*create el 02/08/2021 para probes


        //*create el 10/08/2021 para test
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);


        loadFragment(fragment_vistaCamp_activity);

    }
    //*create el 10/08/2021 para test
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.navigation_verCamp:
                    loadFragment(fragment_vistaCamp_activity);
                    return true;
                case R.id.navigation_login:
                    loadFragment(fragment_loginActivity);
                    return true;
                case R.id.navigation_register:
                    loadFragment(fragment_registerActivity);
                    return true;
                case R.id.navigation_about:
                    loadFragment(fragment_about);
                    return true;

            }
            return false;
        }
    };
    //*create el 10/08/2021 para test
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    //*create el 25/07/2021 para probes
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
        return true;
    }

    //*create el 25/07/2021 para probes
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_verCamp:
                Toast.makeText(this, "Clic desde la opcion Inicio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_about:
                Toast.makeText(this, "Clic desde la opcion SMS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_register:
                Toast.makeText(this, "Clic desde la opcion Noticias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_login:
                Toast.makeText(this, "Clic desde la opcion Login", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}