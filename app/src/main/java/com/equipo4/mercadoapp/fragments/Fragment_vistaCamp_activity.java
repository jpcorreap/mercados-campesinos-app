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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_vistaCamp_activity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_vistaCamp_activity extends Fragment implements RecyclerAdapter.RecyclerItemClick {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<ItemList> items;
    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private SearchView svSearch;

    public Fragment_vistaCamp_activity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_vistaCamp_activity.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_vistaCamp_activity newInstance(String param1, String param2) {
        Fragment_vistaCamp_activity fragment = new Fragment_vistaCamp_activity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        initValues();
        initListener();
    }

    //*create el 02/08/2021 para probes
    private void initValues(){
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items,this);
        rvLista.setAdapter(adapter);

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