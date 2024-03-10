package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DirectorActivity extends AppCompatActivity {

    private RecyclerView recyclerViewDirector;

    private DirectorAdaptador directorAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director);

        recyclerViewDirector = (RecyclerView) findViewById(R.id.reciclerDirector);
        recyclerViewDirector.setLayoutManager(new LinearLayoutManager(this));

        DbHelper dbHelper = new DbHelper(getApplicationContext());

        directorAdaptador = new DirectorAdaptador(dbHelper.mostrarDirectores());
        recyclerViewDirector.setAdapter(directorAdaptador);

    }


}
