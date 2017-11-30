package com.upn.trabajo3.appjct3.Utilidades;

/**
 * Created by marvin on 19/11/2017.
 */

public class Global {
    private static Global _instancia;
    private String UserName;
    private int idUsuario;
    private int idmesa;

    public double getTotalComanda() {
        return TotalComanda;
    }

    public void setTotalComanda(double totalComanda) {
        TotalComanda = totalComanda;
    }

    private  double TotalComanda;

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    private  String tipousuario;
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private  String tipo;
    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public String getCodigomesa() {
        return codigomesa;
    }

    public void setCodigomesa(String codigomesa) {
        this.codigomesa = codigomesa;
    }

    private  String codigomesa;

    public String getEstadomesa() {
        return estadomesa;
    }

    public void setEstadomesa(String estadomesa) {
        this.estadomesa = estadomesa;
    }

    private String estadomesa;
    public static synchronized Global Instancia(){
        if(_instancia==null){
            _instancia = new Global();
        }
        return _instancia;
    }
    private Global(){}

    public String getUserName() {return UserName;}

    public void setUserName(String userName) {UserName = userName;}

    public int getIdUsuario() {return idUsuario;}

    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}

}
