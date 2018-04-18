package uta.gad.udt.models.entity;

public class DetalleCooperativa {
private int id;
private Long idCooperativa;
private int cubiculo;
private String telefono;
private String horario;
private String logo;
private String website;

private String cooperativa;
private String inicial;
private String destinos;
private boolean incluirLogo;
public boolean isIncluirLogo() {
	return incluirLogo;
}
public void setIncluirLogo(boolean incluirLogo) {
	this.incluirLogo = incluirLogo;
}
public String getDestinos() {
	return destinos;
}
public void setDestinos(String destinos) {
	this.destinos = destinos;
}
public int getId() {
	return id;
}
public Long getIdCooperativa() {
	return idCooperativa;
}
public void setIdCooperativa(Long idCooperativa) {
	this.idCooperativa = idCooperativa;
}
public void setId(int id) {
	this.id = id;
}
public String getCooperativa() {
	return cooperativa;
}
public void setCooperativa(String cooperativa) {
	this.cooperativa = cooperativa;
}
public String getInicial() {
	return inicial;
}
public void setInicial(String inicial) {
	this.inicial = inicial;
}
public int getCubiculo() {
	return cubiculo;
}
public void setCubiculo(int cubiculo) {
	this.cubiculo = cubiculo;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getHorario() {
	return horario;
}
public void setHorario(String horario) {
	this.horario = horario;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}

}
