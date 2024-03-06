package com.cmp.sqlite_proyect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityTipoActor extends AppCompatActivity {

    EditText editIdTA, editNombreTA;

    Button btnAgregarTA,btnMostrarTA,btnBuscarTA, btnEditarTA, btnEliminarTA;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tipoactor);


        editIdTA = (EditText) findViewById(R.id.editIdTA);
        editNombreTA = (EditText) findViewById(R.id.editNombreTA);

        btnAgregarTA = (Button) findViewById(R.id.btnAgregarTA);
        btnMostrarTA = (Button) findViewById(R.id.btnMostrarTA);
        btnBuscarTA = (Button) findViewById(R.id.btnBuscarTA);
        btnEditarTA = (Button) findViewById(R.id.btnEditaTA);
        btnEliminarTA = (Button) findViewById(R.id.btnEliminarTA);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnAgregarTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.agregarTipoActor(
                        Integer.parseInt(editIdTA.getText().toString()),
                        editNombreTA.getText().toString()
                );

                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();


            }
        });

        btnMostrarTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarTipoActores = new Intent(getApplicationContext(),TipoActorActivity.class);
                startActivity(mostrarTipoActores);
            }
        });

        btnBuscarTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipoActorModelo tipoActorModelo = new TipoActorModelo();
                dbHelper.buscarTipoActor(tipoActorModelo,Integer.parseInt(editIdTA.getText().toString()));

                editNombreTA.setText(tipoActorModelo.getNombre());



            }
        });

        btnEditarTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.editarTipoActor(Integer.parseInt(editIdTA.getText().toString()),editNombreTA.getText().toString());

                Toast.makeText(getApplicationContext(),"SE MODIFICO EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();

            }

        });

        btnEliminarTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.eliminarTipoActor(Integer.parseInt(editIdTA.getText().toString()));

                Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                        " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();
            }
        });



    }
}
