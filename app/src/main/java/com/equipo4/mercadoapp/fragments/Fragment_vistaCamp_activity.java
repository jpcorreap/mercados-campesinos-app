package com.equipo4.mercadoapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.equipo4.mercadoapp.DetailActivity;
import com.equipo4.mercadoapp.R;
import com.equipo4.mercadoapp.adapter.RecyclerAdapter;
import com.equipo4.mercadoapp.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class Fragment_vistaCamp_activity extends Fragment implements RecyclerAdapter.RecyclerItemClick {

    private List<ItemList> items;
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private SearchView svSearch;

    public Fragment_vistaCamp_activity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValues();
    }

    //*create el 02/08/2021 para probes
    private void initValues(){
        items = getItems();
        adapter = new RecyclerAdapter(items,this);


    }

    //*create el 02/08/2021 para probes
    private void initListener(){
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvLista = view.findViewById(R.id.recyclerView);
        svSearch = view.findViewById(R.id.searchView);
        initValuesView();
        initListener();
    }

    private void initValuesView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvLista.setLayoutManager(manager);
        rvLista.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vista_camp_activity, container, false);
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("itemDetail",item);
        startActivity(intent);

    }
}