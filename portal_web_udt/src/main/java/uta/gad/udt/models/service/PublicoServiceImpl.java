package uta.gad.udt.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uta.gad.udt.models.dao.PublicoDAO;
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
import uta.gad.udt.models.entity.PreguntaFrecuente;
import uta.gad.udt.models.entity.PreguntaGlosario;
import uta.gad.udt.models.entity.ProximaSalidaCooperativa;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;
import uta.gad.udt.models.entity.TarifaTransporte;
import uta.gad.udt.models.entity.TramiteTransportista;

@Service("publicoService")
public class PublicoServiceImpl implements PublicoService {
	
	@Autowired
	private PublicoDAO publicoDAO;		
	
	@Override
	@Transactional(readOnly = true)
	public List<Link> listarLinksInteres() {		
		return publicoDAO.listarLinksInteres();
	}
	
	@Override
	public List<Servicio> listarServicios() {		
		return publicoDAO.listarServicios();
	}
	@Override
	@Transactional(readOnly = true)
	public List<ProximaSalidaCooperativa> listarProximasSalidas() {	
		return publicoDAO.listarProximasSalidas();
	}
	@Override
	@Transactional(readOnly = true)
	public List<CooperativaConProximasSalidas> listarCoopConProximasSalidas() {	
		return publicoDAO.listarCoopConProximasSalidas();
	}
	@Override
	@Transactional(readOnly = true)
	public List<DestinosConProximasSalidas> listarDestinosConProximasSalidas(){	
		return publicoDAO.listarDestinosConProximasSalidas();
	}
	@Override
	@Transactional(readOnly = true)
	public List<DetalleProximasSalidasDestino> listarDetalleProximasSalidasDestino(Long idOrigen,Long idDestino){  		
		return publicoDAO.listarDetalleProximasSalidasDestino(idOrigen,idDestino);
	}
	@Override
	@Transactional(readOnly = true)
	public List<DestinosFrecuencia> listarDestinosFrecuencia(){  		
		return publicoDAO.listarDestinosFrecuencia();
	}
	@Override
	@Transactional(readOnly = true)
	public List<CooperativasFrecPorDestino> listarCooperativasFrecPorDestino(Long idDestino)
	{
		return publicoDAO.listarCooperativasFrecPorDestino(idDestino);
	}
	@Override
	@Transactional(readOnly = true)
	public List<HorarioCooperativaPorDestino> listarHorarioCoopPorDestino(Long idDestino,Long idCooperativa)
	{
		return publicoDAO.listarHorarioCoopPorDestino(idDestino, idCooperativa);
	}
	@Override
	@Transactional(readOnly = true)
	public List<MultasPorPlacaUnidadT> listarMultaPorPlacaUnidadT(String placaUnidadTransporte)
	{
		return publicoDAO.listarMultaPorPlacaUnidadT(placaUnidadTransporte);
	}
	@Override
	@Transactional(readOnly = true)
	public List<DestinosCoopIntercantonal> listarDestinosCoopIntercantonal()
	{
		return publicoDAO.listarDestinosCoopIntercantonal();
	}
	@Override
	@Transactional(readOnly = true)
	public List<DestinosCoopIntercantonal> listarDestinosCoopInterparroquial()
	{
		return publicoDAO.listarDestinosCoopInterparroquial();
	}
	@Override
	@Transactional(readOnly = true)
	public AreaTransferencia getAreaTransferenciaPorNombre(String nombreAreaTransferencia)
	{
		return publicoDAO.getAreaTransferenciaPorNombre(nombreAreaTransferencia);
	}
	@Override
	@Transactional(readOnly = true)
	public List<AreaTransferencia> getNombresAreaTransferencia()
	{
		return publicoDAO.getNombresAreaTransferencia();
	}
	@Override
	@Transactional(readOnly = true)
	public Institucion getInfoInstitucion()
	{
		return publicoDAO.getInfoInstitucion();
	}
	@Override
	@Transactional(readOnly = true)
	 public Institucion getPlanificacionEstrategica()
	 {
		return publicoDAO.getPlanificacionEstrategica(); 
	 }
	@Override
	@Transactional(readOnly = true)
	 public Institucion getCoordenadasInstalacionesInstitucion()
	 {
		return publicoDAO.getCoordenadasInstalacionesInstitucion();
	 }
	@Override
	@Transactional(readOnly = true)
	public List<ComunicadoNoticia> listarComunicados()
	{
		return publicoDAO.listarComunicados();
	}
	@Override
	@Transactional(readOnly = true)
	public ComunicadoNoticia getComunicadoNoticiaPorId(String tipo, Integer id)
	{
		return publicoDAO.getComunicadoNoticiaPorId(tipo, id);
	}
	@Override
	@Transactional(readOnly = true)
	public List<LetraInicialCooperativa> getLetraInicialCooperativa()
	{
		return publicoDAO.getLetraInicialCooperativa();
	}
	@Override
	@Transactional(readOnly = true)
	public List<DetalleCooperativa> getDetalleCooperativa()
	{
		return publicoDAO.getDetalleCooperativa();
	}
	@Override
	@Transactional(readOnly = true)
	public List<DetalleCooperativa> getCooperativasTrabajanTerminal()
	{
		return publicoDAO.getCooperativasTrabajanTerminal();
	}
	@Override
	@Transactional(readOnly = true)
	public Recurso getRecursoPorNombre(String nombreRecurso)
	{
		return publicoDAO.getRecursoPorNombre(nombreRecurso);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Recurso> getSlides()
	{
		return publicoDAO.getSlides();
	}
	@Override
	@Transactional(readOnly = true)
	public List<ComunicadoNoticia> getUltimas4Noticias()
	{
		return publicoDAO.getUltimas4Noticias();
	}
	@Override
	@Transactional(readOnly = true)
	public List<ComunicadoNoticia> getTitularesNoticias()
	{
		return publicoDAO.getTitularesNoticias();
	}
	@Override
	@Transactional(readOnly = true)
	public ComunicadoNoticia getNoticiaPrincipal()
	{
		return publicoDAO.getNoticiaPrincipal();
	}
	@Override
	@Transactional(readOnly = true)
	public List<PreguntaGlosario> getPreguntaGlosario(String tipo)
	{
		return publicoDAO.getPreguntaGlosario(tipo);
	}
	@Override
	@Transactional(readOnly = true)
	public List<TramiteTransportista> getTramiteTransportista()
	{
		return publicoDAO.getTramiteTransportista();
	}
	@Override
	@Transactional(readOnly = true)
	 public List<PreguntaFrecuente> getPreguntasFrecuentes()
	 {
		return publicoDAO.getPreguntasFrecuentes();
	}
	@Override
	@Transactional(readOnly = true)
	 public List<TarifaTransporte> getTarifaTransporte()
	 {
		return publicoDAO.getTarifaTransporte();
	 }
	
	
}
