package Entidades;

public class Cita {
	private int idcita;
	private Usuario usuario;
	private Historia historia;
	private Programacion programacion;
	public int getIdcita() {
		return idcita;
	}
	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Historia getHistoria() {
		return historia;
	}
	public void setHistoria(Historia historia) {
		this.historia = historia;
	}
	public Programacion getProgramacion() {
		return programacion;
	}
	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}

}
