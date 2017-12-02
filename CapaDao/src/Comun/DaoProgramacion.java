package Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Programacion;
import Entidades.Responsable;
import Entidades.Servicio;

public class DaoProgramacion {
	public static DaoProgramacion _Instancia;
	private DaoProgramacion(){};
	public static DaoProgramacion Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoProgramacion();
		}
		return _Instancia;
	}
	public boolean Insertar(Programacion Programacion) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_insertar_Programacion(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1,Programacion.getServicio().getIdservicio());
			cst.setInt(2, Programacion.getResponsable().getIdresposanble());
			cst.setString(3, Programacion.getTurno());
			cst.setInt(4, Programacion.getDialun());
			cst.setInt(5, Programacion.getDiamar());
			cst.setInt(6, Programacion.getDiamie());
			cst.setInt(7, Programacion.getDiajue());
			cst.setInt(8, Programacion.getDiavie());
			cst.setInt(9, Programacion.getDiasab());
			cst.setBoolean(10, Programacion.isEstado());
			
			
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public boolean update(Programacion Programacion) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_actualizar_Programacion(?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1,Programacion.getIdprogramacion());
			cst.setInt(2,Programacion.getServicio().getIdservicio());
			cst.setInt(3, Programacion.getResponsable().getIdresposanble());
			cst.setString(4, Programacion.getTurno());
			cst.setInt(5, Programacion.getDialun());
			cst.setInt(6, Programacion.getDiamar());
			cst.setInt(7, Programacion.getDiamie());
			cst.setInt(8, Programacion.getDiajue());
			cst.setInt(9, Programacion.getDiavie());
			cst.setInt(10, Programacion.getDiasab());
			cst.setBoolean(11, Programacion.isEstado());
			
			
			
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	public Programacion obtenerProgramacion(int idProgramacion) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Programacion Programacion = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_obtener_Programacion(?)}");
			cst.setInt(1, idProgramacion);
		
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				Programacion = new Programacion();
				Programacion.setIdprogramacion(rs.getInt("idProgramacion"));
				Servicio servicio;//=new Servicio();
				//servicio.setIdservicio(rs.getInt("idservicio"));
				servicio=DaoServicio.Instancia().obtenerServicio(rs.getInt("idservicio"));
				Responsable responsable;//=new Responsable();
				responsable=DaoResponsable.Instancia().obtenerResponsable(rs.getInt("idresposanble"));
				//responsable.setIdresposanble(rs.getInt("idresposanble"));
				Programacion.setServicio(servicio);
				Programacion.setResponsable(responsable);
				Programacion.setTurno(rs.getString("turno"));
				Programacion.setDialun(rs.getInt("dialun"));
				Programacion.setDiamar(rs.getInt("diamar"));
				Programacion.setDiamie(rs.getInt("diamie"));
				Programacion.setDiajue(rs.getInt("diajue"));
				Programacion.setDiavie(rs.getInt("diavier"));
				Programacion.setDiasab(rs.getInt("diasab"));
				Programacion.setEstado(rs.getBoolean("estado"));	
																
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return Programacion;
	}
	
	
	public ArrayList<Programacion> Listar(int idservicio, String turno, int idresponsable) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Programacion> lista = new ArrayList<Programacion>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_listar_Programacion(?,?,?)}");
			cst.setInt(1,idservicio);
		cst.setString(2, turno);
			cst.setInt(3,idresponsable);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Programacion Programacion = new Programacion();
			Programacion.setIdprogramacion(rs.getInt("idProgramacion"));
			Servicio servicio;//=new Servicio();
			//servicio.setIdservicio(rs.getInt("idservicio"));
			servicio=DaoServicio.Instancia().obtenerServicio(rs.getInt("idservicio"));
			Responsable responsable;//=new Responsable();
			responsable=DaoResponsable.Instancia().obtenerResponsable(rs.getInt("idresposanble"));
			
			
				Programacion.setServicio(servicio);
				Programacion.setResponsable(responsable);
				
				Programacion.setTurno(rs.getString("turno"));
				Programacion.setDialun(rs.getInt("dialun"));
				Programacion.setDiamar(rs.getInt("diamar"));
				Programacion.setDiamie(rs.getInt("diamie"));
				Programacion.setDiajue(rs.getInt("diajue"));
				Programacion.setDiavie(rs.getInt("diavier"));
				Programacion.setDiasab(rs.getInt("diasab"));
				Programacion.setEstado(rs.getBoolean("estado"));
	
		
				
				lista.add(Programacion);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
	public ArrayList<Programacion> Listar() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Programacion> lista = new ArrayList<Programacion>();
		try {
			CallableStatement cst = cn.prepareCall("{call pa_listar_Programacion_2()}");
			;
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Programacion Programacion = new Programacion();
			Programacion.setIdprogramacion(rs.getInt("idProgramacion"));
			
				Servicio servicio;//=new Servicio();
				//servicio.setIdservicio(rs.getInt("idservicio"));
				servicio=DaoServicio.Instancia().obtenerServicio(rs.getInt("idservicio"));
				Responsable responsable;//=new Responsable();
				responsable=DaoResponsable.Instancia().obtenerResponsable(rs.getInt("idresposanble"));
				Programacion.setServicio(servicio);
				Programacion.setResponsable(responsable);
				
				Programacion.setTurno(rs.getString("turno"));
				Programacion.setDialun(rs.getInt("dialun"));
				Programacion.setDiamar(rs.getInt("diamar"));
				Programacion.setDiamie(rs.getInt("diamie"));
				Programacion.setDiajue(rs.getInt("diajue"));
				Programacion.setDiavie(rs.getInt("diavier"));
				Programacion.setDiasab(rs.getInt("diasab"));
				Programacion.setEstado(rs.getBoolean("estado"));
	
		
				
				lista.add(Programacion);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
}
