package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PAAdaptador extends RecyclerView.Adapter<PAAdaptador.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id,id_pelicula,id_actor;

        public ViewHolder(View itemView){
            super(itemView);

            id = (TextView)  itemView.findViewById(R.id.txtIdParticipacionAC);
            id_pelicula = (TextView)  itemView.findViewById(R.id.txt_IdPeliculaPA);
            id_actor = (TextView)  itemView.findViewById(R.id.txt_IdActorPA);



        }




    }

    public List<PAModelo> paModeloLista;

    public PAAdaptador(List<PAModelo> paModeloLista){
        this.paModeloLista = paModeloLista;
    }

    @NonNull
    @Override
    public PAAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pa,parent,false);
        PAAdaptador.ViewHolder viewHolder = new PAAdaptador.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PAAdaptador.ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(paModeloLista.get(position).getId_participacion()));
        holder.id_pelicula.setText(String.valueOf(paModeloLista.get(position).getId_pelicula()));
        holder.id_actor.setText(String.valueOf(paModeloLista.get(position).getId_actor()));

    }

    @Override
    public int getItemCount() {
        return paModeloLista.size();
    }
}
