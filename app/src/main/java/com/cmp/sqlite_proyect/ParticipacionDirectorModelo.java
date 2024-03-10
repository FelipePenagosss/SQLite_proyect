package com.cmp.sqlite_proyect;

public class ParticipacionDirectorModelo {

    private int id_participacion,id_pelicula,id_director;

    public ParticipacionDirectorModelo() {
    }

    public ParticipacionDirectorModelo(int id_participacion, int id_pelicula, int id_director) {
        this.id_participacion = id_participacion;
        this.id_pelicula = id_pelicula;
        this.id_director = id_director;
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

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }
}
