package uta.gad.udt.models.entity;



public class ProximaSalidaCooperativa{	
	public String hora;
	public String cooperativa;	
	public String origen;
	public String destino;
	public Long anden;
	public ProximaSalidaCooperativa()
	{}
	public ProximaSalidaCooperativa(String hora, String cooperativa,
			String origen, String destino, Long anden) {
		super();
		this.hora = hora;
		this.cooperativa = cooperativa;
		this.origen = origen;
		this.destino = destino;
		this.anden = anden;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getCooperativa() {
		return cooperativa;
	}
	public void setCooperativa(String cooperativa) {
		this.cooperativa = cooperativa;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Long getAnden() {
		return anden;
	}
	public void setAnden(Long anden) {
		this.anden = anden;
	}
	
	

	
}
