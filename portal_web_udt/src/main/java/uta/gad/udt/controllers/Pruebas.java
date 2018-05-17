package uta.gad.udt.controllers;



import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import uta.gad.udt.models.entity.AgruparHorario;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.HorarioCooperativaPorDestino;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.*;
import uta.gad.udt.models.service.PublicoService;
import uta.gad.udt.models.service.PublicoServiceImpl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Pruebas {
	static Multimap<String, String> multimapCombinacionDiaHorario = ArrayListMultimap.create();
	@Autowired
    private static PublicoService publicoService;
	static Multimap<String, String> AuxMultimapAgruparHora = ArrayListMultimap.create();
	static ArrayList<String> listaidDias = new ArrayList<String>();
	
	public static void main(String[] args) {
		
			
			String password = "123";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));
            System.out.println("hola");    
		
	/**	BigDecimal lat = new BigDecimal(-12.455);
		BigDecimal lon = new BigDecimal(-34.88912);
		Institucion institucion = new Institucion
				("Unidad de Desconcentrada de Terminalesz", 
				"UDTz", 
				"Llegamos a todos los rincones del país", 
				"Av. Quito 5-23", 
				"0986385023,032768889", 
				"apatriciol_@hotmail.com",
				"8:00h-12:00|14:00-17:00", 
				"logo.png", 
				"mision", 
				"vision", 
				"valores", 
				"acercaDe", 
				lat, 
				lon);*/
		
		/*Link link = new Link();
		link.setNombre("sa");
		link.setIcono("se");
		link.setUrl("su");*/
	//	servicio.addLink(link);
		
		
		// 
		//  
		/**HorarioCooperativaPorDestino horarioCoop = new 
				HorarioCooperativaPorDestino("12:30", 12L, "0100000");
		HorarioCooperativaPorDestino horarioCoop1 = new 
				HorarioCooperativaPorDestino("13:30", 12L, "0100000");
		HorarioCooperativaPorDestino horarioCoop2 = new 
				HorarioCooperativaPorDestino("14:30", 12L, "0101010");
		HorarioCooperativaPorDestino horarioCoop3 = new 
				HorarioCooperativaPorDestino("15:30", 12L, "0100000");
		HorarioCooperativaPorDestino horarioCoop4 = new 
				HorarioCooperativaPorDestino("18:30", 12L, "0100000");
		
		/**HorarioCooperativaPorDestino horarioCoop = new 
				HorarioCooperativaPorDestino("21:30", 12L, "0001000");
		HorarioCooperativaPorDestino horarioCoop1 = new 
				HorarioCooperativaPorDestino("22:00", 12L, "0000001");*/
	
		
		/**HorarioCooperativaPorDestino horarioCoop = new 
		HorarioCooperativaPorDestino("00:15", 12L, "1111111");
HorarioCooperativaPorDestino horarioCoop1 = new 
		HorarioCooperativaPorDestino("00:45", 12L, "1111111");
HorarioCooperativaPorDestino horarioCoop2 = new 
		HorarioCooperativaPorDestino("06:15", 12L, "1111111");
HorarioCooperativaPorDestino horarioCoop3 = new 
		HorarioCooperativaPorDestino("07:45", 12L, "1111111");

		
		ArrayList<HorarioCooperativaPorDestino> listaHorario = new ArrayList<HorarioCooperativaPorDestino>();
		listaHorario.add(horarioCoop);
		listaHorario.add(horarioCoop1);
		listaHorario.add(horarioCoop2);
		listaHorario.add(horarioCoop3);
		listaHorario.add(horarioCoop4);
		//obtener el numero de anden
		numeroAnden = listaHorario.size()>0? listaHorario.get(0).getAnden():0L;
		AgruparHorario jj= new 	AgruparHorario();
		java.util.List<HorarioCooperativaPorDestino> lista = 
				jj.ordenarYagruparHorario((java.util.List<HorarioCooperativaPorDestino>)listaHorario);
		//Multimap<String, String> multimapHorario = ArrayListMultimap.create();
		for (HorarioCooperativaPorDestino horario : lista) {
			System.out.println(horario.getHora()+" "+horario.getDias()+" "+horario.getAnden());
		} */
		/**
		//obtener una lista de dias no repetidos
		 Set<String> uniqueDays = new HashSet<String>(listaDias);
		 System.out.println("unique values: "+uniqueDays);
	   
	    //objeto para almacenar las horas agrupadas por dia
        Map<String, Collection<String>> resultado = setValuesUniqueInMap(multimapHorario, uniqueDays);         		
    
 
        // Recorrer el objeto 'resultado'
        for (Iterator itr = resultado.entrySet().iterator(); itr.hasNext();)
	    {
	        Map.Entry<String, Collection<String>> entrySet = (Map.Entry) itr.next();	       
	        Collection<String> horario = entrySet.getValue();	        	        
	        String dias = entrySet.getKey();	     
	       combinarDiasConHoras(ConvertDays(dias),horario);	     	       
	    }
               
        listaDias.clear();
        for (Map.Entry<String,String> dato: multimapCombinacionDiaHorario.entries()) {
        	System.out.println(dato.getKey()+" "+dato.getValue());
        	listaDias.add(dato.getKey());
		}
        uniqueDays = new HashSet<String>(listaDias);
        System.out.println("unique values after convert: "+uniqueDays);
       getRepeats(multimapCombinacionDiaHorario,uniqueDays);     */
	}
	
	private static void combinarDiasConHoras(String dias,Collection<String> horario)
	{				
			char[]aux = dias.toCharArray();						
			for (String hora : horario) {
				for (int i = 0; i < aux.length; i++) {
					multimapCombinacionDiaHorario.put(aux[i]+"", hora);
				}							
			}						
	}
	
	private static Map<String, Collection<String>> setValuesUniqueInMap(Multimap<String, String> multimap,Set<String> uniqueValues)
	{
		Map<String, Collection<String>> resultado = new TreeMap<String, Collection<String>>();        
        Collection<String> auxDias;
        for(String dias: uniqueValues)
        {
        	//agrupar las horas por dia
        	auxDias = multimap.get(dias);  
        	//guardar la informacion agrupada anteriormente        
            resultado.put(dias, auxDias);
        }
        return resultado;
	}
	private static void getRepeats(Multimap<String, String> myMultimap, Set<String> uniqueValues)
	{		
        Map<String, Collection<String>> resultado = setValuesUniqueInMap(myMultimap, uniqueValues);                           
       // multimapCombinacionDiaHorario.clear();
        System.out.println("Tamaño: "+multimapCombinacionDiaHorario.size());
        for (Iterator itr = resultado.entrySet().iterator(); itr.hasNext();)
	    {
	        Map.Entry<String, Collection<String>> entrySet = (Map.Entry) itr.next();
	       
	        Collection<String> value = entrySet.getValue();
	        	        
	        String key = entrySet.getKey();	     	    	        	     
	        
	        auxAgruparHora(OrdenarHora(value).toString(),key);	   
	       
	    }      
        System.out.println("Tamaño: "+multimapCombinacionDiaHorario.size());
        extractUniqueIdDays();
	}
	/**
	 *Metodo auxiliar para agrupar por horas
	 * @param dat
	 * @return
	 */
	private static void  auxAgruparHora(String horario, String dia)
	{
		//AuxMultimapAgruparHora.put(horario, dia);
		multimapCombinacionDiaHorario.put(horario, dia);
		
		listaidDias.add(horario);		
	}
	private static void extractUniqueIdDays()
	{
		//extraer una lista de id de dias no repetidos (únicos)
		Set<String> uniqueidDays = new HashSet<String>(listaidDias);
		Map<String, Collection<String>> resultado = new TreeMap<String, Collection<String>>();
	        
	        Collection<String> auxHorario;
	        for(String horario: uniqueidDays)
	        {
	        	auxHorario = multimapCombinacionDiaHorario.get(horario);            
	            resultado.put(horario, auxHorario);
	        }
	        
	        for (Iterator itr = resultado.entrySet().iterator(); itr.hasNext();)
		    {
		        Map.Entry<String, Collection<String>> entrySet = (Map.Entry) itr.next();
		       
		        Collection<String> value = entrySet.getValue();
		        	        
		        String key = entrySet.getKey();	
		        String horario = removeCharAt(key, key.length()-1);
		        horario = removeCharAt(horario, 0);
		        
		        System.out.println(horario+" - "+auxConvertIdToNameDays(value));
		        //auxConvertIdToNameDays(value);
		    }       
		
	}
	private static String auxConvertIdToNameDays(Collection<String> idDays)
	{		
		String auxNameDays="";
		if(idDays.toString().equals("[1, 2, 3, 4, 5, 6, 7]"))
		{
			auxNameDays = "Lunes a Domingo";
		}
		else
		{
			for (String idDia : idDays) {
				auxNameDays+=getNombreDiaById(idDia)+",";
			}
			//Remove , from last position
			auxNameDays = removeCharAt(auxNameDays,auxNameDays.length()-1);
		}	
		return auxNameDays;
	}
	private static ArrayList<String> ordenarHorario(ArrayList<String> dat)
	{
		ArrayList<String> listaModificada = new ArrayList<String>();
		for (String numero: dat) {
            //System.out.println(numero);
        	String[] arrayHora = numero.split(":");
        	String hora = arrayHora[0];
        	char[] digitosHora = hora.toCharArray();
        	Integer digitoEntero = Integer.parseInt(digitosHora[0]+"");
        	String horaModificada = "";
        	if(digitoEntero>2)
        	{
        		horaModificada+="0"+digitosHora[0]+":"+arrayHora[1];
        	}
        	else
        	{
        		horaModificada = hora+":"+arrayHora[1];
        	}
           listaModificada.add(horaModificada);
        }
		Collections.sort(listaModificada);
		return listaModificada;
	}
	
	private static ArrayList<String> OrdenarHora(Collection<String> horario)
	{
		ArrayList<String> dat = new ArrayList<String>();		
		for (String hora : horario) {			
			//System.out.println("es la hora: "+hora);
			dat.add(hora);
		}
		ArrayList<String> horarioOrdenado = ordenarHorario(dat);
		return horarioOrdenado;
		
		
	//	Collections.sort(dat);
		//for (String numero: dat) {
        
        //}   
	}
	private static String getNombreDiaById(String sdia)
	{		String[]diasSemana = {"Lunes","Martes","Miércoles","Jueves",
			"Viernes","Sábado","Domingo"};
			String nombreDia="";
			Integer numeroDia = Integer.parseInt(sdia)-1;
			if(numeroDia<8 && numeroDia >= 0)
			{
				nombreDia = diasSemana[numeroDia];
			}			
			return nombreDia;	
	}
	private static String ConvertDays(String dias)
	{				
			char[]aux = dias.toCharArray();
			char[]diasSemana = {'1','2','3','4',
					'5','6','7'};
			String auxDias="";
			for (int i = 0; i < aux.length; i++) {
				if(aux[i] == '1')
				{
					auxDias+=diasSemana[i];
				}				
			}					
			return auxDias;
	}
	public static String removeCharAt(String s, int pos) {
	      return s.substring(0, pos) + s.substring(pos + 1);
	   }

}
