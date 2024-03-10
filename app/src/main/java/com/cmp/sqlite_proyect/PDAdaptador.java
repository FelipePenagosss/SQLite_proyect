package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PDAdaptador extends RecyclerView.Adapter<PDAdaptador.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id,id_pelicula,id_director;

        public ViewHolder(View itemView){
            super(itemView);

            id = (TextView)  itemView.findViewById(R.id.txtIdParticipacion);
            id_pelicula = (TextView)  itemView.findViewById(R.id.txt_IdPeliculaPD);
            id_director = (TextView)  itemView.findViewById(R.id.txt_IdDirectorPD);



        }




    }

    public List<ParticipacionDirectorModelo> participacionDirectorModeloLista;

    public PDAdaptador(List<ParticipacionDirectorModelo> participacionDirectorModeloLista){
        this.participacionDirectorModeloLista = participacionDirectorModeloLista;
    }

    @NonNull
    @Override
    public PDAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pd,parent,false);
        PDAdaptador.ViewHolder viewHolder = new PDAdaptador.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PDAdaptador.ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(participacionDirectorModeloLista.get(position).getId_participacion()));
        holder.id_pelicula.setText(String.valueOf(participacionDirectorModeloLista.get(position).getId_pelicula()));
        holder.id_director.setText(String.valueOf(participacionDirectorModeloLista.get(position).getId_director()));




    }

    @Override
    public int getItemCount() {
        return participacionDirectorModeloLista.size();
    }
}
