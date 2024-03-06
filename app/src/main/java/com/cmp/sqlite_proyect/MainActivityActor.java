package com.cmp.sqlite_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityActor extends AppCompatActivity {
    EditText editIdAC, editNombreAC, editFechaAC, editNacionalidadAC,editSexoAC,editTipoActorAC;
    Button btnAgregarAC,btnMostrarAC,btnBuscarAC, btnEditarAC, btnEliminarAC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actor);

        editIdAC = (EditText) findViewById(R.id.editIdAC);
        editNombreAC = (EditText) findViewById(R.id.editNombreAC);
        editFechaAC = (EditText) findViewById(R.id.editFechaAC);
        editNacionalidadAC = (EditText) findViewById(R.id.editNacionalidadAC);
        editSexoAC = (EditText) findViewById(R.id.editSexoAC);
        editTipoActorAC = (EditText) findViewById(R.id.editTipoAC);

        btnAgregarAC = (Button) findViewById(R.id.btnAgregarAC);
        btnMostrarAC = (Button) findViewById(R.id.btnMostrarAC);
        btnBuscarAC = (Button) findViewById(R.id.btnBuscarAC);
        btnEditarAC = (Button) findViewById(R.id.btnEditarAC);
        btnEliminarAC = (Button) findViewById(R.id.btnEliminarAC);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnAgregarAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.agregarActor(

                        Integer.parseInt(editIdAC.getText().toString()),
                        editNombreAC.getText().toString(),
                        editFechaAC.getText().toString(),
                        editNacionalidadAC.getText().toString(),
                        editSexoAC.getText().toString(),
                        Integer.parseInt(editTipoActorAC.getText().toString())
                );

                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();

            }
        });

        btnBuscarAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActorModelo actorModelo = new ActorModelo();
                dbHelper.buscarActor(actorModelo,Integer.parseInt(editIdAC.getText().toString()));

                editNombreAC.setText(actorModelo.getNombre());
                editFechaAC.setText(actorModelo.getFecha());
                editNacionalidadAC.setText(actorModelo.getNacionalidad());
                editSexoAC.setText(actorModelo.getSexo());
                editTipoActorAC.setText(String.valueOf(actorModelo.getId_tipo_actor()));


            }
        });

        btnEditarAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.editarActor(
                        Integer.parseInt(editIdAC.getText().toString()),
                        editNombreAC.getText().toString(),
                        editFechaAC.getText().toString(),
                        editNacionalidadAC.getText().toString(),
                        editSexoAC.getText().toString(),
                        Integer.parseInt(editTipoActorAC.getText().toString())
                );

                Toast.makeText(getApplicationContext(), "SE MODIFICÓ EL REGISTRO CORRECTAMENTE", Toast.LENGTH_LONG).show();
            }


        });

        btnMostrarAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarActores = new Intent(getApplicationContext(),ActorActivity.class);
                startActivity(mostrarActores);
            }
        });


        btnEliminarAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.eliminarActor(Integer.parseInt(editIdAC.getText().toString()));


                Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                        " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();



            }
        });





    }
}
