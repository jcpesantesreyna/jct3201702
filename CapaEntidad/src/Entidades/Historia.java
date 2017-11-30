package Entidades;

import java.sql.Date;

public class Historia {
	private int numhistoria;
	private String apepat;
	private String apemat;
	private String nombres;
	private Date fechanac;
	private String dni;
	private String direccion;
	public void setNumhistoria(int numhistoria) {
		this.numhistoria = numhistoria;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
