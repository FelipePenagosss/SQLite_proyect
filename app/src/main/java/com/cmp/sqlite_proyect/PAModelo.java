package com.cmp.sqlite_proyect;

public class PAModelo {

    private int id_participacion,id_pelicula,id_actor;


    public PAModelo() {
    }

    public PAModelo(int id_participacion, int id_pelicula, int id_actor) {
        this.id_participacion = id_participacion;
        this.id_pelicula = id_pelicula;
        this.id_actor = id_actor;
    }

    public int getId_participacion() {
        return id_participacion;
    }

    public void setId_participacion(int id_participacion) {
        this.id_participacion = id_participacion;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }
}
