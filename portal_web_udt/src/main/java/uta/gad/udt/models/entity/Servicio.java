package uta.gad.udt.models.entity;
public class Servicio implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private short idServicio;
	private String nombre;
	private String descripcion;
	private String imagen;
	private String imgOpcion;

	public String getImgOpcion() {
		return imgOpcion;
	}

	public void setImgOpcion(String imgOpcion) {
		this.imgOpcion = imgOpcion;
	}

	public Servicio() {
	}

	public Servicio(short idServicio, String nombre) {
		this.idServicio = idServicio;
		this.nombre = nombre;
	}

	public Servicio(short idServicio, String nombre, String descripcion,
			String imagen) {
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public short getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(short idServicio) {
		this.idServicio = idServicio;
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

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
