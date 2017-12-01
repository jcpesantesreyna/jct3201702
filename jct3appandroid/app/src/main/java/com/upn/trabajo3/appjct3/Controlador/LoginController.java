package com.upn.trabajo3.appjct3.Controlador;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.upn.trabajo3.appjct3.Entidades.Usuario;
import com.upn.trabajo3.appjct3.DAO.DaoUsuario;
import com.upn.trabajo3.appjct3.LoginActivity;
import com.upn.trabajo3.appjct3.ReporteActivity;
import com.upn.trabajo3.appjct3.Utilidades.Global;
/**
 * Created by marvin on 19/11/2017.
 */

public class LoginController extends AsyncTask<String, Integer, Usuario> {

    ProgressDialog dialog;
    Context contexto;
    Usuario usuario;
    Activity sesion;
    public void setDatos(Context contexto,Usuario usuario,LoginActivity sesion)
    {
        this.contexto=contexto;
        this.sesion=sesion;
        this.usuario=usuario;
    }
    @Override
    protected void onPreExecute() {

        Toast.makeText(contexto,"Cargandpo",Toast.LENGTH_LONG).show();

        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(Usuario usuario) {

        try {

            if(usuario==null){
                Toast.makeText(contexto,"Datos incorrectos",Toast.LENGTH_LONG).show();

            }else{
                String nom =usuario.getSesion();
               // SharedPreferences sharedpreferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
               // SharedPreferences.Editor edit = sharedpreferences.edit();
             //   edit.putString("user",nom);
               // edit.commit();
                Global.Instancia().setIdUsuario(usuario.getIdusuario());
                Global.Instancia().setUserName(usuario.getSesion());
                Global.Instancia().setTipousuario(usuario.getRol());
                Global.Instancia().setIdmesa(usuario.getIdresponsable());
                Toast.makeText(contexto,"Ingresando... "+nom,Toast.LENGTH_LONG).show();


                //envio.putExtra("usu",nom);

                    Intent intent = new Intent(sesion, ReporteActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    sesion.getApplicationContext().startActivity(intent);
                    sesion.finish();



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Usuario doInBackground(String... params) {
        DaoUsuario con = new DaoUsuario();
        return  con.getUsuario(usuario);
    }
}
