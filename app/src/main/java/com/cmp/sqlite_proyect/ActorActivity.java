package com.cmp.sqlite_proyect;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActorActivity extends AppCompatActivity {

private RecyclerView recyclerViewActor;

private ActorAdaptador actorAdaptador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);

        recyclerViewActor = (RecyclerView) findViewById(R.id.reciclerActor);
        recyclerViewActor.setLayoutManager(new LinearLayoutManager(this));

        DbHelper dbHelper = new DbHelper(getApplicationContext());

        actorAdaptador = new ActorAdaptador(dbHelper.mostrarActores());
        recyclerViewActor.setAdapter(actorAdaptador);

    }
}


