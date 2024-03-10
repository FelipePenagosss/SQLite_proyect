package com.cmp.sqlite_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaPrincipal extends AppCompatActivity {

    Button btnPeliculas,btnTipoActor,btnActores,btnPremios,btnDirectores,btnPD,btnPA;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);



        btnPremios = (Button) findViewById(R.id.btnPremio);
        btnPeliculas = (Button) findViewById(R.id.btnPeliculas);
        btnTipoActor = (Button) findViewById(R.id.btnTipoActor);
        btnActores = (Button) findViewById(R.id.btnActor);
        btnDirectores = (Button) findViewById(R.id.btnDirectores);
        btnPD = (Button) findViewById(R.id.btnParticipacionPeliculaDirector);
        btnPA = (Button) findViewById(R.id.btnParticipacionPeliculaActor);




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

        btnPremios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent mostrarFormularioPremio = new Intent(getApplicationContext(), MainActivityPremio.class);
                startActivity(mostrarFormularioPremio);
            }
        });

        btnDirectores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent mostrarFormularioDirectores = new Intent(getApplicationContext(), MainActivityDirector.class);
                startActivity(mostrarFormularioDirectores);
            }
        });


        btnPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent mostrarFormularioParticipacionDirectores = new Intent(getApplicationContext(), MainActivityPD.class);
                startActivity(mostrarFormularioParticipacionDirectores);
            }
        });

        btnPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent mostrarFormularioParticipacionActores = new Intent(getApplicationContext(), MainActivityPA.class);
                startActivity(mostrarFormularioParticipacionActores);
            }
        });




    }




}