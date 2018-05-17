package uta.gad.udt.models.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uta.gad.udt.models.dao.AdministracionDAO;
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

@Service("administracionService")
public class AdministracionServiceImpl implements AdministracionService {

	@Autowired
	private AdministracionDAO administracionDAO; 
	
	@Override
	 public int updateInstitucion(Institucion institucion)
	{
		return administracionDAO.updateInstitucion(institucion);
	}
	@Override
	@Transactional(readOnly = true)
	public Institucion getInfoInstitucion() {
		return administracionDAO.getInfoInstitucion();
	}
	
	@Override
	public List<Servicio> getServicios() {
		return administracionDAO.getServicios();
	}
	@Override
	public int deleteServicio(Servicio servicio) {
		return administracionDAO.deleteServicio(servicio);
	}
	
	@Override
	public Servicio getServicio(short idServicio) {
		return administracionDAO.getServicio(idServicio);
	}
	@Override
	public int saveServicio(Servicio servicio) {
		return administracionDAO.saveServicio(servicio);
	}
	
	
	@Override
	public List<ComunicadoNoticia> getComunicadoNoticia() {
		return administracionDAO.getComunicadoNoticia();
	}
	@Override
	public ComunicadoNoticia getComunicadoNoticiaById(int id) {
		return administracionDAO.getComunicadoNoticiaById(id);
	}
	@Override
	public int saveComunicadoNoticia(ComunicadoNoticia comunicadoNoticia) {
		return administracionDAO.saveComunicadoNoticia(comunicadoNoticia);
	}
	@Override
	public int deleteComunicadoNoticia(ComunicadoNoticia comunicadoNoticia) {
		return administracionDAO.deleteComunicadoNoticia(comunicadoNoticia);
	}
	
	
	@Override
	public List<Recurso> getRecursos() {
		return administracionDAO.getRecursos();
	}
	@Override
	public Recurso getRecursosById(int id) {
		return administracionDAO.getRecursosById(id);
	}
	@Override
	public int saveRecurso(Recurso recurso) {
		return administracionDAO.saveRecurso(recurso);
	}
	@Override
	public int deleteRecurso(Recurso recurso) {
		return administracionDAO.deleteRecurso(recurso);
	}
	
	@Override
	@Transactional
    public void deleteFile(String pathRecurso)
    {
         try { 
             File file = new File(pathRecurso);
             if(file.delete()) { 
                System.out.println(file.getName() + " ha sido eliminado!");
             } else {
                System.out.println("Operacion eliminar ha fallado.");
                }
          }
            catch(Exception e)
            {
                System.out.println("Fallo eliminar archivo !!");
            }
    }
	
	@Override
	public List<DetalleCooperativa> getDirectorioCooperativa()
	{
		return administracionDAO.getDirectorioCooperativa();
	}
	@Override
	public List<CooperativaConProximasSalidas> getNombresCooperativas()
	{
		return administracionDAO.getNombresCooperativas();
	}
	@Override
	public int saveDirectorioCooperativa(DetalleCooperativa detalleCooperativa)
	{
		return administracionDAO.saveDirectorioCooperativa(detalleCooperativa);
	}
	@Override
	public int deleteDirectorioCooperativa(DetalleCooperativa detalleCooperativa)
	{
		return administracionDAO.deleteDirectorioCooperativa(detalleCooperativa);
	}
	@Override
	public DetalleCooperativa getDetalleCooperativaById(int id)
	{
		return administracionDAO.getDetalleCooperativaById(id);
	}
	@Override
	public List<AreaTransferencia> getAreasTransferencia()
	{
		return administracionDAO.getAreasTransferencia();
	}
	@Override
	public AreaTransferencia getAreaTransferenciaById(int id)
	{
		return administracionDAO.getAreaTransferenciaById(id);
	}
	@Override
	public int saveAreaTransferencia(AreaTransferencia areaTransferencia)
	{
		return administracionDAO.saveAreaTransferencia(areaTransferencia);
	}
	@Override
	public int deleteAreaTransferencia(AreaTransferencia areaTransferencia)
	{
		return administracionDAO.deleteAreaTransferencia(areaTransferencia);
	}
	@Override
	public TramiteTransportista getTramiteTransportistaById(int id)
	{
		return administracionDAO.getTramiteTransportistaById(id);
	}
	@Override
	public int saveTramiteTransportista(TramiteTransportista tramite)
	{
		return administracionDAO.saveTramiteTransportista(tramite);
	}
	@Override
	public int deleteTramiteTransportista(TramiteTransportista tramite)
	{
		return administracionDAO.deleteTramiteTransportista(tramite);
	}
	@Override
	public PreguntaFrecuente getPreguntaFrecuenteById(int id)
	{
		return administracionDAO.getPreguntaFrecuenteById(id);
	}
	@Override
	public int savePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente)
	{
		return administracionDAO.savePreguntaFrecuente(preguntaFrecuente);
	}
	@Override
	public int deletePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente)
	{
		return administracionDAO.deletePreguntaFrecuente(preguntaFrecuente);
	}
	@Override
	public TarifaTransporte getTarifaTransporteById(int id)
	{
		return administracionDAO.getTarifaTransporteById(id);
	}
	@Override
	public int saveTarifaTransporte(TarifaTransporte tarifaTransporte)
	{
		return administracionDAO.saveTarifaTransporte(tarifaTransporte);
	}
	@Override
	public int deleteTarifaTransporte(TarifaTransporte tarifaTransporte)
	{
		return administracionDAO.deleteTarifaTransporte(tarifaTransporte);
	}
	@Override
	public List<DestinosFrecuencia> getNombresDestinos()
	{
		return administracionDAO.getNombresDestinos();
	}
	@Override
	public int updateConfigMail(ConfigMail configmail)
	{
		return administracionDAO.updateConfigMail(configmail);
	}
	@Override
	public Link getLinkInteresById(short id)
	{
		return administracionDAO.getLinkInteresById(id);
	}
	@Override
	public int saveLinkInteres(Link linkInteres)
	{
		return administracionDAO.saveLinkInteres(linkInteres);
	}
	@Override
	public int deleteLinkInteres(Link linkInteres)
	{
		return administracionDAO.deleteLinkInteres(linkInteres);
	}
	@Override
	public Usuario getUsuarioById(long id)
	{
		return administracionDAO.getUsuarioById(id);
	}
	@Override
	public int saveUsuario(Usuario usuario)
	{
		return administracionDAO.saveUsuario(usuario);
	}
	@Override
	public Perfil getPerfilById(long id)
	{
		return administracionDAO.getPerfilById(id);
	}
	@Override
	public Usuario getUsuarioByUserName(String username)
	{
		return administracionDAO.getUsuarioByUserName(username);
	}
}
