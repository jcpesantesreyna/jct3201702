package Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;

import Entidades.Historia;

public class DaoHistoria {

	public static DaoHistoria _Instancia;
	private DaoHistoria(){};
	public static DaoHistoria Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoHistoria();
		}
		return _Instancia;
	}
	public boolean Insertar(Historia historia) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_insertar_Historia(?,?,?,?,?,?)}");
		//	cst.setInt(1,historia.getNumhistoria());
			cst.setString(1, historia.getApepat());
			cst.setString(2, historia.getApemat());
			cst.setString(3, historia.getNombres());
			cst.setDate(4, historia.getFechanac());
			cst.setString(5, historia.getDni());
			cst.setString(6, historia.getDireccion());
			
			
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public boolean update(Historia historia) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_actualizar_Historia(?,?,?,?,?,?,?)}");
			cst.setInt(1,historia.getNumhistoria());
			cst.setString(2, historia.getApepat());
			cst.setString(3, historia.getApemat());
			cst.setString(4, historia.getNombres());
			cst.setDate(5, historia.getFechanac());
			cst.setString(6, historia.getDni());
			cst.setString(7, historia.getDireccion());
			
			
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	
	public Historia obtenerHistoria(int idHistoria) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Historia historia = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_obtener_Historia(?)}");
			cst.setInt(1, idHistoria);
		
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				historia = new Historia();
				historia.setNumhistoria(rs.getInt("numhistoria"));
				historia.setApepat(rs.getString("apepat"));
				historia.setApemat(rs.getString("apemat"));
				historia.setNombres(rs.getString("nombres"));
				historia.setFechanac(rs.getDate("fechanac"));
				historia.setDni(rs.getString("dni"));
				historia.setDireccion(rs.getString("direccion"));								
				
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return historia;
	}
	public Historia buscar_por_dni(String dni) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Historia historia = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_obtener_Historia_dni(?)}");
			cst.setString(1, dni);
		
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				historia = new Historia();
				historia.setNumhistoria(rs.getInt("idHistoria"));
				historia.setApepat(rs.getString("apepat"));
				historia.setApemat(rs.getString("apemat"));
				historia.setNombres(rs.getString("nnombres"));
				historia.setFechanac(rs.getDate("fechanac"));
				historia.setDni(rs.getString("dni"));
				historia.setDireccion(rs.getString("direccion"));	
				
				
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return historia;
	}
	
	
	public ArrayList<Historia> Listar() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Historia> lista = new ArrayList<Historia>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_listar_Historias()}");
			
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Historia historia=new Historia();
				historia.setNumhistoria(rs.getInt("numhistoria"));
				historia.setApepat(rs.getString("apepat"));
				historia.setApemat(rs.getString("apemat"));
				historia.setNombres(rs.getString("nombres"));
				historia.setFechanac(rs.getDate("fechanac"));
				historia.setDni(rs.getString("dni"));
				historia.setDireccion(rs.getString("direccion"));
			
				
				lista.add(historia);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
}
