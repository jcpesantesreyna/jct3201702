package Comun;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.EntOrdenTrabajo;
import Entidades.EntUsuario;


public class DaoOrdenTrabajo 
{

	public static DaoOrdenTrabajo _Instancia;
	private DaoOrdenTrabajo(){};
	public static DaoOrdenTrabajo Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoOrdenTrabajo();
		}
		return _Instancia;
	}
	//endSingleton
	
	
	
	
	public boolean Insertar(EntOrdenTrabajo ot) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call insertar_OrdenTrabajo(?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, ot.getFecha_inicio());
			cst.setString(2, ot.getFecha_entrega() );
			cst.setString(3, ot.getCliente() );
			cst.setString(4, ot.getDetalle() );
			cst.setDouble(5,ot.getCosto());
			cst.setString(6, ot.getResponsable());
			cst.setString(7, ot.getLugar_entrega());
			cst.setInt(8, ot.getUsuario().getIdUsuario());
			cst.setString(9, "P");
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	
	public boolean Procesar(int ordenid) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean actualizo = false;
		try {
			CallableStatement cst = cn.prepareCall("{call procesar_Orden(?)}");
			cst.setInt(1, ordenid);
		
			int i = cst.executeUpdate();
			if(i>0){ actualizo = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return actualizo;
	}
	
	public ArrayList<EntOrdenTrabajo> Listar(int idusuario) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<EntOrdenTrabajo> lista = new ArrayList<EntOrdenTrabajo>();
		try {
			CallableStatement cst = cn.prepareCall("{call listar_ordenTrabajo(?)}");
			cst.setInt(1, idusuario);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				EntOrdenTrabajo ot=new EntOrdenTrabajo();
				ot.setIdOrdentrabajo(rs.getInt("idOrden"));
				ot.setFecha_inicio(rs.getString("fecha_inicio"));
				ot.setFecha_entrega(rs.getString("fecha_entrega"));
				ot.setCosto(rs.getDouble("costo"));
				ot.setDetalle(rs.getString("detalle"));
				ot.setLugar_entrega(rs.getString("lugar_entrega"));
				ot.setResponsable(rs.getString("responsable"));
				ot.setEstado(rs.getString("estado_orden"));
				ot.setCliente(rs.getString("cliente"));
				EntUsuario u=new EntUsuario();
				u.setIdUsuario(rs.getInt("idusuario"));
				ot.setUsuario(u);
				lista.add(ot);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
	public ArrayList<EntOrdenTrabajo> Listar() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<EntOrdenTrabajo> lista = new ArrayList<EntOrdenTrabajo>();
		try {
			CallableStatement cst = cn.prepareCall("{call listar_ordentrabajo_pendiente()}");
			
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				EntOrdenTrabajo ot=new EntOrdenTrabajo();
				ot.setIdOrdentrabajo(rs.getInt("IdOrden"));
				ot.setFecha_inicio(rs.getString("fecha_inicio"));
				ot.setFecha_entrega(rs.getString("fecha_entrega"));
				ot.setCosto(rs.getDouble("costo"));
				ot.setDetalle(rs.getString("detalle"));
				ot.setLugar_entrega(rs.getString("lugar_entrega"));
				ot.setResponsable(rs.getString("responsable"));
				ot.setEstado(rs.getString("estado_orden"));
				ot.setCliente(rs.getString("cliente"));
				EntUsuario u=new EntUsuario();
				u.setIdUsuario(rs.getInt("idusuario"));
				u.setSesion(rs.getString("nombre_sesion"));
				ot.setUsuario(u);
				
						
			
				lista.add(ot);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
	public EntOrdenTrabajo Devolver(int ordenid) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		EntOrdenTrabajo OT= null;
		try {
			CallableStatement cst = cn.prepareCall("{call devolver_OrdenTrabajo(?)}");
			cst.setInt(1, ordenid);
			
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				OT= new EntOrdenTrabajo();
				OT.setIdOrdentrabajo(rs.getInt("IdOrden"));
				OT.setCliente(rs.getString("cliente"));
				OT.setFecha_inicio(rs.getString("fecha_inicio"));
				OT.setFecha_inicio(rs.getString("fecha_entrega"));
				OT.setCosto(rs.getDouble("costo"));
				OT.setDetalle(rs.getString("detalle"));
				OT.setLugar_entrega(rs.getString("lugar_entrega"));
				OT.setResponsable(rs.getString("responsable"));
				OT.setEstado(rs.getString("estado_oirden"));	
				
				
				
								
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return OT;
	}
}
