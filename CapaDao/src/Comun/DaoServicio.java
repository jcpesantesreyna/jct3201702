package Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Servicio;
import Entidades.Usuario;

public class DaoServicio {
	public static DaoServicio _Instancia;
	private DaoServicio(){};
	public static DaoServicio Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoServicio();
		}
		return _Instancia;
	}
	public boolean Insertar(Servicio servicio) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_insertar_Servicio(?)}");
			cst.setString(1,servicio.getDescripcion());
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public boolean eliminar(int idservicio) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_eliminar_Servicio(?)}");
			cst.setInt(1,idservicio);
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public boolean actualizar(Servicio servicio) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_actualizar_Servicio(?,?)}");
			cst.setInt(1,servicio.getIdservicio());
			cst.setString(2,servicio.getDescripcion());
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public Servicio obtenerServicio(int idservicio) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Servicio servicio = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_obtener_servicio(?)}");
			cst.setInt(1, idservicio);
		
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				servicio = new Servicio();
				servicio.setIdservicio(rs.getInt("idservicio"));
				servicio.setDescripcion(rs.getString("descripcion"));
				
			
					
				
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return servicio;
	}
	
	
	public ArrayList<Servicio> Listar() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Servicio> lista = new ArrayList<Servicio>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_listar_Servicios()}");
			
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Servicio servicio=new Servicio();
				servicio.setIdservicio(rs.getInt("idservicio"));
				servicio.setDescripcion(rs.getString("descripcion"));
			
				
			
				
				lista.add(servicio);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
}
