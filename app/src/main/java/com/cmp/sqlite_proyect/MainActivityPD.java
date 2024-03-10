package com.cmp.sqlite_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPD extends AppCompatActivity {

    EditText editIdPD, editIdPelicula,editIdDirector;

    Button btnAgregarPD,btnMostrarPD,btnBuscarPD, btnEditarPD, btnEliminarPD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pd);


        editIdPD = (EditText) findViewById(R.id.editIdPD);
        editIdPelicula = (EditText) findViewById(R.id.editIdpeliculaPd);
        editIdDirector = (EditText) findViewById(R.id.editIdDirectorPD);


        btnAgregarPD = (Button) findViewById(R.id.btnAgregarPD);
        btnMostrarPD = (Button) findViewById(R.id.btnMostrarPD);
        btnBuscarPD = (Button) findViewById(R.id.btnBuscarPD);
        btnEditarPD = (Button) findViewById(R.id.btnEditaPD);
        btnEliminarPD = (Button) findViewById(R.id.btnEliminarPD);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnAgregarPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.agregarParticipacionDirector(
                        Integer.parseInt(editIdPD.getText().toString()),
                        Integer.parseInt(editIdPelicula.getText().toString()),
                        Integer.parseInt(editIdDirector.getText().toString())
                );

                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();


            }
        });

        btnMostrarPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarParticipacionDirectores = new Intent(getApplicationContext(),PDActivity.class);
                startActivity(mostrarParticipacionDirectores);
            }
        });

        btnBuscarPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParticipacionDirectorModelo participacionDirectorModelo = new ParticipacionDirectorModelo();
                dbHelper.buscarParticipacionDirector(participacionDirectorModelo,Integer.parseInt(editIdPD.getText().toString()));

                editIdPelicula.setText(participacionDirectorModelo.getId_pelicula());
                editIdDirector.setText(participacionDirectorModelo.getId_director());



            }
        });

        btnEditarPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.editarParticipacionDirector(Integer.parseInt(editIdPD.getText().toString()),Integer.parseInt(editIdPelicula.getText().toString()),Integer.parseInt(editIdDirector.getText().toString()));

                Toast.makeText(getApplicationContext(),"SE MODIFICO EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();

            }

        });

        btnEliminarPD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.eliminarParticipacionDirector(Integer.parseInt(editIdPD.getText().toString()));

                Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                        " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();
            }
        });



    }


}
