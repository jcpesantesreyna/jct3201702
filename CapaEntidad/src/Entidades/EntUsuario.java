package Entidades;

public class EntUsuario {

	private int usuarioid;
	public int getIdUsuario() {
		return usuarioid;
	}
	public void setIdUsuario(int idusuario) {
		this.usuarioid = idusuario;
	}
	public String getSesion() {
		return sesion;
	}
	public void setSesion(String sesion) {
		this.sesion = sesion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String sesion;
	private String password;
	private String tipousuario;
	public String getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}
	
}
