package com.cmp.sqlite_proyect;

public class PremioModelo {

    private  String nombre,categoria;
    private int id_premio, id_peliculaPr,anio;

    public PremioModelo() {
    }

    public PremioModelo(int id_premio,String nombre, String categoria, int anio, int id_peliculaPr) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.anio = anio;
        this.id_premio = id_premio;
        this.id_peliculaPr = id_peliculaPr;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }



    public int getId_premio() {
        return id_premio;
    }

    public void setId_premio(int id_premio) {
        this.id_premio = id_premio;
    }

    public int getId_peliculaPr() {
        return id_peliculaPr;
    }

    public void setId_peliculaPr(int id_peliculaPr) {
        this.id_peliculaPr = id_peliculaPr;
    }
}
