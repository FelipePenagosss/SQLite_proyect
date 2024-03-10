package com.cmp.sqlite_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityPremio extends AppCompatActivity {

    EditText editIdPR, editNombrePR, editCategoriaPR, editAnioPR, editIdpeliculaPR;
    Button btnAgregarPR,btnMostrarPR,btnBuscarPR, btnEditarPR, btnEliminarPR;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_premio);

        editIdPR = (EditText) findViewById(R.id.editIdPR);
        editNombrePR = (EditText) findViewById(R.id.editNombrePR);
        editCategoriaPR = (EditText) findViewById(R.id.editCategoriaPR);
        editAnioPR = (EditText) findViewById(R.id.editAnioPR);
        editIdpeliculaPR = (EditText) findViewById(R.id.editIdpeliculaPR);

        btnAgregarPR = (Button) findViewById(R.id.btnAgregarPR);
        btnMostrarPR = (Button) findViewById(R.id.btnMostrarPR);
        btnBuscarPR= (Button) findViewById(R.id.btnBuscarPR);
        btnEditarPR = (Button) findViewById(R.id.btnEditaPR);
        btnEliminarPR = (Button) findViewById(R.id.btnEliminarPR);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnAgregarPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.agregarPremio(
                        Integer.parseInt(editIdPR.getText().toString()),
                        editNombrePR.getText().toString(),
                        editCategoriaPR.getText().toString(),
                        Integer.parseInt(editAnioPR.getText().toString()),
                        Integer.parseInt(editIdpeliculaPR.getText().toString())
                );

                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();
            }
        });

        btnBuscarPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PremioModelo premioModelo = new PremioModelo();
                dbHelper.buscarPremio(premioModelo,Integer.parseInt(editIdPR.getText().toString()));

                editNombrePR.setText(premioModelo.getNombre());
                editCategoriaPR.setText(premioModelo.getCategoria());
                editAnioPR.setText(premioModelo.getAnio());
                editIdpeliculaPR.setText(premioModelo.getId_peliculaPr());


            }
        });

        btnEditarPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.editarPremio(
                        Integer.parseInt(editIdPR.getText().toString()),
                        editNombrePR.getText().toString(),
                        editCategoriaPR.getText().toString(),
                        Integer.parseInt(editAnioPR.getText().toString()),
                        Integer.parseInt(editIdpeliculaPR.getText().toString())
                );

                Toast.makeText(getApplicationContext(), "SE MODIFICÓ EL REGISTRO CORRECTAMENTE", Toast.LENGTH_LONG).show();
            }


        });

        btnMostrarPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarPremios = new Intent(getApplicationContext(),PremioActivity.class);
                startActivity(mostrarPremios);
            }
        });

        btnEliminarPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.eliminarPremio(Integer.parseInt(editIdPR.getText().toString()));


                Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                        " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();



            }
        });





    }
}
