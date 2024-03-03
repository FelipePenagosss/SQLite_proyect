 package com.cmp.sqlite_proyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {

    EditText editTitulo, editAnio,editGenero,editDuracion,editPresupuesto,editCalificacion ;
    Button btnAgregar;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         editTitulo = (EditText) findViewById(R.id.editTitulo);
         editAnio = (EditText) findViewById(R.id.editAnio);
         editGenero = (EditText) findViewById(R.id.editGenero);
         editDuracion = (EditText) findViewById(R.id.editDuracion);
         editPresupuesto = (EditText) findViewById(R.id.editPresupuesto);
         editCalificacion = (EditText) findViewById(R.id.editCalificacion);

         // Inicializa el botón btnAgregar
         btnAgregar = (Button) findViewById(R.id.btnAgregar);

         final DbHelper dbHelper = new DbHelper(getApplicationContext());

         btnAgregar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 dbHelper.agregarPelicula(
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
     }

 }