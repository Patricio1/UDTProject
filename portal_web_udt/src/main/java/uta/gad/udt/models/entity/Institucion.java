package uta.gad.udt.models.entity;
// Generated 25/12/2017 21:55:21 by Hibernate Tools 4.3.1

import java.math.BigDecimal;

/**
 * Institucion generated by hbm2java
 */
public class Institucion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String abreviatura;
	private String slogan;
	private String direccion;
	private String telefono;
	private String correoAdmin;
	private String horarioAtencion;
	private String logo;
	private String mision;
	private String vision;
	private String valores;
	private String acercaDe;
	private BigDecimal lat;
	private BigDecimal lon;
	
	private String imgOpcion;

	public String getImgOpcion() {
		return imgOpcion;
	}
	public void setImgOpcion(String imgOpcion) {
		this.imgOpcion = imgOpcion;
	}
	public Institucion() {
	}
	/**public Institucion(String nombre, String direccion, String telefono,
			String logo) {		
		this.nombre = nombre;				
		this.direccion = direccion;
		this.telefono = telefono;	
		this.logo = logo;	
	}*/

	public Institucion(int id, String nombre, String direccion,
			String telefono, String correoAdmin, String horarioAtencion) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoAdmin = correoAdmin;
		this.horarioAtencion = horarioAtencion;
	}

	public Institucion(int id, String nombre, String abreviatura,
			String slogan, String direccion, String telefono,
			String correoAdmin, String horarioAtencion, String logo,
			String mision, String vision, String valores, String acercaDe,
			BigDecimal lat, BigDecimal lon) {
		this.id = id;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.slogan = slogan;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoAdmin = correoAdmin;
		this.horarioAtencion = horarioAtencion;
		this.logo = logo;
		this.mision = mision;
		this.vision = vision;
		this.valores = valores;
		this.acercaDe = acercaDe;
		this.lat = lat;
		this.lon = lon;
	}
	public Institucion(String nombre, String abreviatura,
			String slogan, String direccion, String telefono,
			String correoAdmin, String horarioAtencion, String logo,
			String mision, String vision, String valores, String acercaDe,
			BigDecimal lat, BigDecimal lon) {
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.slogan = slogan;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoAdmin = correoAdmin;
		this.horarioAtencion = horarioAtencion;
		this.logo = logo;
		this.mision = mision;
		this.vision = vision;
		this.valores = valores;
		this.acercaDe = acercaDe;
		this.lat = lat;
		this.lon = lon;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoAdmin() {
		return this.correoAdmin;
	}

	public void setCorreoAdmin(String correoAdmin) {
		this.correoAdmin = correoAdmin;
	}

	public String getHorarioAtencion() {
		return this.horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMision() {
		return this.mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getVision() {
		return this.vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getValores() {
		return this.valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getAcercaDe() {
		return this.acercaDe;
	}

	public void setAcercaDe(String acercaDe) {
		this.acercaDe = acercaDe;
	}

	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return this.lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

}
