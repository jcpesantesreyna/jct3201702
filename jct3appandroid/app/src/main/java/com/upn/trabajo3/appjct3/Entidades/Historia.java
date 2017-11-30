package com.upn.trabajo3.appjct3.Entidades;
import java.sql.Date;

public class Historia {
	private int numhistoria;
	private String apepat;
	private String apemat;
	private String nombres;
	private String fechanac;
	private String dni;
	private String direccion;
	public int getNumhistoria() {
		return numhistoria;
	}
	public String getApepat() {
		return apepat;
	}
	public String getApemat() {
		return apemat;
	}
	public String getNombres() {
		return nombres;
	}
	public String getFechanac() {
		return fechanac;
	}
	public String getDni() {
		return dni;
	}
	public String getDireccion() {
		return direccion;
	}
	
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
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNombreCompleto()
	{
		return this.apepat+" "+this.apemat+" "+this.nombres;
	}
	
	

}
