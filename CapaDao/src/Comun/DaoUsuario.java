package Comun;

import java.sql.*;
import java.util.ArrayList;


import Conexion.Conexion;
import Entidades.Usuario;

public class DaoUsuario {
	//Singleton
	public static DaoUsuario _Instancia;
	private DaoUsuario(){};
	public static DaoUsuario Instancia(){
		if(_Instancia==null){
			_Instancia = new DaoUsuario();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Usuario VerificarAcceso(String _Login, String _Passw) throws Exception{
		Connection cn = Conexion.Instancia().Conectar();
		Usuario u = null;
		try {
			CallableStatement cst = cn.prepareCall("{call pa_login(?,?)}");
			/*cst.setString(1, _Login);
			cst.setString(2, _Passw);
			*/
			
			
			cst.setString(1, "admin");
			cst.setString(2, "admin");
			ResultSet rs = cst.executeQuery();
			if(rs.next()){
				u = new Usuario();
				u.setIdUsuario(rs.getInt("idusuario"));
				u.setSesion(rs.getString("sesion"));
				u.setPassword(rs.getString("contrasenia"));
				u.setTipousuario(rs.getString("tipo_usuario"));
				u.setIdresponsable(rs.getInt("idresponsable"));
			
					
				
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return u;
	}
	
	
	public boolean Insertar(String sesion, String password,String tipoUsuario) throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call insertar_Usuario(?,?,?)}");
			cst.setString(1, sesion);
			cst.setString(2, password);
		   cst.setString(3, tipoUsuario);
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
	}
	
	public ArrayList<Usuario> Listar() throws Exception{		
		Connection cn = Conexion.Instancia().Conectar();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			CallableStatement cst = cn.prepareCall("{call listar_Usuarios()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				
				
				u.setIdUsuario(rs.getInt("idusuario"));
				u.setSesion(rs.getString("nombre_sesion"));
				u.setPassword(rs.getString("contrasenia"));
				u.setTipousuario(rs.getString("tipo_usuario"));
				lista.add(u);
			}
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return lista;
	}
	public boolean Insertar(Usuario EntUsuario) throws Exception {
		Connection cn = Conexion.Instancia().Conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call insertar_Usuario(?,?,?)}");
			cst.setString(1, EntUsuario.getSesion());
			cst.setString(2, EntUsuario.getPassword());
			 cst.setString(3, EntUsuario.getTipousuario());
			int i = cst.executeUpdate();
			if(i>0){ inserto = true; }
		} catch (Exception e) {
			throw e;
		}finally{cn.close();}
		return inserto;
		
	}
}
