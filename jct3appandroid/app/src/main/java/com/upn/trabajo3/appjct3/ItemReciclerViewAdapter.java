package com.upn.trabajo3.appjct3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.upn.trabajo3.appjct3.Entidades.Cita;
import com.upn.trabajo3.appjct3.Entidades.Item;


import java.util.ArrayList;

/**
 * Created by marvin on 26/11/2017.
 */

public class ItemReciclerViewAdapter extends RecyclerView.Adapter<ItemReciclerViewAdapter.ViewHolder>
{
    private ArrayList<Cita> lista;
    Context contexto;
    public ItemReciclerViewAdapter(Context contesxt, ArrayList<Cita> listita){
        this.lista = listita;
        this.contexto = contesxt;
    }
    @Override
    public ItemReciclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemReciclerViewAdapter.ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ItemReciclerViewAdapter.ViewHolder holder, int position) {
        try {
            final Cita item=lista.get(position);
            TextView lblnombres = holder.view.findViewById(R.id.lblnombres);
            TextView lblservicio=holder.view.findViewById(R.id.lblservicio);
            TextView lblFecha=holder.view.findViewById(R.id.lblfecha);

         //   System.out.println("lineaa  "+item.getIdmesa());

            //imgArticulo.setImageDrawable(R.drawable.ic_launcher_foreground);

            lblnombres.setText(item.getHistoria().getApepat()+" "+item.getHistoria().getApemat()+" "+item.getHistoria().getNombres() );
            lblFecha.setText(""+item.getFecha());
            lblservicio.setText(item.getProgramacion().getServicio().getDescripcion());



        }catch(Exception e){}
    }
    @Override
    public int getItemCount() {
         return (lista == null) ? 0 : lista.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        LinearLayout fondo;
        Button boton;
        EditText cantidad;
        public ViewHolder(View v) {
            super(v);
            view = v;
            //  fondo=(LinearLayout) v.findViewById(R.id.ll_cuerpo);


        }
    }
}
