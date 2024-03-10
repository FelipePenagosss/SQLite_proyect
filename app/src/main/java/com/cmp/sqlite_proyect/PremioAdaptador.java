package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PremioAdaptador extends RecyclerView.Adapter<PremioAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id_premio, nombre, categoria, anio, id_pelicula ;

        public ViewHolder(View itemView){
            super(itemView);

            id_premio = (TextView) itemView.findViewById(R.id.txtIdPR);
            nombre = (TextView) itemView.findViewById(R.id.txtNombrePR);
            categoria = (TextView) itemView.findViewById(R.id.txtCategoriaPR);
            anio = (TextView) itemView.findViewById(R.id.txtAnioPR);
            id_pelicula = (TextView) itemView.findViewById(R.id.txtIdpeliculaPR);
        }

    }

    public List<PremioModelo> premiosLista;


    public PremioAdaptador(List<PremioModelo> premiosLista){
        this.premiosLista = premiosLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_premio,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id_premio.setText(String.valueOf(premiosLista.get(position).getId_premio()));
        holder.nombre.setText(premiosLista.get(position).getNombre());
        holder.categoria.setText(premiosLista.get(position).getCategoria());
        holder.anio.setText(String.valueOf(premiosLista.get(position).getAnio()));
        holder.id_pelicula.setText(String.valueOf(premiosLista.get(position).getId_peliculaPr()));

    }

    @Override
    public int getItemCount() {
        return premiosLista.size();
    }
}
