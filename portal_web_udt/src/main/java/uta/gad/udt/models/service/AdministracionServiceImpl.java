package uta.gad.udt.models.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uta.gad.udt.models.dao.AdministracionDAO;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;

@Service("administracionService")
public class AdministracionServiceImpl implements AdministracionService {

	@Autowired
	private AdministracionDAO administracionDAO; 
	
	@Override
	@Transactional(readOnly = true)
	public Institucion getInfoInstitucion() {
		return administracionDAO.getInfoInstitucion();
	}
	
/**	@Override
	public int addServicio(Servicio servicio) {
		return administracionDAO.addServicio(servicio);
	}*/
	@Override
	public List<Servicio> getServicios() {
		return administracionDAO.getServicios();
	}
	@Override
	public int deleteServicio(Servicio servicio) {
		return administracionDAO.deleteServicio(servicio);
	}
	/**@Override
	public int updateServicio(Servicio servicio) {
		return administracionDAO.updateServicio(servicio);
	}*/
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
	

}
