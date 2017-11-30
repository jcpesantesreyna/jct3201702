package Comun;

import java.util.ArrayList;

import Entidades.Cita;

public class LogicaCita {
	public static LogicaCita _Instancia;
	private LogicaCita(){};
	public static LogicaCita Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaCita();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Cita obtener(int idCita) throws Exception{
		try {
			Cita Cita=DaoCita.Instancia().obtenerCita(idCita);
			if(Cita==null){
				throw new ArithmeticException("sin datos");	
			}
			
			return Cita;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public ArrayList<Cita> Listar(int idresponsable) throws Exception{	
		try {
			return DaoCita.Instancia().Listar(idresponsable);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean Insertar(Cita Cita) throws Exception{	
		try {
		
			
			return DaoCita.Instancia().Insertar(Cita);
		} catch (Exception e) {
			throw e;
		}
	}
		public boolean actualizar(Cita Cita) throws Exception{	
			try {
			
				
				return DaoCita.Instancia().update(Cita);
			} catch (Exception e) {
				throw e;
			}
		}
	
	
	
}