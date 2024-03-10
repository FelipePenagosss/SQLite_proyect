package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PAActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPA;
    private PAAdaptador paAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pa);

        recyclerViewPA = (RecyclerView) findViewById(R.id.reciclerParticipacionActor);
        recyclerViewPA.setLayoutManager(new LinearLayoutManager(this));


        DbHelper dbHelper = new DbHelper(getApplicationContext());

        paAdaptador = new PAAdaptador(dbHelper.mostrarParticipacionesActores());
        recyclerViewPA.setAdapter(paAdaptador);



    }

}
