package com.upn.trabajo3.appjct3.Controlador;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.upn.trabajo3.appjct3.DAO.DaoCita;
import com.upn.trabajo3.appjct3.Entidades.Cita;
import com.upn.trabajo3.appjct3.Entidades.Item;
import com.upn.trabajo3.appjct3.ItemReciclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by marvin on 24/11/2017.
 */

public class ConsultarItemsController extends AsyncTask<String, Integer, ArrayList<Cita>> {


    Context contexto;

    int idresponsable;

    RecyclerView recyclerView;
    // context.startActivity(new Intent(context, ComandaActivity.class));

    public void setDatos(Context contexto, RecyclerView recyclerView, int idresponsable) {
        this.contexto = contexto;
        this.recyclerView = recyclerView;
        this.idresponsable = idresponsable;


    }

    @Override
    protected void onPreExecute() {

        //   Toast.makeText(contexto,"Cargando...",Toast.LENGTH_SHORT).show();

        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<Cita> lista) {

        try {

            if (lista == null) {
                Toast.makeText(contexto, "Sin datos", Toast.LENGTH_LONG).show();

            } else {

                //    Toast.makeText(contexto,"ItemComanda "+  lista.get(1).getNumero() ,Toast.LENGTH_LONG).show();

                final ItemReciclerViewAdapter ItemComandar = new ItemReciclerViewAdapter(contexto, lista);

                recyclerView.setAdapter(ItemComandar);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ArrayList<Cita> doInBackground(String... params) {
        //
        DaoCita itemdao = new DaoCita();
        return itemdao.getDetalle(this.idresponsable);
    }
}

