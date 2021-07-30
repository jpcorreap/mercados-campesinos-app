package com.equipo4.mercadoapp;
//create el 26/07/2021 para probes
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class VistaCampActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistacamp);
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
                //Snackbar.make(this,item,"Clic desde la opcion news", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case R.id.navigation_login:
                //Snackbar.make(this,item,"Clic desde la opcion login", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}