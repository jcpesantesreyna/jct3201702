package Comun;

import java.util.ArrayList;

import Entidades.Historia;

public class LogicaHistoria {
	public static LogicaHistoria _Instancia;
	private LogicaHistoria(){};
	public static LogicaHistoria Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaHistoria();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Historia obtener(int idHistoria) throws Exception{
		try {
			Historia Historia=DaoHistoria.Instancia().obtenerHistoria(idHistoria);
			if(Historia==null){
				throw new ArithmeticException("sin datos");	
			}
			
			return Historia;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public ArrayList<Historia> Listar() throws Exception{	
		try {
			return DaoHistoria.Instancia().Listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean Insertar(Historia historia) throws Exception{	
		try {
		
			
			return DaoHistoria.Instancia().Insertar(historia);
		} catch (Exception e) {
			throw e;
		}
	}
		public boolean actualizar(Historia historia) throws Exception{	
			try {
			
				
				return DaoHistoria.Instancia().update(historia);
			} catch (Exception e) {
				throw e;
			}
		}
	
	
	
}