package Comun;

import java.util.ArrayList;

import Entidades.EntOrdenTrabajo;


public class LogicaOrdenTrabajo {

	public static LogicaOrdenTrabajo _Instancia;
	private LogicaOrdenTrabajo(){};
	public static LogicaOrdenTrabajo Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaOrdenTrabajo();
		}
		return _Instancia;
	}
	//endSingleton
	
	
	
	public ArrayList<EntOrdenTrabajo> Listar(int idusuario) throws Exception{	
		try {
			return DaoOrdenTrabajo.Instancia().Listar(idusuario);
		} catch (Exception e) {
			throw e;
		}
	}
	public ArrayList<EntOrdenTrabajo> Listar() throws Exception{	
		try {
			return DaoOrdenTrabajo.Instancia().Listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public boolean Insertar(EntOrdenTrabajo OT) throws Exception{	
		try {
			return DaoOrdenTrabajo.Instancia().Insertar(OT);
		} catch (Exception e) {
			throw e;
		}
	}
	public boolean procesar(int id) throws Exception{	
		try {
			return DaoOrdenTrabajo.Instancia().Procesar(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public EntOrdenTrabajo Devolver(int id)throws Exception{
	
		try {
			return DaoOrdenTrabajo.Instancia().Devolver(id);
		} catch (Exception e) {
			throw e;
		}
	}

}