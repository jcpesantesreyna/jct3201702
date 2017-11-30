package Conexion;
import java.sql.*;
public class Conexion {



	//Singleton
	public static Conexion _Instancia;
	private Conexion(){};
	public static Conexion Instancia(){
		if(_Instancia==null){
			_Instancia = new Conexion();
		}
		return _Instancia;
	}
	//endSingleton	
	
	public Connection Conectar() throws Exception{
		Connection cn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		/*	cn = DriverManager.getConnection("jdbc:sqlserver://sowad2017upn.database.windows.net:1433;"+
						"databaseName=T2_jc", "sowad", "Admin123");*/
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
					"databaseName=jct3", "sa", "123456");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cn;
	}
}


