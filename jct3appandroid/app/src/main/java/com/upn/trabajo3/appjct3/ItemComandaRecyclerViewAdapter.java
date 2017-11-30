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

import com.upn.trabajo3.appjct3.Entidades.Item;
import com.upn.trabajo3.trabajoandroid.Modelo.Entidades.Comanda;

import java.util.ArrayList;

/**
 * Created by marvin on 26/11/2017.
 */

public class ItemComandaRecyclerViewAdapter extends RecyclerView.Adapter<ItemComandaRecyclerViewAdapter.ViewHolder>
{
    private ArrayList<Item> lista;
    Context contexto;
    public ItemComandaRecyclerViewAdapter(Context contesxt, ArrayList<Item> listita){
        this.lista = listita;
        this.contexto = contesxt;
    }
    @Override
    public ItemComandaRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_reporte, parent, false);
        return new ItemComandaRecyclerViewAdapter.ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ItemComandaRecyclerViewAdapter.ViewHolder holder, int position) {
        try {
            final Item item=lista.get(position);
            /*TextView lblid = holder.view.findViewById(R.id.idcomandaitem);
            TextView lblmonto=holder.view.findViewById(R.id.idmontocomanda);
            TextView lblFecha=holder.view.findViewById(R.id.lblfecha_reporte);*/

         //   System.out.println("lineaa  "+item.getIdmesa());

            //imgArticulo.setImageDrawable(R.drawable.ic_launcher_foreground);

        /*    lblid.setText(""+(item.getIdmesa()));
            lblFecha.setText(item.getFecha_registro());
            lblmonto.setText(String.valueOf(lista.get(position).getTotal()));
*/


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
