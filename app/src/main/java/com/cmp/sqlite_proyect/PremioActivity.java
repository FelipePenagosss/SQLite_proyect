package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PremioActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPremio;

    private PremioAdaptador premioAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premio);

        recyclerViewPremio = (RecyclerView) findViewById(R.id.reciclerPremio);
        recyclerViewPremio.setLayoutManager(new LinearLayoutManager(this));

        DbHelper dbHelper = new DbHelper(getApplicationContext());

        premioAdaptador = new PremioAdaptador(dbHelper.mostrarPremios());
        recyclerViewPremio.setAdapter(premioAdaptador);

    }
}
