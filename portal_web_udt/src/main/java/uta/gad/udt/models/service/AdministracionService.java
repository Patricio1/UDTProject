package uta.gad.udt.models.service;

import java.util.List;

import uta.gad.udt.models.entity.AreaTransferencia;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.ConfigMail;
import uta.gad.udt.models.entity.CooperativaConProximasSalidas;
import uta.gad.udt.models.entity.DestinosFrecuencia;
import uta.gad.udt.models.entity.DetalleCooperativa;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.entity.Perfil;
import uta.gad.udt.models.entity.PreguntaFrecuente;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;
import uta.gad.udt.models.entity.TarifaTransporte;
import uta.gad.udt.models.entity.TramiteTransportista;
import uta.gad.udt.models.entity.Usuario;

public interface AdministracionService {
	public int updateInstitucion(Institucion institucion);
	public Institucion getInfoInstitucion();
	
	public List<Servicio> getServicios();
	public int deleteServicio(Servicio servicio);
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
	
	public int updateConfigMail(ConfigMail configmail);
	
	public Link getLinkInteresById(short id);
	public int saveLinkInteres(Link linkInteres);
	public int deleteLinkInteres(Link linkInteres);
	
	public Usuario getUsuarioById(long id);
	public Usuario getUsuarioByUserName(String username);
	public int saveUsuario(Usuario usuario);
	
	public Perfil getPerfilById(long id);
	
}
