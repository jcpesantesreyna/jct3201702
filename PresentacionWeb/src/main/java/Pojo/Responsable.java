package Pojo;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Responsable {

	private int idresposanble;
	private String descripcion;
	public int getIdresposanble() {
		return idresposanble;
	}
	public void setIdresposanble(int idresposanble) {
		this.idresposanble = idresposanble;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
