package com.cmp.sqlite_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPA extends AppCompatActivity {


    EditText editIdPA, editIdPelicula,editIdActor;

    Button btnAgregarPA,btnMostrarPA,btnBuscarPA, btnEditarPA, btnEliminarPA;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pa);


        editIdPA = (EditText) findViewById(R.id.editIdPA);
        editIdPelicula = (EditText) findViewById(R.id.editIdpeliculaPA);
        editIdActor = (EditText) findViewById(R.id.editIdActorPA);


        btnAgregarPA = (Button) findViewById(R.id.btnAgregarPA);
        btnMostrarPA = (Button) findViewById(R.id.btnMostrarPA);
        btnBuscarPA = (Button) findViewById(R.id.btnBuscarPA);
        btnEditarPA = (Button) findViewById(R.id.btnEditaPA);
        btnEliminarPA = (Button) findViewById(R.id.btnEliminarPA);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnAgregarPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.agregarParticipacionActor(
                        Integer.parseInt(editIdPA.getText().toString()),
                        Integer.parseInt(editIdPelicula.getText().toString()),
                        Integer.parseInt(editIdActor.getText().toString())
                );

                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();


            }
        });

        btnMostrarPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarParticipacionActores = new Intent(getApplicationContext(),PAActivity.class);
                startActivity(mostrarParticipacionActores);
            }
        });

        btnBuscarPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PAModelo paModelo = new PAModelo();
                dbHelper.buscarParticipacionActor(paModelo,Integer.parseInt(editIdPA.getText().toString()));

                editIdPelicula.setText(String.valueOf(paModelo.getId_pelicula()));
                editIdActor.setText(String.valueOf(paModelo.getId_actor()));



            }
        });

        btnEditarPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.editarParticipacionActor(Integer.parseInt(editIdPA.getText().toString()),Integer.parseInt(editIdPelicula.getText().toString()),Integer.parseInt(editIdActor.getText().toString()));

                Toast.makeText(getApplicationContext(),"SE MODIFICO EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();

            }

        });

        btnEliminarPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.eliminarParticipacionActor(Integer.parseInt(editIdPA.getText().toString()));

                Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                        " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();
            }
        });



    }

}
