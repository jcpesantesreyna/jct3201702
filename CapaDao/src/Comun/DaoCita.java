package Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Cita;
import Entidades.Historia;
import Entidades.Programacion;
import Entidades.Responsable;
import Entidades.Servicio;
import Entidades.Usuario;

public class DaoCita {
	public static DaoCita _Instancia;
	private DaoCita(){};
	public static DaoCita Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoCita();
		}
		return _Instancia;
	}
	public boolean Insertar(Cita Cita) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_insertar_Cita(?,?,?,?)}");
			cst.setInt(1,Cita.getUsuario().getIdUsuario());
			cst.setInt(2, Cita.getHistoria().getNumhistoria());
			cst.setDate(3, Cita.getFecha());
			cst.setInt(4, Cita.getProgramacion().getIdprogramacion());
			
			
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public boolean update(Cita Cita) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_actualizar_Cita(?,?,?,?,?)}");
			cst.setInt(1,Cita.getIdcita());
			cst.setInt(2,Cita.getUsuario().getIdUsuario());
			cst.setInt(3, Cita.getHistoria().getNumhistoria());
			cst.setDate(4, Cita.getFecha());
			cst.setInt(5, Cita.getProgramacion().getIdprogramacion());
			
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public Cita obtenerCita(int idCita) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Cita Cita = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_obtener_Cita(?)}");
			cst.setInt(1, idCita);
		
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				Cita = new Cita();
			    Cita.setIdcita(rs.getInt("idcita"));
			    Historia historia;
			    historia=DaoHistoria.Instancia().obtenerHistoria(rs.getInt("idhistoria"));
				Cita.setHistoria(historia);
				Programacion programacion;
				programacion=DaoProgramacion.Instancia().obtenerProgramacion(rs.getInt("idprogramacion"));
				Cita.setProgramacion(programacion);
						Usuario usuario=new Usuario();
						usuario.setIdUsuario(rs.getInt("idusuario"));
						Cita.setUsuario(usuario);
			
				Cita.setFecha(rs.getDate("fecha"));
				
																
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return Cita;
	}
	
	
	
	public ArrayList<Cita> Listar(int idresponsable) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Cita> lista = new ArrayList<Cita>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_reporte(?)}");
			cst.setInt(1, idresponsable);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Cita Cita = new Cita();
			    Cita.setIdcita(rs.getInt("idcita"));
			    Historia historia;
			    historia=DaoHistoria.Instancia().obtenerHistoria(rs.getInt("idhistoria"));
				Cita.setHistoria(historia);
				Programacion programacion;
				programacion=DaoProgramacion.Instancia().obtenerProgramacion(rs.getInt("idprogramacion"));
				Cita.setProgramacion(programacion);
						Usuario usuario=new Usuario();
						usuario.setIdUsuario(rs.getInt("idusuario"));
						Cita.setUsuario(usuario);
			
				Cita.setFecha(rs.getDate("fecha"));
				lista.add(Cita);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
	
}
