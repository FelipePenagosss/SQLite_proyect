package com.cmp.sqlite_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaPrincipal extends AppCompatActivity {

    Button btnPeliculas,btnTipoActor,btnActores;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);


        btnPeliculas = (Button) findViewById(R.id.btnPeliculas);
        btnTipoActor = (Button) findViewById(R.id.btnTipoActor);
        btnActores = (Button) findViewById(R.id.btnActor);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

    btnPeliculas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent mostrarFormularioPeliculas = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mostrarFormularioPeliculas);

        }
    });

        btnTipoActor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent mostrarFormularioTipoActor = new Intent(getApplicationContext(), MainActivityTipoActor.class);
                startActivity(mostrarFormularioTipoActor);
            }
        });

        btnActores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent mostrarFormularioActor = new Intent(getApplicationContext(), MainActivityActor.class);
                startActivity(mostrarFormularioActor);
            }
        });




    }




}