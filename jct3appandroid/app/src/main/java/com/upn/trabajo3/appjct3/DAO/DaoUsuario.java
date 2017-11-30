package com.upn.trabajo3.appjct3.DAO;

import com.google.gson.Gson;
import com.upn.trabajo3.trabajoandroid.Modelo.Entidades.Usuario;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by marvin on 19/11/2017.
 */

public class DaoUsuario {
    public Usuario getUsuario(Usuario user) {
        JSONObject  row = null;
        StringBuilder sb = new StringBuilder();
        try {
            // String url = "http://69713.azurewebsites.net/CapaServicioRest/loginServices?nombre_usuario="+user.getNombre_usuario()+"&password="+user.getPassword();
            String url=DaoConexion.getUrl_base()+"login.php?sesion="+user.getSesion() +"&password="+user.getPassword();
            URL dir = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) dir.openConnection();
            urlConnection.setRequestMethod("GET");
            System.out.println("res: hola mundo "+url);
            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
               Gson gson=new Gson();
               String json=in.readLine();
                System.out.println("lineaa  "+json);
                Usuario usuario=gson.fromJson(json, Usuario.class);

                return usuario;


            } finally {
                urlConnection.disconnect();
            }
        }catch (Exception ex){}
        return  null;
    }
}
