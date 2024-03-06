package com.cmp.sqlite_proyect;

public class TipoActorModelo {


    private String nombre;
    private int id;

    public TipoActorModelo() {
    }

    public TipoActorModelo(int id,String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
