package com.cmp.sqlite_proyect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private static final String NOMBRE_BD = "gestor.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_PELICULAS = "CREATE TABLE PELICULAS( ID_PELICULA INT AUTO_INCREMENT PRIMARY KEY, " +
            "    titulo TEXT NOT NULL,\n" +
            "    año_lanzamiento INTEGER NOT NULL,\n" +
            "    genero TEXT NOT NULL,\n" +
            "    duracion TEXT NOT NULL,\n" +
            "    presupuesto INTEGER NOT NULL,\n" +
            "    calificacion INTEGER NOT NULL\n" +
            ");)";

    public DbHelper(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_PELICULAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar la tabla existente
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PELICULAS);

        // Luego, crea la nueva tabla con la estructura actualizada
        onCreate(db);
    }



    public void agregarPelicula(String titulo, int anio , String genero, String duracion, int presupuesto, int calificacion){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("INSERT INTO Peliculas (titulo, año_lanzamiento, genero, duracion, presupuesto, calificacion) " +
                    "VALUES ('" + titulo + "', " + anio + ", '" + genero + "', '" + duracion + "', " + presupuesto + ", " + calificacion + ");");
        bd.close();
        }

    }

}

