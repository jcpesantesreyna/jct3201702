package com.upn.trabajo3.appjct3.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upn.trabajo3.appjct3.Entidades.Cita;
import com.upn.trabajo3.appjct3.Entidades.Item;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by marvin on 19/11/2017.
 */

public class DaoCita {
    public ArrayList<Cita> getDetalle(int idresponsable) {
        JSONObject row = null;
        StringBuilder sb = new StringBuilder();
        try {
            // String url = "http://69713.azurewebsites.net/CapaServicioRest/loginServices?nombre_usuario="+user.getNombre_usuario()+"&password="+user.getPassword();
            String url=DaoConexion.getUrl_base()+"ListaCita.php?idresponsable="+idresponsable;
            URL dir = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) dir.openConnection();
            urlConnection.setRequestMethod("GET");
            System.out.println("res: hola mundo "+url);
            try {

                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                Gson gson=new Gson();
                String json=in.readLine();
                System.out.println("lineaa  "+json);
                Type listaTypo = new TypeToken<ArrayList<Cita>>(){}.getType();
                ArrayList<Cita> lista=gson.fromJson(json,listaTypo);

                return lista;


            } finally {
                urlConnection.disconnect();
            }
        }catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return  null;
    }
}
