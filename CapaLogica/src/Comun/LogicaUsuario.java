package Comun;

import java.util.ArrayList;


import Entidades.Usuario;


public class LogicaUsuario {

	public static LogicaUsuario _Instancia;
	private LogicaUsuario(){};
	public static LogicaUsuario Instancia(){
		if(_Instancia==null){
			_Instancia = new LogicaUsuario();
		}
		return _Instancia;
	}
	//endSingleton
	
	public Usuario VerificarAcceso(String _Login, String _Passw,String tipo) throws Exception{
		try {
			Usuario u =DaoUsuario.Instancia().VerificarAcceso(_Login, _Passw,tipo);
			if(u==null){
				throw new ArithmeticException("USuario o PAssword no Validop");	
			}
			
			return u;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public ArrayList<Usuario> Listar() throws Exception{	
		try {
			return DaoUsuario.Instancia().Listar();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean Insertar(String session,String password,String tipousuario) throws Exception{	
		try {
			return DaoUsuario.Instancia().Insertar(session,password,tipousuario);
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}