package Comun;

import java.util.ArrayList;

import Entidades.Responsable;

public class LogicaResponsable {
	public static LogicaResponsable _Instancia;
	private LogicaResponsable(){};
	public static LogicaResponsable Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaResponsable();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Responsable obtener(int idResponsable) throws Exception{
		try {
			Responsable responsable=DaoResponsable.Instancia().obtenerResponsable(idResponsable);
			if(responsable==null){
				throw new ArithmeticException("sin datos");	
			}
			
			return responsable;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public ArrayList<Responsable> Listar() throws Exception{	
		try {
			return DaoResponsable.Instancia().Listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean Insertar(String descripcion) throws Exception{	
		try {
			Responsable Responsable =new Responsable();
			Responsable.setDescripcion(descripcion);
			return DaoResponsable.Instancia().Insertar(Responsable);
		} catch (Exception e) {
			throw e;
		}
	}
	public boolean actualizar(Integer id,String descripcion) throws Exception{	
		try {
			Responsable Responsable =new Responsable();
			Responsable.setDescripcion(descripcion);
			Responsable.setIdresposanble(id);
			return DaoResponsable.Instancia().update(Responsable);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}