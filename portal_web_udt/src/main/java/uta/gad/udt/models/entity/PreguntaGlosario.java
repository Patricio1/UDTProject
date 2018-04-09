package uta.gad.udt.models.entity;
public class PreguntaGlosario implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private short id;
	private String nombre;
	private String descripcion;
	private String tipo;

	public PreguntaGlosario() {
	}
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
