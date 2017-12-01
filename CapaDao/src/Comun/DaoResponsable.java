package Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Responsable;

public class DaoResponsable {
	public static DaoResponsable _Instancia;
	private DaoResponsable(){};
	public static DaoResponsable Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoResponsable();
		}
		return _Instancia;
	}
	public boolean Insertar(Responsable Responsable) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_insertar_Responsable(?)}");
			cst.setString(1,Responsable.getDescripcion());
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public boolean update(Responsable Responsable) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_actualizar_Responsable(?,?)}");
			cst.setInt(1,Responsable.getIdresposanble());
			cst.setString(2,Responsable.getDescripcion());
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public Responsable obtenerResponsable(int idResponsable) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Responsable Responsable = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_obtener_Responsable(?)}");
			cst.setInt(1, idResponsable);
		
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				Responsable = new Responsable();
				Responsable.setIdresposanble(rs.getInt("idResponsable"));
				Responsable.setDescripcion(rs.getString("descripcion"));
				
			
					
				
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return Responsable;
	}
	
	
	public ArrayList<Responsable> Listar() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Responsable> lista = new ArrayList<Responsable>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_listar_Responsables()}");
		
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Responsable Responsable=new Responsable();
				Responsable.setIdresposanble(rs.getInt("idResponsable"));
				Responsable.setDescripcion(rs.getString("descripcion"));
			
				
			
				
				lista.add(Responsable);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
	public ArrayList<Responsable> ListarServicio(int idservicio, String turno) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Responsable> lista = new ArrayList<Responsable>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_doctor_servicios(?,?)}");
			cst.setInt(1,idservicio);
			cst.setString(2,turno );
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Responsable Responsable=new Responsable();
				Responsable.setIdresposanble(rs.getInt("idResponsable"));
				Responsable.setDescripcion(rs.getString("descripcion"));
			
				
			
				
				lista.add(Responsable);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
}

