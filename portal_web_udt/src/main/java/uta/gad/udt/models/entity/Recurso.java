package uta.gad.udt.models.entity;

public class Recurso implements java.io.Serializable{
private static final long serialVersionUID = 1L;
private int id;
private String nombre;
private String url;
private String descripcion;
private String tipo;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}

	
}
