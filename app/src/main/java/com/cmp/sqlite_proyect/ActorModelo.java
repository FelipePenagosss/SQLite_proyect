package com.cmp.sqlite_proyect;

public class ActorModelo {
    private String nombre, fecha,nacionalidad,sexo;
    private int id_actor, id_tipo_actor;

    public ActorModelo() {
    }

    public ActorModelo(int id_actor,String nombre, String fecha, String nacionalidad, String sexo, int id_tipo_actor) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.id_actor = id_actor;
        this.id_tipo_actor = id_tipo_actor;
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

    public int getId_actor() {
        return id_actor;
    }

    public void setId_actor(int id_actor) {
        this.id_actor = id_actor;
    }

    public int getId_tipo_actor() {
        return id_tipo_actor;
    }

    public void setId_tipo_actor(int id_tipo_actor) {
        this.id_tipo_actor = id_tipo_actor;
    }
}
