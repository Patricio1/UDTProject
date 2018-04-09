package uta.gad.udt.models.dao;

import java.util.List;

import uta.gad.udt.models.entity.AreaTransferencia;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.CooperativaConProximasSalidas;
import uta.gad.udt.models.entity.CooperativasFrecPorDestino;
import uta.gad.udt.models.entity.DestinosConProximasSalidas;
import uta.gad.udt.models.entity.DestinosCoopIntercantonal;
import uta.gad.udt.models.entity.DestinosFrecuencia;
import uta.gad.udt.models.entity.DetalleCooperativa;
import uta.gad.udt.models.entity.DetalleProximasSalidasDestino;
import uta.gad.udt.models.entity.HorarioCooperativaPorDestino;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.LetraInicialCooperativa;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.entity.MultasPorPlacaUnidadT;
import uta.gad.udt.models.entity.PreguntaGlosario;
import uta.gad.udt.models.entity.ProximaSalidaCooperativa;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;

public interface PublicoDAO {
	public List<Link> listarLinksInteres();
	public List<ProximaSalidaCooperativa> listarProximasSalidas();
	public List<Servicio> listarServicios();
	public List<CooperativaConProximasSalidas> listarCoopConProximasSalidas();
	public List<DestinosConProximasSalidas> listarDestinosConProximasSalidas();
	public List<DetalleProximasSalidasDestino> listarDetalleProximasSalidasDestino(Long idOrigen,Long idDestino);
	public List<DestinosFrecuencia> listarDestinosFrecuencia();
	public List<CooperativasFrecPorDestino> listarCooperativasFrecPorDestino(Long idDestino);
	public List<HorarioCooperativaPorDestino> listarHorarioCoopPorDestino(Long idDestino,Long idCooperativa);
	public List<MultasPorPlacaUnidadT> listarMultaPorPlacaUnidadT(String placaUnidadTransporte);
	public List<DestinosCoopIntercantonal> listarDestinosCoopIntercantonal();
	public List<DestinosCoopIntercantonal> listarDestinosCoopInterparroquial();
	public AreaTransferencia getAreaTransferenciaPorNombre(String nombreAreaTransferencia);
	public List<AreaTransferencia> getNombresAreaTransferencia();
	public Institucion getInfoInstitucion();
	public List<ComunicadoNoticia> listarComunicados();
	public ComunicadoNoticia getComunicadoNoticiaPorId(String tipo, Integer id);
	public List<LetraInicialCooperativa> getLetraInicialCooperativa();
	public List<DetalleCooperativa> getDetalleCooperativa();
	public List<DetalleCooperativa> getCooperativasTrabajanTerminal();
	public Recurso getRecursoPorNombre(String nombreRecurso);
	public List<Recurso> getSlides();
	public List<ComunicadoNoticia> getUltimas4Noticias();
	public List<ComunicadoNoticia> getTitularesNoticias();
	public ComunicadoNoticia getNoticiaPrincipal();
	public List<PreguntaGlosario> getPreguntaGlosario(String tipo);
	
	/*
	 * CRUD OPERATIONS
	 */
	public void updateInstitucion(Institucion institucion);
	public void addLink(Link link);
	 
	
}
