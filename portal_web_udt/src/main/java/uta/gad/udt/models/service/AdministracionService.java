package uta.gad.udt.models.service;

import java.util.List;

import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;

public interface AdministracionService {
	public Institucion getInfoInstitucion();
	//public int addServicio(Servicio servicio);
	public List<Servicio> getServicios();
	public int deleteServicio(Servicio servicio);
	//public int updateServicio(Servicio servicio);
	public Servicio getServicio(short idServicio);
	public int saveServicio(Servicio servicio);
	
	public List<ComunicadoNoticia> getComunicadoNoticia();
	public ComunicadoNoticia getComunicadoNoticiaById(int id);
	public int saveComunicadoNoticia(ComunicadoNoticia comunicadoNoticia);
	public int deleteComunicadoNoticia(ComunicadoNoticia comunicadoNoticia);
	
	public List<Recurso> getRecursos();
	public Recurso getRecursosById(int id);
	public int saveRecurso(Recurso recurso);
	public int deleteRecurso(Recurso recurso);
	
	 public void deleteFile(String pathRecurso);
}
