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
			cn = DriverManager.getConnection("jdbc:sqlserver://upn201702.database.windows.net:1433;"+
						"databaseName=sowadt3", "Carmaster", "A123456A@");
			/*cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+
					"databaseName=jct3", "sa", "123456");*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cn;
	}
}


