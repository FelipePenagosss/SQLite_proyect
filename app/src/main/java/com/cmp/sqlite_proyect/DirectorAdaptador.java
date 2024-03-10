package com.cmp.sqlite_proyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DirectorAdaptador extends RecyclerView.Adapter<DirectorAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView id,nombre,fecha,nacionalidad,sexo;

        public ViewHolder(View itemView){
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.txtIDDC);
            nombre = (TextView) itemView.findViewById(R.id.txtNombreDC);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaDC);
            nacionalidad = (TextView) itemView.findViewById(R.id.txtNacionalidadDC);
            sexo = (TextView) itemView.findViewById(R.id.txtSexoDC);


        }


    }

    public List<DirectorModelo> directores;

    public  DirectorAdaptador(List<DirectorModelo> directores){
        this.directores = directores;
    }

    @NonNull
    @Override
    public DirectorAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_director,parent,false);
        DirectorAdaptador.ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorAdaptador.ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(directores.get(position).getId_director()));
        holder.nombre.setText(directores.get(position).getNombre());
        holder.fecha.setText(directores.get(position).getFecha());
        holder.nacionalidad.setText(directores.get(position).getNacionalidad());
        holder.sexo.setText(directores.get(position).getSexo());


    }

    @Override
    public int getItemCount() {
        return directores.size();
    }




}
