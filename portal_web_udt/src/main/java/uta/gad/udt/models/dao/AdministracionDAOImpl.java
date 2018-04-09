package uta.gad.udt.models.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;
@Repository
public class AdministracionDAOImpl implements AdministracionDAO{

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
	
	
}
