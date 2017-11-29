package Entidades;

import java.sql.Date;

public class EntOrdenTrabajo {

private int idordentrabajo;
public int getIdOrdentrabajo() {
	return idordentrabajo;
}
public String getFecha_entrega() {
	return fecha_entrega;
}
public String getFecha_inicio() {
	return fecha_inicio;
}
public String getCliente() {
	return cliente;
}
public String getDetalle() {
	return detalle;
}
public double getCosto() {
	return costo;
}
public String getResponsable() {
	return responsable;
}
public String getLugar_entrega() {
	return lugar_entrega;
}
public EntUsuario getUsuario() {
	return usuario;
}
public String getEstado() {
	return estado;
}
private String fecha_entrega;
public void setIdOrdentrabajo(int idordentrabajo) {
	this.idordentrabajo = idordentrabajo;
}
public void setFecha_entrega(String fecha_entrega) {
	this.fecha_entrega = fecha_entrega;
}
public void setFecha_inicio(String fecha_inicio) {
	this.fecha_inicio = fecha_inicio;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
public void setDetalle(String detalle) {
	this.detalle = detalle;
}
public void setCosto(double costo) {
	this.costo = costo;
}
public void setResponsable(String responsable) {
	this.responsable = responsable;
}
public void setLugar_entrega(String lugar_entrega) {
	this.lugar_entrega = lugar_entrega;
}
public void setUsuario(EntUsuario usuario) {
	this.usuario = usuario;
}
public void setEstado(String estado) {
	this.estado = estado;
}
private String fecha_inicio;
private String cliente;
private String detalle;
private double costo;
private String responsable;
private String lugar_entrega;
private EntUsuario usuario;
private String estado;

}
