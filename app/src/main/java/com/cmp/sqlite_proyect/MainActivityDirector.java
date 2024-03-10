package com.cmp.sqlite_proyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDirector extends AppCompatActivity {

    EditText editIdDC, editNombreDC, editFechaDC, editNacionalidadDC,editSexoDC;
    Button btnAgregarDC,btnMostrarDC,btnBuscarDC, btnEditarDC, btnEliminarDC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_director);

        editIdDC = (EditText) findViewById(R.id.editIdDC);
        editNombreDC = (EditText) findViewById(R.id.editNombreDC);
        editFechaDC = (EditText) findViewById(R.id.editFechaDC);
        editNacionalidadDC = (EditText) findViewById(R.id.editNacionalidadDC);
        editSexoDC = (EditText) findViewById(R.id.editSexoDC);


        btnAgregarDC = (Button) findViewById(R.id.btnAgregarDC);
        btnMostrarDC = (Button) findViewById(R.id.btnMostrarDC);
        btnBuscarDC = (Button) findViewById(R.id.btnBuscarDC);
        btnEditarDC = (Button) findViewById(R.id.btnEditarDC);
        btnEliminarDC = (Button) findViewById(R.id.btnEliminarDC);

        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnAgregarDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.agregarDirector(

                        Integer.parseInt(editIdDC.getText().toString()),
                        editNombreDC.getText().toString(),
                        editFechaDC.getText().toString(),
                        editNacionalidadDC.getText().toString(),
                        editSexoDC.getText().toString()

                );

                Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();

            }
        });

        btnBuscarDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DirectorModelo directorModelo = new DirectorModelo();
                dbHelper.buscarDirectores(directorModelo,Integer.parseInt(editIdDC.getText().toString()));

                editNombreDC.setText(directorModelo.getNombre());
                editFechaDC.setText(directorModelo.getFecha());
                editNacionalidadDC.setText(directorModelo.getNacionalidad());
                editSexoDC.setText(directorModelo.getSexo());


            }
        });

        btnEditarDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.editarDirector(
                        Integer.parseInt(editIdDC.getText().toString()),
                        editNombreDC.getText().toString(),
                        editFechaDC.getText().toString(),
                        editNacionalidadDC.getText().toString(),
                        editSexoDC.getText().toString()

                );

                Toast.makeText(getApplicationContext(), "SE MODIFICÓ EL REGISTRO CORRECTAMENTE", Toast.LENGTH_LONG).show();
            }


        });

        btnMostrarDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarDirectores = new Intent(getApplicationContext(),DirectorActivity.class);
                startActivity(mostrarDirectores);
            }
        });


        btnEliminarDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHelper.eliminarDirector(Integer.parseInt(editIdDC.getText().toString()));


                Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                        " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();



            }
        });





    }
}



