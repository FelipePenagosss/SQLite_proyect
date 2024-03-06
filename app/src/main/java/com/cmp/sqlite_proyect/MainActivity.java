 package com.cmp.sqlite_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    EditText editId, editTitulo, editAnio,editGenero,editDuracion,editPresupuesto,editCalificacion ;
    Button btnAgregar,btnMostrar,btnBuscar, btnEditar, btnEliminar;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         editId = (EditText) findViewById(R.id.editId);
         editTitulo = (EditText) findViewById(R.id.editTitulo);
         editAnio = (EditText) findViewById(R.id.editAnio);
         editGenero = (EditText) findViewById(R.id.editGenero);
         editDuracion = (EditText) findViewById(R.id.editDuracion);
         editPresupuesto = (EditText) findViewById(R.id.editPresupuesto);
         editCalificacion = (EditText) findViewById(R.id.editCalificacion);

         // Inicializa el botón btnAgregar
         btnAgregar = (Button) findViewById(R.id.btnAgregar);
         btnMostrar = (Button) findViewById(R.id.btnMostrar);
         btnBuscar = (Button) findViewById(R.id.btnBuscar);
         btnEditar = (Button) findViewById(R.id.btnEditar);
         btnEliminar = (Button) findViewById(R.id.btnEliminar);


         final DbHelper dbHelper = new DbHelper(getApplicationContext());

         btnAgregar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dbHelper.agregarPelicula(

                         Integer.parseInt(editId.getText().toString()),
                         editTitulo.getText().toString(),
                         Integer.parseInt(editAnio.getText().toString()),
                         editGenero.getText().toString(),
                         editDuracion.getText().toString(),
                         Integer.parseInt(editPresupuesto.getText().toString()),
                         Integer.parseInt(editCalificacion.getText().toString())
                 );

                 Toast.makeText(getApplicationContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();
             }
         });

         btnMostrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent mostrarPeliculas = new Intent(getApplicationContext(), PeliculasActivity.class);
                 startActivity(mostrarPeliculas);
             }
         });

         btnBuscar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PeliculasModelo peliculasModelo = new PeliculasModelo();
                 dbHelper.buscarPelicula(peliculasModelo,Integer.parseInt(editId.getText().toString()));

                 editTitulo.setText(peliculasModelo.getTitulo());
                 editAnio.setText(String.valueOf(peliculasModelo.getAnio()));
                 editGenero.setText(peliculasModelo.getGenero());
                 editDuracion.setText(peliculasModelo.getDuracion());
                 editPresupuesto.setText(String.valueOf(peliculasModelo.getPresupuesto()));
                 editCalificacion.setText(String.valueOf(peliculasModelo.getCalificacion()));



             }
         });


         btnEditar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 dbHelper.editarPelicula(Integer.parseInt(editId.getText().toString()),
                         editTitulo.getText().toString(),
                         Integer.parseInt(editAnio.getText().toString()),
                         editGenero.getText().toString(),
                         editDuracion.getText().toString(),
                         Integer.parseInt(editPresupuesto.getText().toString()),
                         Integer.parseInt(editCalificacion.getText().toString()));


                 Toast.makeText(getApplicationContext(),"SE MODIFICO EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();



             }
         });


         btnEliminar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 dbHelper.eliminarPelicula(Integer.parseInt(editId.getText().toString()));


                 Toast.makeText(getApplicationContext(),"SE ELIMINO" +
                         " EL REGISTRO CORRECTAMENTE",Toast.LENGTH_LONG).show();



             }
         });


     }

 }