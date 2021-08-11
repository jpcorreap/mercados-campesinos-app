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

public class VistaCampActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,RecyclerAdapter.RecyclerItemClick {
    //*create el 02/08/2021 para probes
    private List<ItemList> items;
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private SearchView svSearch;

    //*create el 10/08/2021 para test
    Fragment_vistaCamp_activity fragment_vistaCamp_activity = new Fragment_vistaCamp_activity();
    Fragment_LoginActivity fragment_loginActivity = new Fragment_LoginActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistacamp);
        //*create el 02/08/2021 para probes
        initviews();
        initValues();
        initListener();

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


    //*create el 02/08/2021 para probes
    private void initviews(){
        rvLista = findViewById(R.id.recyclerView);
        svSearch = findViewById(R.id.searchView);

    }
    //*create el 02/08/2021 para probes
    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items,this);
        rvLista.setAdapter(adapter);

    }
    //*create el 02/08/2021 para probes
    private void initListener(){
        svSearch.setOnQueryTextListener(this);
    }

    //*create el 02/08/2021 para probes
    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList(R.drawable.logo_mercado_campesino,"1","Varios agricultores de la region invitados con muchos productos frescos","Parque El Divino Niño","Cra 32 #63a-15","agricultor1@agricultor.com","3001234567"));
        itemLists.add(new ItemList(R.drawable.logo_mercado_campesino,"2","Invitado especial en esta ocasion con muchos productos frescos","Parque El Dorado","Cra 40 #20-135","agricultor2@agricultor.com","3011234567"));
        itemLists.add(new ItemList(R.drawable.logo_mercado_campesino,"3","Con la participacion de las Fincas cercanas de la region con muchos productos frescos","Parque La Gloria","Cra 99 #80-75","agricultor3@agricultor.com","3021234567"));
        itemLists.add(new ItemList(R.drawable.logo_mercado_campesino,"4","Gran evento musical con banda y varios agricultores invitados con muchos productos frescos","Parque Libertadores","Calle 32 #45a-66","agricultor4@agricultor.com","3031234567"));
        itemLists.add(new ItemList(R.drawable.logo_mercado_campesino,"5","Ultimos dias, no dejes de pasar a comprar muchos productos frescos y asi apoyar a nuestros campesinos","Parque La Montaña","Calle 60a #70-55","agricultor5@agricultor.com","3041234567"));

        return itemLists;

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
    //*create el 02/08/2021 para probes
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    //*create el 02/08/2021 para probes
    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("itemDetail",item);
        startActivity(intent);
    }


}