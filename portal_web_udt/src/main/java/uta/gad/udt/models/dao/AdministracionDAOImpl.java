package uta.gad.udt.models.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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
@Repository
public class AdministracionDAOImpl implements AdministracionDAO{
	private static final Logger logger = LoggerFactory.getLogger(AdministracionDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public Institucion getInfoInstitucion() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query callStoredProcedure = session.getNamedQuery("getInstitucion");
		
    	List<Institucion> results= (List<Institucion>)callStoredProcedure.list();	
       
        Institucion institucion=null;
        try
    	{
        	institucion = results.get(0);
    	}catch(java.lang.IndexOutOfBoundsException ex)
    	{
    		institucion = null;
    	}           
        session.close();
        return institucion; 
	}
	@Override
    public int updateInstitucion(Institucion institucion)
    {
		return CRUDGeneric(institucion,"s");
    }

	@Override
	public int saveServicio(Servicio servicio) {
		return CRUDGeneric(servicio,"s");
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> getServicios() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query callStoredProcedure = session.getNamedQuery("listarServicios");	
    	List<Servicio> results= (List<Servicio>)callStoredProcedure.list();	    
        session.close();
        return results; 
	}
	
	@Override
	public int deleteServicio(Servicio servicio)
    {
		return CRUDGeneric(servicio,"d");	
    }
	
	@Override
	public Servicio getServicio(short idServicio)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Servicio servicio = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	servicio = (Servicio)session.get(Servicio.class,idServicio);
		tx.commit();
		session.close();
		return servicio;	
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<ComunicadoNoticia> getComunicadoNoticia() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<ComunicadoNoticia> results= session.getNamedQuery("listarComunicadoNoticia").setResultTransformer(Transformers.aliasToBean(ComunicadoNoticia.class)).list();    
    	for (ComunicadoNoticia comunicadoNoticia : results) {
		if(!comunicadoNoticia.getImagen().trim().equals("no-image"))
		{
			try {
				Pattern p = Pattern.compile("src=\"(.*?)\"");
				    Matcher m = p.matcher(comunicadoNoticia.getImagen());
				    if (m.find()) {
				    	comunicadoNoticia.setImagen(m.group(1));
				    	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
       }
    	session.close();
        return results; 
	}
	@Override
	public ComunicadoNoticia getComunicadoNoticiaById(int id)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	ComunicadoNoticia comunicadoNoticia = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	comunicadoNoticia = (ComunicadoNoticia)session.get(ComunicadoNoticia.class,id);
		tx.commit();
		session.close();
		return comunicadoNoticia;
    }
	@Override
	public int saveComunicadoNoticia(ComunicadoNoticia comunicadoNoticia) {
		return CRUDGeneric(comunicadoNoticia,"s");
	}
	@Override
	public int deleteComunicadoNoticia(ComunicadoNoticia comunicadoNoticia)
    {
		return CRUDGeneric(comunicadoNoticia,"d");
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Recurso> getRecursos()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query callStoredProcedure = session.getNamedQuery("listarRecursos");	
    	List<Recurso> results= (List<Recurso>)callStoredProcedure.list();	    
        session.close();
        return results; 
	}
	@Override
	public Recurso getRecursosById(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Recurso recurso = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	recurso = (Recurso)session.get(Recurso.class,id);
		tx.commit();
		session.close();
		return recurso;
	}
	@Override
	public int saveRecurso(Recurso recurso)
	{
		return CRUDGeneric(recurso,"s");
	}
	@Override
	public int deleteRecurso(Recurso recurso)
	{
		return CRUDGeneric(recurso,"d");	
	}
	public int CRUDGeneric(Object object,String crudOperacion)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
        int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	switch (crudOperacion) {
		case "d":
			session.delete(object);
			break;
		case "s":
			session.saveOrUpdate(object);
			break;
		default:
			break;
		}	
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleCooperativa> getDirectorioCooperativa()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DetalleCooperativa> results = session.getNamedQuery("listarDirectorioCooperativa").setResultTransformer(Transformers.aliasToBean(DetalleCooperativa.class)).list();	   
        session.close();
        return results; 
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CooperativaConProximasSalidas> getNombresCooperativas()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CooperativaConProximasSalidas> results = session.getNamedQuery("nombresCooperativas").setResultTransformer(Transformers.aliasToBean(CooperativaConProximasSalidas.class)).list();	   
        session.close();
        return results; 
	}
	@Override
	public int saveDirectorioCooperativa(DetalleCooperativa detalleCooperativa)
	{
		return CRUDGeneric(detalleCooperativa,"s");
	}
	@Override
	public int deleteDirectorioCooperativa(DetalleCooperativa detalleCooperativa)
	{
		return CRUDGeneric(detalleCooperativa,"d");	
	}
	@Override
	public DetalleCooperativa getDetalleCooperativaById(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		DetalleCooperativa detalleCoop = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	detalleCoop = (DetalleCooperativa)session.get(DetalleCooperativa.class,id);
		tx.commit();
		session.close();
		return detalleCoop;
	}
	@SuppressWarnings("unchecked")
	@Override	
	public List<AreaTransferencia> getAreasTransferencia()
	{
        Session session = HibernateUtil.getSessionFactory().openSession();
		List<AreaTransferencia> results = session.getNamedQuery("getAreasTransferencia").setResultTransformer(Transformers.aliasToBean(AreaTransferencia.class)).list();	   
        session.close();
        return results;
	}
	@Override
	public AreaTransferencia getAreaTransferenciaById(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		AreaTransferencia areaTransferencia = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	areaTransferencia = (AreaTransferencia)session.get(AreaTransferencia.class,id);
		tx.commit();
		session.close();
		return areaTransferencia;
	}
	@Override
	public int saveAreaTransferencia(AreaTransferencia areaTransferencia){
		return CRUDGeneric(areaTransferencia,"s");
	}
	@Override
	public int deleteAreaTransferencia(AreaTransferencia areaTransferencia)
	{
		return CRUDGeneric(areaTransferencia,"d");	
	}
	@Override
	public TramiteTransportista getTramiteTransportistaById(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		TramiteTransportista tramiteTransportista = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	tramiteTransportista = (TramiteTransportista)session.get(TramiteTransportista.class,id);
		tx.commit();
		session.close();
		return tramiteTransportista;
	}
	@Override
	public int saveTramiteTransportista(TramiteTransportista tramite)
	{
		return CRUDGeneric(tramite,"s");
	}
	@Override
	public int deleteTramiteTransportista(TramiteTransportista tramite)
	{
		return CRUDGeneric(tramite,"d");	
	}
	@Override
	public PreguntaFrecuente getPreguntaFrecuenteById(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		PreguntaFrecuente preguntaFrecuente = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	preguntaFrecuente = (PreguntaFrecuente)session.get(PreguntaFrecuente.class,id);
		tx.commit();
		session.close();
		return preguntaFrecuente;
	}
	@Override
	public int savePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente)
	{
		return CRUDGeneric(preguntaFrecuente,"s");
	}
	@Override
	public int deletePreguntaFrecuente(PreguntaFrecuente preguntaFrecuente)
	{
		return CRUDGeneric(preguntaFrecuente,"d");	
	}
	@Override
	public TarifaTransporte getTarifaTransporteById(int id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		TarifaTransporte tarifaTransporte = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	tarifaTransporte = (TarifaTransporte)session.get(TarifaTransporte.class,id);
		tx.commit();
		session.close();
		return tarifaTransporte;
	}
	@Override
	public int saveTarifaTransporte(TarifaTransporte tarifaTransporte)
	{
		return CRUDGeneric(tarifaTransporte,"s");
	}
	@Override
	public int deleteTarifaTransporte(TarifaTransporte tarifaTransporte)
	{
		return CRUDGeneric(tarifaTransporte,"d");
	}
	@SuppressWarnings("unchecked")
	@Override	
	public List<DestinosFrecuencia> getNombresDestinos()
	{
		 	Session session = HibernateUtil.getSessionFactory().openSession();
			List<DestinosFrecuencia> results = session.getNamedQuery("getNombresDestinos").setResultTransformer(Transformers.aliasToBean(DestinosFrecuencia.class)).list();	   
	        session.close();
	        return results;
	}
	@Override
	public int updateConfigMail(ConfigMail configmail)
	{
		Properties prop = new Properties();
		OutputStream output = null;
		int resultado = 0;

		try {

			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty("host", configmail.getHost());
			prop.setProperty("port", configmail.getPort());
			prop.setProperty("username", configmail.getUsername());
			prop.setProperty("password", configmail.getPassword());
System.out.print("PENDEJO :)");
			// save properties to project root folder
			prop.store(output, null);
			resultado = 1;

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return resultado;
	}
	@Override
	public Link getLinkInteresById(short id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Link linkInteres = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	linkInteres = (Link)session.get(Link.class,id);
		tx.commit();
		session.close();
		return linkInteres;
	}
	@Override
	public int saveLinkInteres(Link linkInteres)
	{
		return CRUDGeneric(linkInteres,"s");
	}
	@Override
	public int deleteLinkInteres(Link linkInteres)
	{
		return CRUDGeneric(linkInteres,"d");
	}
	@Override
	public Usuario getUsuarioById(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	usuario = (Usuario)session.get(Usuario.class,id);
		tx.commit();
		session.close();
		logger.debug("USUARIO: "+usuario.getIdUsuario()+" "+usuario.getCiRuc()+
				" "+usuario.getNombre()+" "+usuario.getUsuario()+" "+
				usuario.getClave()+" "+usuario.getEstado()+" "+
				usuario.getPerfil().getIdPerfil()+" "+usuario.getFechaActivo()+" "+
				usuario.isActivo()+" "+usuario.getModuloDefecto()+
				" nombre perfil: "+usuario.getPerfil().getNombre());
		return usuario;
	}
	@Override
	public Perfil getPerfilById(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Perfil perfil = null;
    	Transaction tx = session.getTransaction();
    	tx.begin();
    	perfil = (Perfil)session.get(Perfil.class,id);
		tx.commit();
		session.close();
		logger.debug("PERFIL: "+perfil.getIdPerfil()+" "+
				perfil.getNombre()+" "+perfil.getDescripcion());
		return perfil;
	}
	@Override
	public Usuario getUsuarioByUserName(String username)
	{
		//Criteria hibernate (used here)
		//https://examples.javacodegeeks.com/enterprise-java/hibernate/retrieve-record-in-hibernate-with-criteria/	
	        Session session=null;
	        Usuario usuario = null;
	        try {
	        	session = HibernateUtil.getSessionFactory().openSession();	    		
	        	Transaction tx = session.getTransaction();
	        	tx.begin();	        	
				Criteria criteria = session.createCriteria(Usuario.class);
				criteria.add(Restrictions.eq("usuario", username));				
				usuario = (Usuario) criteria.uniqueResult();				
				if (usuario!=null) {
					System.out.println("USUARIO found:");
					logger.debug("USUARIO: "+usuario.getIdUsuario()+" "+usuario.getCiRuc()+
		    				" "+usuario.getNombre()+" "+usuario.getUsuario()+" "+
		    				usuario.getClave()+" "+usuario.getEstado()+" "+
		    				usuario.getPerfil().getIdPerfil()+" "+usuario.getFechaActivo()+" "+
		    				usuario.isActivo()+" "+usuario.getModuloDefecto()+" nombre perfil: "+usuario.getPerfil().getNombre());		        		
				}			
				tx.commit();
				session.close();
			}
			catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}			
		return usuario;
	}
	@Override
	public int saveUsuario(Usuario usuario)
	{
		return CRUDGeneric(usuario,"s");
	}
	
}
