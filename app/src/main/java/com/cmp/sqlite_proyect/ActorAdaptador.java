package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActorAdaptador extends RecyclerView.Adapter<ActorAdaptador.ViewHolder> {



    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id,nombre,fecha,nacionalidad,sexo,id_tipo;

        public ViewHolder(View itemView){
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.txtIDAC);
            nombre = (TextView) itemView.findViewById(R.id.txtNombreAC);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaAC);
            nacionalidad = (TextView) itemView.findViewById(R.id.txtNacionalidadAC);            id = (TextView) itemView.findViewById(R.id.txtIDAC);
            sexo = (TextView) itemView.findViewById(R.id.txtSexoAC);
            id_tipo = (TextView) itemView.findViewById(R.id.txtTipoAC);


        }


    }

    public List<ActorModelo> actores;

    public  ActorAdaptador(List<ActorModelo> actores){
        this.actores = actores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actor,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(actores.get(position).getId_actor()));
        holder.nombre.setText(actores.get(position).getNombre());
        holder.fecha.setText(actores.get(position).getFecha());
        holder.nacionalidad.setText(actores.get(position).getNacionalidad());
        holder.sexo.setText(actores.get(position).getSexo());
        holder.id_tipo.setText(String.valueOf(actores.get(position).getId_tipo_actor()));

    }

    @Override
    public int getItemCount() {
        return actores.size();
    }
}
