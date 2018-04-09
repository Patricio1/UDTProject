package uta.gad.udt.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uta.gad.udt.models.entity.AreaTransferencia;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.CooperativasFrecPorDestino;
import uta.gad.udt.models.entity.DestinosConProximasSalidas;
import uta.gad.udt.models.entity.DestinosCoopIntercantonal;
import uta.gad.udt.models.entity.DetalleProximasSalidasDestino;
import uta.gad.udt.models.entity.HorarioCooperativaPorDestino;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.entity.ProximaSalidaCooperativa;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.service.PublicoService;

@RestController
@RequestMapping("/udt")
public class RestControlador {
	@Autowired
    private PublicoService publicoService;
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<ProximaSalidaCooperativa> getProximaSalida()
	{
		return new ArrayList<ProximaSalidaCooperativa>(publicoService.listarProximasSalidas());

	}
	@RequestMapping(value="/destinos-proximas-salidas", method = RequestMethod.GET)
	public ArrayList<DestinosConProximasSalidas> getDestinosProximasSalidas()
	{
		return new ArrayList<DestinosConProximasSalidas>(publicoService.listarDestinosConProximasSalidas());

	}
	@RequestMapping(value="/detalle-proximas-salidas/{idOrigen}/{idDestino}", method = RequestMethod.GET)
	public ArrayList<DetalleProximasSalidasDestino> getDetalleProximasSalidasDestino(@PathVariable Long idOrigen,@PathVariable Long idDestino)
	{
		return new ArrayList<DetalleProximasSalidasDestino>(publicoService.listarDetalleProximasSalidasDestino(idOrigen,idDestino));
	}
	@RequestMapping(value="/destino-cooperativas/{idDestino}", method = RequestMethod.GET)
	public ArrayList<CooperativasFrecPorDestino> getDetalleProximasSalidasDestino(@PathVariable Long idDestino)
	{
		return new ArrayList<CooperativasFrecPorDestino>(publicoService.listarCooperativasFrecPorDestino(idDestino));
	}
	@RequestMapping(value="/horario-cooperativas/{idDestino}/{idCooperativa}", method = RequestMethod.GET)
	public  ArrayList<HorarioCooperativaPorDestino> getHorariosCooperativasPorDestino(@PathVariable Long idDestino,@PathVariable Long idCooperativa)
	{		
		return new ArrayList<HorarioCooperativaPorDestino>(publicoService.listarHorarioCoopPorDestino(idDestino,idCooperativa));
	}
	@RequestMapping(value="/destinos-coop-intercantonal", method = RequestMethod.GET)
	public  ArrayList<DestinosCoopIntercantonal> getDestinosCoopIntercantonal()
	{		
		return new ArrayList<DestinosCoopIntercantonal>(publicoService.listarDestinosCoopIntercantonal());
	}
	@RequestMapping(value="/destinos-coop-interparroquial", method = RequestMethod.GET)
	public  ArrayList<DestinosCoopIntercantonal> getDestinosCoopInterparroquial()
	{		
		return new ArrayList<DestinosCoopIntercantonal>(publicoService.listarDestinosCoopInterparroquial());
	}
	@RequestMapping(value="/area-transferencia/{nombreAreaTransferencia}", method = RequestMethod.GET)
	public AreaTransferencia getAreaTransferencia(@PathVariable String nombreAreaTransferencia)
	{		
		return (publicoService.getAreaTransferenciaPorNombre(nombreAreaTransferencia));
	}
	@RequestMapping(value="/nombres-areas-transferencia", method = RequestMethod.GET)
	public  List<AreaTransferencia> getNombresAreaTransferencia()
	{		
		return (publicoService.getNombresAreaTransferencia());
	}
	@RequestMapping(value="/info-udt", method = RequestMethod.GET)
	public  Institucion getInfoUDT()
	{		
		return (publicoService.getInfoInstitucion());
	}
	@RequestMapping(value="/gad", method = RequestMethod.GET)
	public  Recurso getlogoGAD() 
	{		
		return (publicoService.getRecursoPorNombre("Logo GAD"));
	}
	@RequestMapping(value="/ambatotl", method = RequestMethod.GET)
	public  Recurso getlogoAmbatoTierritaLinda() 
	{		
		return (publicoService.getRecursoPorNombre("Ambato Tierrita Linda"));
	}
	@RequestMapping(value="/linksInteres", method = RequestMethod.GET)
	public  List<Link> getLinksInteres() 
	{		
		return (publicoService.listarLinksInteres());
	}
	@RequestMapping(value="/fecha_actual", method = RequestMethod.GET)
	public  String getFechaActual() 
	{		
		/**LocalDate localDate = LocalDate.now();
		int mes = localDate.getMonthValue();
		int year= localDate.getYear();
		int dia = localDate.getDayOfMonth();
		int diasemana = localDate.getDayOfWeek().getValue();
		HashMap<Integer,String> nombreMeses = new HashMap<Integer, String>();
		nombreMeses.put(1,"Enero");nombreMeses.put(2,"Febrero");nombreMeses.put(3,"Marzo");
		nombreMeses.put(4,"Abril");nombreMeses.put(5,"Mayo");nombreMeses.put(6,"Junio");
		nombreMeses.put(7,"Julio");nombreMeses.put(8,"Agosto");nombreMeses.put(9,"Septiembre");
		nombreMeses.put(10,"Octubre");nombreMeses.put(11,"Noviembre");nombreMeses.put(12,"Diciembre");
		HashMap<Integer,String> diasSemana = new HashMap<Integer, String>();
		diasSemana.put(1,"Lunes");diasSemana.put(2,"Martes");diasSemana.put(3,"Miércoles");
		diasSemana.put(4,"Jueves");diasSemana.put(5,"Viernes");diasSemana.put(6,"Sábado");
		diasSemana.put(7,"Domingo");*/
	   //String fecha = diasSemana.get(diasemana)+", "+dia+" de "+nombreMeses.get(mes)+" de "+year;
	   
		String fecha = "26-03-2018";
	   return fecha;
	}
	@RequestMapping(value="/ultimas4noticias", method = RequestMethod.GET)
	public  List<ComunicadoNoticia> getUltimas4Noticias() 
	{		
		return (publicoService.getUltimas4Noticias());
	}
	@RequestMapping(value="/titularesnoticias", method = RequestMethod.GET)
	public  List<ComunicadoNoticia> getTitularesNoticias() 
	{		
		return (publicoService.getTitularesNoticias());
	}
	@RequestMapping(value="/noticia-principal", method = RequestMethod.GET)
	public ComunicadoNoticia getNoticiaPrincipal() 
	{		
		return (publicoService.getNoticiaPrincipal());
	}
	/**@RequestMapping(value="/comunicado-noticia/{cn}", method = RequestMethod.GET)
	public  ComunicadoNoticia getComunicadoNoticiaPorId(@PathVariable String cn)
	{		
		return (publicoService.getComunicadoNoticiaPorId(tipo, id));
	}*/
	
	/**@RequestMapping(value="/info", method = RequestMethod.GET)
	public Institucion getInfoInstitucion()
	{		
		return (publicoService.getInfoInstitucion());
	}*/
}
