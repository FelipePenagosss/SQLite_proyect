package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TipoActorAdaptador extends RecyclerView.Adapter<TipoActorAdaptador.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id,nombre;

        public ViewHolder(View itemView){
            super(itemView);

            id = (TextView)  itemView.findViewById(R.id.txtIdTipoActor);
            nombre = (TextView) itemView.findViewById(R.id.txtNombreTipo);

        }




    }

    public List<TipoActorModelo> tipoActorLista;

    public TipoActorAdaptador(List<TipoActorModelo> tipoActorLista){
        this.tipoActorLista = tipoActorLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tipo_actor,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(tipoActorLista.get(position).getId()));
        holder.nombre.setText(tipoActorLista.get(position).getNombre());



    }

    @Override
    public int getItemCount() {
        return tipoActorLista.size();
    }
}
