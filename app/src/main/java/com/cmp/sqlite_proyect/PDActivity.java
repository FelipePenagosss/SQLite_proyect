package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PDActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPD;
    private PDAdaptador pdAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pd);

        recyclerViewPD = (RecyclerView) findViewById(R.id.reciclerParticipacionDirector);
        recyclerViewPD.setLayoutManager(new LinearLayoutManager(this));


        DbHelper dbHelper = new DbHelper(getApplicationContext());

        pdAdaptador = new PDAdaptador(dbHelper.mostrarParticipacionesDirectores());
        recyclerViewPD.setAdapter(pdAdaptador);



    }

}
