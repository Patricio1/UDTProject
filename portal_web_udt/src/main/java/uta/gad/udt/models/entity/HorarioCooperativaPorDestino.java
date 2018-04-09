package uta.gad.udt.models.entity;

public class HorarioCooperativaPorDestino {
private String hora;
private Long anden;
private String dias;
public String getHora() {
	return hora;
}
public HorarioCooperativaPorDestino(String hora, Long anden, String dias) {
	super();
	this.hora = hora;
	this.anden = anden;
	this.dias = dias;
}
public HorarioCooperativaPorDestino() {
}
public void setHora(String hora) {
	this.hora = hora;
}
public Long getAnden() {
	return anden;
}
public void setAnden(Long anden) {
	this.anden = anden;
}
public String getDias() {
	return dias;
}
public void setDias(String dias) {
	this.dias = dias;
}

}
