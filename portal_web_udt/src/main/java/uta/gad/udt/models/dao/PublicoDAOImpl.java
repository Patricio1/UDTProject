package uta.gad.udt.models.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;






import uta.gad.udt.models.entity.AgruparHorario;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class PublicoDAOImpl implements PublicoDAO{
	private static final Logger logger = LoggerFactory.getLogger(PublicoDAOImpl.class);
//	@Autowired
   // private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private AgruparHorario agruparHorario;
    @SuppressWarnings("unchecked")
	@Override	
	public List<Link> listarLinksInteres() {    	    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	    	
    	Query callStoredProcedure = session.getNamedQuery("listarLinks");
		
    	List<Link> results= (List<Link>)callStoredProcedure.list();
    	session.close();
    	
    	return results;        	
	}
    
    @SuppressWarnings("unchecked")
	@Override
   	public List<Servicio>listarServicios()
   	{
    	/**Session session = HibernateUtil.getSessionFactory().openSession();    	 	     
     	    	
     	Query callStoredProcedure = session.getNamedQuery("listarServicios");
 		
     	List<Servicio> results= (List<Servicio>)callStoredProcedure.list();
     	session.close();*/
    	 Session session = HibernateUtil.getSessionFactory().openSession();
         List<Servicio> result = session.getNamedQuery("getServicios").setResultTransformer(Transformers.aliasToBean(Servicio.class)).list();                           	  
         session.close();
     	return result;  
   	}
   
    @SuppressWarnings("unchecked")
	@Override
	 public List<CooperativaConProximasSalidas> listarCoopConProximasSalidas() {   	    		
   		         
         Session session = HibernateUtil.getSessionFactory().openSession();         
         List<CooperativaConProximasSalidas> result = session.getNamedQuery("listarCoopProximasSalidas").setResultTransformer(Transformers.aliasToBean(CooperativaConProximasSalidas.class)).list();
         session.close();
         return result;
    }
    @SuppressWarnings("unchecked")
   	@Override
   	public List<DestinosConProximasSalidas> listarDestinosConProximasSalidas(){   	    		
    	Session session = HibernateUtil.getSessionFactory().openSession();	         
            List<DestinosConProximasSalidas> result = session.getNamedQuery("listarDestinosProximasSalidas").setResultTransformer(Transformers.aliasToBean(DestinosConProximasSalidas.class)).list();
            session.close();
         	 return result;
       }
   
   @SuppressWarnings("unchecked")
   	@Override
    public List<DetalleProximasSalidasDestino> listarDetalleProximasSalidasDestino(Long idOrigen,Long idDestino){   	    		             
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<DetalleProximasSalidasDestino> result = session.getNamedQuery("detalleProximasSalidasPorDestino").setParameter("ID_ORIGEN", idOrigen).setParameter("ID_DESTINO",idDestino).setResultTransformer(Transformers.aliasToBean(DetalleProximasSalidasDestino.class)).list();
            session.close(); 
            return result;
       }
    @SuppressWarnings("unchecked")
	@Override
   	public List<ProximaSalidaCooperativa> listarProximasSalidas() {   	    		   		
         Session session = HibernateUtil.getSessionFactory().openSession();         
         List<ProximaSalidaCooperativa> result = session.getNamedQuery("listarProximasSalidas").setParameter("ID_COOPERATIVA", 1012).setResultTransformer(Transformers.aliasToBean(ProximaSalidaCooperativa.class)).list();
         session.close();
         return result;                                   	       	               
   	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<DestinosFrecuencia> listarDestinosFrecuencia() {   	    		      		
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<DestinosFrecuencia> result = session.getNamedQuery("listarDestinosFrecuencias").setResultTransformer(Transformers.aliasToBean(DestinosFrecuencia.class)).list();
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public List<CooperativasFrecPorDestino> listarCooperativasFrecPorDestino(Long idDestino) {   	    		      
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<CooperativasFrecPorDestino> result = session.getNamedQuery("listarCooperativasFrecPorDestino").setParameter("ID_DESTINO", idDestino).setResultTransformer(Transformers.aliasToBean(CooperativasFrecPorDestino.class)).list();           
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public List<HorarioCooperativaPorDestino> listarHorarioCoopPorDestino(Long idDestino,Long idCooperativa) {   	    		      
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<HorarioCooperativaPorDestino> result = session.getNamedQuery("listarHorariosCooperativa").setParameter("ID_DESTINO", idDestino).setParameter("ID_COOPERATIVA", idCooperativa).setResultTransformer(Transformers.aliasToBean(HorarioCooperativaPorDestino.class)).list();
            List<HorarioCooperativaPorDestino>  horarioOrdenado = agruparHorario.ordenarYagruparHorario(result);
            session.close();
            return horarioOrdenado;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public List<MultasPorPlacaUnidadT> listarMultaPorPlacaUnidadT(String placaUnidadTransporte) {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<MultasPorPlacaUnidadT> result = session.getNamedQuery("listarMultasPorPlaca").setParameter("PLACA_UNIDAD", placaUnidadTransporte).setResultTransformer(Transformers.aliasToBean(MultasPorPlacaUnidadT.class)).list();            
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public List<DestinosCoopIntercantonal> listarDestinosCoopIntercantonal() {   	    		     
            Session session = AmericaHibernateUtil.getSessionFactory().openSession();         
            List<DestinosCoopIntercantonal> result = session.getNamedQuery("listarDestinosCoopIntercantonal").setResultTransformer(Transformers.aliasToBean(DestinosCoopIntercantonal.class)).list();            
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public List<DestinosCoopIntercantonal> listarDestinosCoopInterparroquial() {   	    		      	
            Session session = CashapambaHibernateUtil.getSessionFactory().openSession();         
            List<DestinosCoopIntercantonal> result = session.getNamedQuery("listarDestinosCoopIntercantonal").setResultTransformer(Transformers.aliasToBean(DestinosCoopIntercantonal.class)).list();            
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public AreaTransferencia getAreaTransferenciaPorNombre(String nombreAreaTransferencia) {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();                     
            Query callStoredProcedure = session.getNamedQuery("listarAreaTransferencia").setParameter("NOMBRE", nombreAreaTransferencia);        	
        	List<AreaTransferencia> result= (List<AreaTransferencia>)callStoredProcedure.list();
        	 AreaTransferencia area = null;
        	try
        	{
        		area = result.get(0);
        	}catch(java.lang.IndexOutOfBoundsException ex)
        	{
        		 area = null;
        	}
        	session.close();
         	return area;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public  List<AreaTransferencia> getNombresAreaTransferencia() {   	    		      
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<AreaTransferencia> result = session.getNamedQuery("getNombresAreaTransferencia").setResultTransformer(Transformers.aliasToBean(AreaTransferencia.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
 
    @SuppressWarnings("unchecked")
   	@Override
    public Institucion getInfoInstitucion() {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<Institucion> result = session.getNamedQuery("getInfoInstitucion").setResultTransformer(Transformers.aliasToBean(Institucion.class)).list();            
            Institucion institucion=null;
            try
        	{
            	institucion = result.get(0);
        	}catch(java.lang.IndexOutOfBoundsException ex)
        	{
        		institucion = null;
        	}           
            session.close();
            return institucion;                                            	       	              
      	}
    @SuppressWarnings("unchecked")
    @Override
    public Institucion getPlanificacionEstrategica()
    {
    	 Session session = HibernateUtil.getSessionFactory().openSession();         
         List<Institucion> result = session.getNamedQuery("getPlanificacionEstrategica").setResultTransformer(Transformers.aliasToBean(Institucion.class)).list();            
         Institucion institucion=null;
         try
     	{
         	institucion = result.get(0);
     	}catch(java.lang.IndexOutOfBoundsException ex)
     	{
     		institucion = null;
     	}           
         session.close();
         return institucion;
    }
    @SuppressWarnings("unchecked")
    @Override
    public Institucion getCoordenadasInstalacionesInstitucion()
    {
    	 Session session = HibernateUtil.getSessionFactory().openSession();         
         List<Institucion> result = session.getNamedQuery("getCoordenadas").setResultTransformer(Transformers.aliasToBean(Institucion.class)).list();            
         Institucion institucion=null;
         try
     	{
         	institucion = result.get(0);
     	}catch(java.lang.IndexOutOfBoundsException ex)
     	{
     		institucion = null;
     	}           
         session.close();
         return institucion;
    }
    @SuppressWarnings("unchecked")
   	@Override
   	public List<ComunicadoNoticia> listarComunicados() {   	    		    
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<ComunicadoNoticia> result = session.getNamedQuery("listarComunicados").setResultTransformer(Transformers.aliasToBean(ComunicadoNoticia.class)).list();                           	  
           
          /**  for (ComunicadoNoticia cm : result) {
				ImageExtractor im = new ImageExtractor();
				try {
					logger.debug("IMAGEN: "+im.extractImageUrl(cm.getContenido()));
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public ComunicadoNoticia getComunicadoNoticiaPorId(String tipo, Integer id) {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();         
            List<ComunicadoNoticia> result = session.getNamedQuery("getComunicadoNoticiaPorId")
            		.setParameter("TIPO", tipo)
            		.setParameter("ID", id)
            		.setResultTransformer(Transformers.aliasToBean(ComunicadoNoticia.class)).list();            
            ComunicadoNoticia comunicadoNoticia=null;
            try
        	{
            	comunicadoNoticia = result.get(0);
        	}catch(java.lang.IndexOutOfBoundsException ex)
        	{
        		comunicadoNoticia = null;
        	}           
            session.close();
            return comunicadoNoticia;                                            	       	              
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<LetraInicialCooperativa> getLetraInicialCooperativa() {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<LetraInicialCooperativa> result = session.getNamedQuery("listarLetraInicialCooperativa").setResultTransformer(Transformers.aliasToBean(LetraInicialCooperativa.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<DetalleCooperativa> getDetalleCooperativa() {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<DetalleCooperativa> result = session.getNamedQuery("detalleCooperativa").setResultTransformer(Transformers.aliasToBean(DetalleCooperativa.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<DetalleCooperativa> getCooperativasTrabajanTerminal() {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<DetalleCooperativa> result = session.getNamedQuery("cooperativasTrabajanTerminal").setResultTransformer(Transformers.aliasToBean(DetalleCooperativa.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public Recurso getRecursoPorNombre(String nombreRecurso) {   	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Recurso> result = session.getNamedQuery("getrecurso")
            		.setParameter("NOMBRE", nombreRecurso)
            		.setResultTransformer(Transformers.aliasToBean(Recurso.class)).list();            
            Recurso recurso=null;
            try
        	{
            	recurso = result.get(0);
        	}catch(java.lang.IndexOutOfBoundsException ex)
        	{
        		recurso = null;
        	}                                      	  
            session.close();
            return recurso;                                   	       	               
      	} 
    @SuppressWarnings("unchecked")
   	@Override
    public List<Recurso> getSlides(){  	    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Recurso> result = session.getNamedQuery("getSlides").setResultTransformer(Transformers.aliasToBean(Recurso.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<ComunicadoNoticia> getUltimas4Noticias(){    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<ComunicadoNoticia> result = session.getNamedQuery("getUltimas4Noticias").setResultTransformer(Transformers.aliasToBean(ComunicadoNoticia.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<ComunicadoNoticia> getTitularesNoticias(){    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<ComunicadoNoticia> result = session.getNamedQuery("getTitularesNoticias").setResultTransformer(Transformers.aliasToBean(ComunicadoNoticia.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    
    @SuppressWarnings("unchecked")
   	@Override
    public ComunicadoNoticia getNoticiaPrincipal(){    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<ComunicadoNoticia> result = session.getNamedQuery("getNoticiaPrincipal").setResultTransformer(Transformers.aliasToBean(ComunicadoNoticia.class)).list();                           	  
            ComunicadoNoticia noticia=null;
            try
        	{
            	noticia = result.get(0);
        	}catch(java.lang.IndexOutOfBoundsException ex)
        	{
        		noticia = null;
        	}                                      	  
            session.close();
            return noticia;    
      	}
    @SuppressWarnings("unchecked")
   	@Override
   	public List<PreguntaGlosario> getPreguntaGlosario(String tipo){    		      	
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<PreguntaGlosario> result = session.getNamedQuery("listarPreguntaGlosario")
            		.setParameter("TIPO", tipo)
            		.setResultTransformer(Transformers.aliasToBean(PreguntaGlosario.class)).list();                           	  
            session.close();
            return result;                                   	       	               
      	}
    @SuppressWarnings("unchecked")
   	@Override
    public List<TramiteTransportista> getTramiteTransportista()
    {
    	  Session session = HibernateUtil.getSessionFactory().openSession();
          List<TramiteTransportista> result = session.getNamedQuery("listarTramites").setResultTransformer(Transformers.aliasToBean(TramiteTransportista.class)).list();                           	  
          session.close();
          return result;   
    }
    @SuppressWarnings("unchecked")
   	@Override
    public List<PreguntaFrecuente> getPreguntasFrecuentes()
    {
    	  Session session = HibernateUtil.getSessionFactory().openSession();
          List<PreguntaFrecuente> result = session.getNamedQuery("listarPreguntasFrecuentes").setResultTransformer(Transformers.aliasToBean(PreguntaFrecuente.class)).list();                           	  
          session.close();
          return result;   
    }
    @SuppressWarnings("unchecked")
   	@Override
    public List<TarifaTransporte> getTarifaTransporte()
    {
  	  	Session session = HibernateUtil.getSessionFactory().openSession();
        List<TarifaTransporte> result = session.getNamedQuery("listarTarifas").setResultTransformer(Transformers.aliasToBean(TarifaTransporte.class)).list();                           	  
        session.close();
        return result;  
    }
}
