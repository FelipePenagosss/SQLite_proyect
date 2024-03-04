package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculasAdaptador extends RecyclerView.Adapter<PeliculasAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, anio, genero,duracion,presupuesto,calificacion;
        public ViewHolder(View itemView){
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.txtTitulo);
            anio = (TextView) itemView.findViewById(R.id.txtAnio);
            genero = (TextView) itemView.findViewById(R.id.txtGenero);
            duracion = (TextView) itemView.findViewById(R.id.txtDuracion);
            presupuesto = (TextView) itemView.findViewById(R.id.txtPresupuesto);
            calificacion = (TextView) itemView.findViewById(R.id.txtCalificacion);


        }
    }

public List<PeliculasModelo> peliculasLista;


    public PeliculasAdaptador(List<PeliculasModelo> peliculasLista){
        this.peliculasLista =peliculasLista;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelicula,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(peliculasLista.get(position).getTitulo());
        holder.anio.setText(String.valueOf(peliculasLista.get(position).getAnio()));
        holder.genero.setText(peliculasLista.get(position).getGenero());
        holder.duracion.setText(peliculasLista.get(position).getDuracion());
        holder.presupuesto.setText(String.valueOf(peliculasLista.get(position).getPresupuesto()));
        holder.calificacion.setText(String.valueOf(peliculasLista.get(position).getCalificacion()));


    }

    @Override
    public int getItemCount() {
        return peliculasLista.size();
    }
}
