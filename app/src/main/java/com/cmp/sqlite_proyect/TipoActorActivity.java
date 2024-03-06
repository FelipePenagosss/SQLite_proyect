package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TipoActorActivity extends AppCompatActivity {

    private RecyclerView recyclerViewTipoActor;
    private TipoActorAdaptador tipoActorAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_actor);

        recyclerViewTipoActor = (RecyclerView) findViewById(R.id.reciclerTipoActor);
        recyclerViewTipoActor.setLayoutManager(new LinearLayoutManager(this));


        DbHelper dbHelper = new DbHelper(getApplicationContext());

        tipoActorAdaptador = new TipoActorAdaptador(dbHelper.mostrarTipoActores());
        recyclerViewTipoActor.setAdapter(tipoActorAdaptador);



    }
}
