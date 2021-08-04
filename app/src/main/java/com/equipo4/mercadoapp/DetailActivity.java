package com.equipo4.mercadoapp;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.equipo4.mercadoapp.model.ItemList;

public class DetailActivity extends AppCompatActivity {
    //*create el 03/08/2021 para probes
    private ImageView imgDetailMarket;
    private TextView tvDetailTitleMain;
    private TextView tvDetailTitlecounter;
    private TextView tvDetailComent;
    private TextView tvDetailPlace;
    private TextView tvDetailPlace2;
    private TextView tvDetailDirection;
    private TextView tvDetailDirection2;
    private TextView tvDetailMailTitle;
    private TextView tvDetailMail;
    private TextView tvDetailPhone;
    private TextView tvDetailPhoneNumber;

    private ItemList itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("DETALLE DE EVENTO");
        //setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews() {
        imgDetailMarket = findViewById(R.id.imgDetailMarket);
        tvDetailTitlecounter = findViewById(R.id.tvDetailTitleCounter);
        tvDetailComent = findViewById(R.id.tvDetailComent);
        tvDetailPlace2 = findViewById(R.id.tvDetailPlace2);
        tvDetailDirection2 = findViewById(R.id.tvDetailDirection2);
        tvDetailMail = findViewById(R.id.tvDetailMail);
        tvDetailPhoneNumber = findViewById(R.id.tvDetailPhoneNumber);

    }
    //*create el 03/08/2021 para probes
    private void initValues() {
        itemDetail = (ItemList) getIntent().getExtras().getSerializable("itemDetail");
        imgDetailMarket.setImageResource(itemDetail.getImgMarket());
        tvDetailTitlecounter.setText(itemDetail.getCounter());
        tvDetailComent.setText(itemDetail.getComent());
        tvDetailPlace2.setText(itemDetail.getPlace());
        tvDetailDirection2.setText(itemDetail.getDirection());
        tvDetailMail.setText(itemDetail.getEmail());
        tvDetailPhoneNumber.setText(itemDetail.getTelephone());
    }

}
