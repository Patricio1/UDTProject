package uta.gad.udt.models.dao;

import java.util.List;

import uta.gad.udt.models.entity.AreaTransferencia;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.CooperativaConProximasSalidas;
import uta.gad.udt.models.entity.DestinosFrecuencia;
import uta.gad.udt.models.entity.DetalleCooperativa;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.entity.PreguntaFrecuente;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;
import uta.gad.udt.models.entity.TarifaTransporte;
import uta.gad.udt.models.entity.TramiteTransportista;

public interface AdministracionDAO {
	public void updateInstitucion(Institucion institucion);
	public void addLink(Link link);
	public Institucion getInfoInstitucion();
	
	//public int addServicio(Servicio servicio);
	//public int updateServicio(Servicio servicio);
	public List<Servicio> getServicios();
	public Servicio getServicio(short idServicio);
	public int saveServicio(Servicio servicio);
	public int deleteServicio(Servicio servicio);
	
	
	
	public List<ComunicadoNoticia> getComunicadoNoticia();
	public ComunicadoNoticia getComunicadoNoticiaById(int id);
	public int saveComunicadoNoticia(ComunicadoNoticia comunicadoNoticia);
	public int deleteComunicadoNoticia(ComunicadoNoticia comunicadoNoticia);
	
	public List<Recurso> getRecursos();
	public Recurso getRecursosById(int id);
	public int saveRecurso(Recurso recurso);
	public int deleteRecurso(Recurso recurso);
	
	public List<DetalleCooperativa> getDirectorioCooperativa();
	public List<CooperativaConProximasSalidas> getNombresCooperativas();
	public int saveDirectorioCooperativa(DetalleCooperativa detalleCooperativa);
	public int deleteDirectorioCooperativa(DetalleCooperativa detalleCooperativa);
	public DetalleCooperativa getDetalleCooperativaById(int id);
	
	public List<AreaTransferencia> getAreasTransferencia();
	public AreaTransferencia getAreaTransferenciaById(int id);
	public int saveAreaTransferencia(AreaTransferencia areaTransferencia);
	public int deleteAreaTransferencia(AreaTransferencia areaTransferencia);
	
	public TramiteTransportista getTramiteTransportistaById(int id);
	public int saveTramiteTransportista(TramiteTransportista tramite);
	public int deleteTramiteTransportista(TramiteTransportista tramite);
	
	public PreguntaFrecuente getPreguntaFrecuenteById(int id);
	public int savePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);
	public int deletePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente);
	
	public TarifaTransporte getTarifaTransporteById(int id);
	public int saveTarifaTransporte(TarifaTransporte tarifaTransporte);
	public int deleteTarifaTransporte(TarifaTransporte tarifaTransporte);
	public List<DestinosFrecuencia> getNombresDestinos();
}
