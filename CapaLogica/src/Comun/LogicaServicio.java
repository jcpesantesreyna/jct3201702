package Comun;

import java.util.ArrayList;

import Entidades.Servicio;

public class LogicaServicio {

	public static LogicaServicio _Instancia;
	private LogicaServicio(){};
	public static LogicaServicio Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaServicio();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Servicio obtener(int idservicio) throws Exception{
		try {
			Servicio u =DaoServicio.Instancia().obtenerServicio(idservicio);
			if(u==null){
				throw new ArithmeticException("Servicio o PAssword no Validop");	
			}
			
			return u;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public ArrayList<Servicio> Listar() throws Exception{	
		try {
			return DaoServicio.Instancia().Listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean Insertar(String descripcion) throws Exception{	
		try {
			Servicio servicio =new Servicio();
			servicio.setDescripcion(descripcion);
			return DaoServicio.Instancia().Insertar(servicio);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean actualizar(int idservicio,String descripcion) throws Exception{	
		try {
			Servicio servicio =new Servicio();
			servicio.setDescripcion(descripcion);
			servicio.setIdservicio(idservicio);
			return DaoServicio.Instancia().actualizar(servicio);
		} catch (Exception e) {
			throw e;
		}
	}
	
}