package Comun;

import java.util.ArrayList;

import Entidades.Programacion;

public class LogicaProgramacion {
	public static LogicaProgramacion _Instancia;
	private LogicaProgramacion(){};
	public static LogicaProgramacion Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaProgramacion();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Programacion obtener(int idProgramacion) throws Exception{
		try {
			Programacion Programacion=DaoProgramacion.Instancia().obtenerProgramacion(idProgramacion);
			if(Programacion==null){
				throw new ArithmeticException("sin datos");	
			}
			
			return Programacion;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public ArrayList<Programacion> Listar(int idservicio,String turno) throws Exception{	
		try {
			return DaoProgramacion.Instancia().Listar(idservicio,turno);
		} catch (Exception e) {
			throw e;
		}
	}
	public ArrayList<Programacion> Listar() throws Exception{	
		try {
			return DaoProgramacion.Instancia().Listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean Insertar(Programacion Programacion) throws Exception{	
		try {
		
			
			return DaoProgramacion.Instancia().Insertar(Programacion);
		} catch (Exception e) {
			throw e;
		}
	}
		public boolean actualizar(Programacion Programacion) throws Exception{	
			try {
			
				
				return DaoProgramacion.Instancia().update(Programacion);
			} catch (Exception e) {
				throw e;
			}
		}
	
	
	
}