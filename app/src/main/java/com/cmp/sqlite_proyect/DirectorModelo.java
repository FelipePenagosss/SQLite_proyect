package com.cmp.sqlite_proyect;

public class DirectorModelo {

    private String nombre, fecha,nacionalidad,sexo;
    private int id_director;

    public DirectorModelo() {
    }

    public DirectorModelo(int id_director,String nombre, String fecha, String nacionalidad, String sexo ){
        this.nombre = nombre;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.id_director = id_director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }
}
