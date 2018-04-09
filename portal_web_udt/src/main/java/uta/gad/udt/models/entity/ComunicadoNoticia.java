package uta.gad.udt.models.entity;
import java.util.Date;
import java.util.regex.Pattern;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


public class ComunicadoNoticia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String contenido;
	private char tipo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date fecha;
	
	private Boolean estado;
	private String imagen;
	private String _fecha;
	private String imgOpcion;

	public String getImgOpcion() {
		return imgOpcion;
	}
	public void setImgOpcion(String imgOpcion) {
		this.imgOpcion = imgOpcion;
	}
	public ComunicadoNoticia() {
	}
	public ComunicadoNoticia(String titulo,Date fecha) {
		this.titulo = titulo;		
		this.fecha = fecha;
	}
	public ComunicadoNoticia(int id, String titulo, String contenido, char tipo) {
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.tipo = tipo;
	}

	public ComunicadoNoticia(int id, String titulo, String contenido,
			char tipo, Date fecha, Boolean estado, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.tipo = tipo;
		this.fecha = fecha;
		this.estado = estado;
		this.imagen = imagen;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public char getTipo() {
		return this.tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String get_fecha() {
		return _fecha;
	}
	public void set_fecha(String _fecha) {
		this._fecha = _fecha;
	}

}
