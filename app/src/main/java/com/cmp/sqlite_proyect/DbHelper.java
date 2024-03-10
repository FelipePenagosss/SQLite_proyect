package com.cmp.sqlite_proyect;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {


    private static final String NOMBRE_BD = "gestor.db";
    private static final int VERSION_BD = 2;
    private static final String TABLA_PELICULAS = "CREATE TABLE PELICULAS (" +
            "Id_pelicula INTEGER PRIMARY KEY, " +
            "titulo TEXT NOT NULL, " +
            "año_lanzamiento INTEGER NOT NULL, " +
            "genero TEXT NOT NULL, " +
            "duracion TEXT NOT NULL, " +
            "presupuesto INTEGER NOT NULL, " +
            "calificacion INTEGER NOT NULL " +
            ");";

    private static final String TABLA_ACTOR = "CREATE TABLE ACTOR (" +
            "id_actor INTEGER PRIMARY KEY, " +
            "nombre TEXT NOT NULL,"+
            "fecha_nacimiento TEXT NOT NULL, " +
            "nacionalidad TEXT NOT NULL, " +
            "sexo TEXT NOT NULL, " +
            "id_tipo_actor INTEGER NOT NULL, " +
            "FOREIGN KEY (id_tipo_actor) REFERENCES TIPO_ACTOR(id_tipo_actor)" +
            ");";

    private static final String TABLA_TIPO_ACTOR = "CREATE TABLE IF NOT EXISTS TIPO_ACTOR (" +
            "id_tipo_actor INTEGER PRIMARY KEY, " +
            "nombre TEXT NOT NULL" +
            ");";


    private static final String TABLA_PREMIO = "CREATE TABLE PREMIO (" +
            "id_premio INTEGER PRIMARY KEY, " +
            "nombre TEXT NOT NULL, " +
            "categoria TEXT NOT NULL, " +
            "año INTEGER NOT NULL, " +
            "Id_pelicula INTEGER, " +  // Clave foránea
            "FOREIGN KEY (Id_pelicula) REFERENCES PELICULAS(Id_pelicula)" +
            ");";

    private static final String TABLA_GANADOR_PREMIO = "CREATE TABLE GANADOR_PREMIO (" +
            "id_ganador INTEGER PRIMARY KEY, " +
            "id_pelicula INTEGER NOT NULL, " +
            "id_premio INTEGER NOT NULL, " +
            "FOREIGN KEY (id_pelicula) REFERENCES PELICULAS(Id_pelicula), " +
            "FOREIGN KEY (id_premio) REFERENCES PREMIO(id_premio)" +
            ");";







    public DbHelper(@Nullable Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_PELICULAS);
        db.execSQL(TABLA_ACTOR);
        db.execSQL(TABLA_TIPO_ACTOR);
        db.execSQL(TABLA_PREMIO);
        db.execSQL(TABLA_GANADOR_PREMIO);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar la tabla existente
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PELICULAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ACTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_TIPO_ACTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PREMIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_GANADOR_PREMIO);

        // Luego, crea la nueva tabla con la estructura actualizada
        onCreate(db);
    }



    public void agregarPelicula(int Id_pelicula,String titulo, int anio , String genero, String duracion, int presupuesto, int calificacion){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("INSERT INTO PELICULAS (Id_pelicula, titulo, año_lanzamiento, genero, duracion, presupuesto, calificacion) " +
                    "VALUES (" + Id_pelicula + ", '" + titulo + "', " + anio + ", '" + genero + "', '" + duracion + "', " + presupuesto + ", " + calificacion + ");");
            bd.close();

        }

    }

    public List<PeliculasModelo> mostrarPeliculas(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PELICULAS",null);
        List<PeliculasModelo> peliculas = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                peliculas.add(new PeliculasModelo(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5),cursor.getInt(6)));
            }while (cursor.moveToNext());
        }
        return peliculas;
    }

    public void buscarPelicula(PeliculasModelo peliculasModelo, int ID){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PELICULAS WHERE Id_pelicula ="+ ID ,null);


        if(cursor.moveToFirst()) {
        do {

            peliculasModelo.setTitulo(cursor.getString(1));
            peliculasModelo.setAnio(cursor.getInt(2));
            peliculasModelo.setGenero(cursor.getString(3));
            peliculasModelo.setDuracion(cursor.getString(4));
            peliculasModelo.setPresupuesto(cursor.getInt(5));
            peliculasModelo.setCalificacion(cursor.getInt(6));





        }while (cursor.moveToNext());
        }
    }

    public void editarPelicula(int Id_pelicula,String titulo, int anio , String genero, String duracion, int presupuesto, int calificacion){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("UPDATE PELICULAS SET titulo='" + titulo + "', año_lanzamiento=" + anio + ", genero='" + genero + "', duracion='" + duracion + "', presupuesto=" + presupuesto + ", calificacion=" + calificacion + " WHERE Id_pelicula=" + Id_pelicula);
            bd.close();

        }

    }

    public void eliminarPelicula(int Id_pelicula){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("DELETE FROM PELICULAS WHERE Id_pelicula=" + Id_pelicula);
            bd.close();

        }

    }

    public void agregarTipoActor(int id_tipo_actor,String nombre){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("INSERT INTO TIPO_ACTOR (id_tipo_actor, nombre) " +
                    "VALUES (" + id_tipo_actor + ", '" + nombre + "' " + ");");
            bd.close();

        }

    }

    public List<TipoActorModelo> mostrarTipoActores(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM TIPO_ACTOR",null);
        List<TipoActorModelo> tiposActor = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                tiposActor.add(new TipoActorModelo(cursor.getInt(0),cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return tiposActor;
    }


    public void buscarTipoActor(TipoActorModelo tipoActorModeloModelo, int ID){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM TIPO_ACTOR WHERE id_tipo_actor ="+ ID ,null);


        if(cursor.moveToFirst()) {
            do {

                tipoActorModeloModelo.setNombre(cursor.getString(1));


            }while (cursor.moveToNext());
        }
    }


    public void editarTipoActor(int id_tipo_actor,String nombre){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("UPDATE TIPO_ACTOR SET nombre='" + nombre + " WHERE id_tipo_actor=" + id_tipo_actor);

            bd.close();

        }

    }

    public void eliminarTipoActor(int id_tipo_actor){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("DELETE FROM TIPO_ACTOR WHERE id_tipo_actor=" + id_tipo_actor);
            bd.close();

        }

    }

    public void agregarActor(int id_actor,String nombre, String fecha_nacimiento , String nacionalidad, String sexo, int id_tipo_actor){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("INSERT INTO ACTOR (id_actor, nombre, fecha_nacimiento, nacionalidad, sexo, id_tipo_actor) " +
                    "VALUES (" + id_actor + ", '" + nombre + "', '" + fecha_nacimiento + "', '" + nacionalidad + "', '" + sexo + "', " + id_tipo_actor + ");");
            bd.close();

        }

    }

    public List<ActorModelo> mostrarActores(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM ACTOR",null);
        List<ActorModelo> actores = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                actores.add(new ActorModelo(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5)));
            }while (cursor.moveToNext());
        }
        return actores;
    }

    public void buscarActor(ActorModelo actorModelo, int ID){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM ACTOR WHERE id_actor ="+ ID ,null);


        if(cursor.moveToFirst()) {
            do {

                actorModelo.setNombre(cursor.getString(1));
                actorModelo.setFecha(cursor.getString(2));
                actorModelo.setNacionalidad(cursor.getString(3));
                actorModelo.setSexo(cursor.getString(4));
                actorModelo.setId_tipo_actor(cursor.getInt(5));


            }while (cursor.moveToNext());
        }
    }

    public void editarActor(int id_actor, String nombre, String fecha_nacimiento, String nacionalidad, String sexo, int id_tipo_actor) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("UPDATE ACTOR SET nombre='" + nombre + "', fecha_nacimiento='" + fecha_nacimiento + "', nacionalidad='" + nacionalidad + "', sexo='" + sexo + "', id_tipo_actor=" + id_tipo_actor + " WHERE id_actor=" + id_actor);
            bd.close();
        }
    }

    public void eliminarActor(int id_actor){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("DELETE FROM ACTOR WHERE id_actor=" + id_actor);
            bd.close();

        }

    }

    public void agregarPremio(int id_premio,String nombre, String categoria , int anio, int Id_pelicula){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){

            bd.execSQL("INSERT INTO PREMIO (id_premio, nombre, categoria, año, Id_pelicula) " +
                    "VALUES (" + id_premio + ", '" + nombre + "', '" + categoria + "', " + anio + ", " + Id_pelicula + ");");
            bd.close();


        }

    }

    public List<PremioModelo> mostrarPremios(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PREMIO",null);
        List<PremioModelo> premios = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                premios.add(new PremioModelo(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4)));
            }while (cursor.moveToNext());
        }
        return premios;
    }


    public void buscarPremio(PremioModelo premioModelo, int ID){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM PREMIO WHERE id_premio ="+ ID ,null);


        if(cursor.moveToFirst()) {
            do {

                premioModelo.setNombre(cursor.getString(1));
                premioModelo.setCategoria(cursor.getString(2));
                premioModelo.setAnio(cursor.getInt(3));
                premioModelo.setId_peliculaPr(cursor.getInt(4));


            }while (cursor.moveToNext());
        }
    }

    public void editarPremio(int id_premio,String nombre, String categoria , int anio, int Id_pelicula) {
        SQLiteDatabase bd = getWritableDatabase();
        if (bd != null) {
            bd.execSQL("UPDATE PREMIO SET nombre='" + nombre + "', categoria='" + categoria + "', año=" + anio + ", Id_pelicula=" + Id_pelicula + " WHERE id_premio=" + id_premio);
            bd.close();
        }
    }


    public void eliminarPremio(int id_premio){

        SQLiteDatabase bd = getWritableDatabase();
        if (bd!= null){
            bd.execSQL("DELETE FROM PREMIO WHERE id_premio=" + id_premio);
            bd.close();

        }

    }


















}

