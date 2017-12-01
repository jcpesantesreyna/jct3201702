package com.upn.trabajo3.appjct3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.upn.trabajo3.appjct3.Controlador.ConsultarItemsController;
import com.upn.trabajo3.appjct3.Utilidades.Global;

public class ReporteActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    EditText txtBuscar;
    Button consultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);


        recyclerViewItems();
   //     listar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void recyclerViewItems() {
        recyclerView = (RecyclerView) this.findViewById(R.id.rvlista);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());




    }
    private  void listar()

    {
        ConsultarItemsController consultarItemsController=new ConsultarItemsController();
        Global.Instancia().setTipo("BE");
        consultarItemsController.setDatos(getApplicationContext(),recyclerView,Global.Instancia().getIdmesa());
        consultarItemsController.execute();

    }
}
