package com.equipo4.mercadoapp;
//create el 26/07/2021 para probes

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.equipo4.mercadoapp.adapter.RecyclerAdapter;
import com.equipo4.mercadoapp.fragments.Fragment_LoginActivity;
import com.equipo4.mercadoapp.fragments.Fragment_vistaCamp_activity;
import com.equipo4.mercadoapp.model.ItemList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class VistaCampActivity extends AppCompatActivity  {
    //*create el 02/08/2021 para probes


    //*create el 10/08/2021 para test
    Fragment_vistaCamp_activity fragment_vistaCamp_activity = new Fragment_vistaCamp_activity();
    Fragment_LoginActivity fragment_loginActivity = new Fragment_LoginActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistacamp);
        //*create el 02/08/2021 para probes


        //*create el 10/08/2021 para test
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);


//        loadFragment(fragment_vistaCamp_activity);

    }
    //*create el 10/08/2021 para test
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.navigation_home:
                    loadFragment(fragment_vistaCamp_activity);
                    return true;
                case R.id.navigation_login:
                    loadFragment(fragment_loginActivity);
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
            case R.id.navigation_home:
                Toast.makeText(this, "Clic desde la opcion Inicio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_sms:
                Toast.makeText(this, "Clic desde la opcion SMS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_news:
                Toast.makeText(this, "Clic desde la opcion Noticias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_login:
                Toast.makeText(this, "Clic desde la opcion Login", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}