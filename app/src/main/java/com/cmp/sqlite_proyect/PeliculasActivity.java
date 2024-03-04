package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PeliculasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPelicula;
    private PeliculasAdaptador peliculasAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        recyclerViewPelicula = (RecyclerView) findViewById(R.id.reciclerPelicula);
        recyclerViewPelicula.setLayoutManager(new LinearLayoutManager(this));

        DbHelper dbHelper  = new DbHelper(getApplicationContext());




        peliculasAdaptador = new PeliculasAdaptador(dbHelper.mostrarPeliculas());
        recyclerViewPelicula.setAdapter(peliculasAdaptador);


    }


}
