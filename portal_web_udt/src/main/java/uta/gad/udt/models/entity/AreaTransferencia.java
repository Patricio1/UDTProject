package uta.gad.udt.models.entity;
public class AreaTransferencia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private byte idArea;
	private String nombre;
	private String direccion;
	private String telefono;
	private String img;
	private String tipoTransp;

	public AreaTransferencia() {
	}

	public AreaTransferencia(byte idArea, String nombre, String direccion,
			String telefono, String img, String tipoTransp) {
		this.idArea = idArea;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.img = img;
		this.tipoTransp = tipoTransp;
	}

	public byte getIdArea() {
		return this.idArea;
	}

	public void setIdArea(byte idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTipoTransp() {
		return this.tipoTransp;
	}

	public void setTipoTransp(String tipoTransp) {
		this.tipoTransp = tipoTransp;
	}

}
