package uta.gad.udt.models.dao;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.spi.ExtractedDatabaseMetaData;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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
    public void updateInstitucion(Institucion institucion)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
   	 	tx.begin();
   	 	session.update(institucion);
   	 	tx.commit();
		session.close();
    }

   	@Override
    public void addLink(Link link)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.getTransaction();
    	 tx.begin();
		session.saveOrUpdate(link);
		tx.commit();
		session.close();
		logger.info("Link add ok, Link Details="+link);
		
    }
	/**@Override
	public int addServicio(Servicio servicio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.save(servicio);
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;
	}*/
	@Override
	public int saveServicio(Servicio servicio) {
		/**Session session = HibernateUtil.getSessionFactory().openSession();
	    int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.saveOrUpdate(servicio);
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;*/
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
    	/**Session session = HibernateUtil.getSessionFactory().openSession();
        int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.delete(servicio);
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;*/
		return CRUDGeneric(servicio,"d");
		
    }
	
	/**@Override
	public int updateServicio(Servicio servicio)
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.update(servicio);
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;
		
		
    }*/
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
        Query callStoredProcedure = session.getNamedQuery("listarComunicadoNoticia");	
    	List<ComunicadoNoticia> results= (List<ComunicadoNoticia>)callStoredProcedure.list();	    
 
    	for (ComunicadoNoticia comunicadoNoticia : results) {
		if(!comunicadoNoticia.getImagen().trim().equals("no-image"))
		{
			try {
				//logger.debug("jajajaja: "+img.extractImageUrl(comunicadoNoticia.getImagen()));
				 Pattern p = Pattern.compile("src=\"(.*?)\"");
				    Matcher m = p.matcher(comunicadoNoticia.getImagen());
				    if (m.find()) {
				    	logger.debug("jajajaja: "+m.group(1));
				    	comunicadoNoticia.setImagen(m.group(1));
				    	// prints http://www.01net.com/images/article/mea/150.100.790233.jpg
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
		/**Session session = HibernateUtil.getSessionFactory().openSession();
	    int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.saveOrUpdate(comunicadoNoticia);
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;*/
		return CRUDGeneric(comunicadoNoticia,"s");
	}
	@Override
	public int deleteComunicadoNoticia(ComunicadoNoticia comunicadoNoticia)
    {
    	/**Session session = HibernateUtil.getSessionFactory().openSession();
        int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.delete(comunicadoNoticia);
    	
		resultado = 1;
		tx.commit();
		session.close();
		return resultado;	*/	
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
		/**Session session = HibernateUtil.getSessionFactory().openSession();
	    int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.saveOrUpdate(recurso);
		resultado = 1;
		tx.commit();
		session.close();*/
		return CRUDGeneric(recurso,"s");
	}
	@Override
	public int deleteRecurso(Recurso recurso)
	{
	/**	Session session = HibernateUtil.getSessionFactory().openSession();
        int resultado = 0;
    	Transaction tx = session.getTransaction();
    	tx.begin();
		session.delete(recurso);
		resultado = 1;
		tx.commit();
		session.close();*/
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
	public int saveTarifaTransporte(TarifaTransporte tarifaTransporte)
	{
		return CRUDGeneric(tarifaTransporte,"s");
	}
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
	
}
