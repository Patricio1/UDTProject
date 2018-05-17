package uta.gad.udt.models.entity;


public class Link implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private short idLink;
	private String nombre;
	private String icono;
	private String url;
	private String imgOpcion;

	public String getImgOpcion() {
		return imgOpcion;
	}

	public void setImgOpcion(String imgOpcion) {
		this.imgOpcion = imgOpcion;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	

	public Link() {
	}

	public Link(short idLink, String nombre, String url) {
		this.idLink = idLink;
		this.nombre = nombre;
		this.url = url;
	}

	public short getIdLink() {
		return this.idLink;
	}

	public void setIdLink(short idLink) {
		this.idLink = idLink;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
