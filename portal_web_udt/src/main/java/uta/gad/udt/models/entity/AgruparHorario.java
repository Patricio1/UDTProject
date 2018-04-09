package uta.gad.udt.models.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
@Repository
public class AgruparHorario {
	Multimap<String, String> multimapCombinacionDiaHorario =  null;
	ArrayList<String> listaidDias = null;			
	List<HorarioCooperativaPorDestino> horarioOrdenadoYagrupado=null;
	Long numeroAnden=null;		
	public List<HorarioCooperativaPorDestino> ordenarYagruparHorario(List<HorarioCooperativaPorDestino> listaHorario)
	{	
		multimapCombinacionDiaHorario =  ArrayListMultimap.create();
		listaidDias = new ArrayList<String>();			
		horarioOrdenadoYagrupado=null;		
		List<String> listaDias = new ArrayList<String>();
		if(listaHorario.get(0).getAnden()==null)
		{
			numeroAnden=0L;
		}
		else numeroAnden = listaHorario.size()>0? listaHorario.get(0).getAnden():0L;
		
		Multimap<String, String> multimapHorario = ArrayListMultimap.create();
		for (HorarioCooperativaPorDestino horario : listaHorario) {
			multimapHorario.put(horario.getDias(), horario.getHora());
			listaDias.add(horario.getDias());
		} 
		
		//obtener una lista de dias no repetidos
		 Set<String> uniqueDays = new HashSet<String>(listaDias);		
	   
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
       	listaDias.add(dato.getKey());
		}
       uniqueDays = new HashSet<String>(listaDias);      
      return getHorarioDefinitivo(multimapCombinacionDiaHorario,uniqueDays);    
	}
	/**
	 * Metodo para combinar dias con horas
	 * @param dias
	 * @param horario
	 */
	private void combinarDiasConHoras(String dias,Collection<String> horario)
	{				
			char[]aux = dias.toCharArray();						
			for (String hora : horario) {
				for (int i = 0; i < aux.length; i++) {
					multimapCombinacionDiaHorario.put(aux[i]+"", hora);
				}							
			}						
	}
	/**
	 * Metodo para obtener el horario definito con
	 * el horario ordenado y agrupado por dias
	 * @param myMultimap (objeto con la informacion de horas y dias)
	 * @param uniqueValues (objeto con la informacion de valores unicos sobre dias)
	 */
	private List<HorarioCooperativaPorDestino> getHorarioDefinitivo(Multimap<String, String> myMultimap, Set<String> uniqueValues)
	{		
        Map<String, Collection<String>> resultado = setValuesUniqueInMap(myMultimap, uniqueValues);                                        
        for (Iterator itr = resultado.entrySet().iterator(); itr.hasNext();)
	    {
	        Map.Entry<String, Collection<String>> entrySet = (Map.Entry) itr.next();
	       
	        Collection<String> value = entrySet.getValue();
	        	        
	        String key = entrySet.getKey();	     	    	        	     
	        
	        addHorarioToMap(auxiliarOrdenarHorario(value).toString(),key);	   
	       
	    }            
        getAuxHorarioDefinitivo();
        return horarioOrdenadoYagrupado;
	}
	/**
	 * Metodo para añadir a un objeto Map valores unicos (no repetidos)
	 * @param multimap (objeto con la informacion de horas y dias)
	 * @param uniqueValues (objeto con la informacion de valores unicos sobre dias)
	 * @return
	 */
	private Map<String, Collection<String>> setValuesUniqueInMap(Multimap<String, String> multimap,Set<String> uniqueValues)
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
	/**
	 *Metodo para añadir al objeto Multimap el horario y dia (en este orden)
	 * @param horario
	 * @param dia	 
	 */
	private void addHorarioToMap(String horario, String dia)
	{		
		multimapCombinacionDiaHorario.put(horario, dia);		
		listaidDias.add(horario);		
	}
	/**
	 * Metodo auxiliar para obtener el horario definito con
	 * el horario ordenado y agrupado por dias
	 */
	private void getAuxHorarioDefinitivo()
	{
		//extraer una lista de id de dias no repetidos (únicos)
		Set<String> uniqueidDays = new HashSet<String>(listaidDias);
		Map<String, Collection<String>> resultado = new TreeMap<String, Collection<String>>();
	    horarioOrdenadoYagrupado = new ArrayList<HorarioCooperativaPorDestino>();
	    HorarioCooperativaPorDestino horarioItem = null;
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
		        horarioItem = new HorarioCooperativaPorDestino(horario, numeroAnden, auxConvertIdToNameDays(value));
		        horarioOrdenadoYagrupado.add(horarioItem);		       
		        //auxConvertIdToNameDays(value);
		    }       
		
	}
	
	/**
	 * Metodo para convertir un objeto Collection con id de dias de la semana
	 * a una cadena con los nombres de la semana
	 * Ejemplo: de [1,2,3] a Lunes,Martes,Miércoles
	 * @param idDays (id dia de la semana)
	 * @return cadena con el o los nombres de los dias
	 * de la semana dependiendo del objeto Collection
	 */
	private String auxConvertIdToNameDays(Collection<String> idDays)
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
			//Remover ',' de la ultima posicion
			//ejemplo: de 'Lunes,Martes,' a 'Lunes,Martes' 
			auxNameDays = removeCharAt(auxNameDays,auxNameDays.length()-1);
		}	
		return auxNameDays;
	}
	
	/**
	 * Metodo para ordenar un horario en forma ascendente
	 * @param horarioDesordenado
	 * @return lista de horario ordenado de forma ascendente
	 */
	private static ArrayList<String> ordenarHorario(ArrayList<String> horarioDesordenado)
	{
		ArrayList<String> horarioModificada = new ArrayList<String>();
		for (String numero: horarioDesordenado) {          
        	String[] arrayHora = numero.split(":");
        	String hora = arrayHora[0];
        	char[] digitosHora = hora.toCharArray();
        	Integer digitoEntero = Integer.parseInt(digitosHora[0]+"");
        	String horaModificada = "";
        	if(digitoEntero>2)
        	{
        		//modificamos (por ejemplo de 9:30 a 09:30)
        		horaModificada+="0"+digitosHora[0]+":"+arrayHora[1];
        	}
        	else
        	{
        		horaModificada = hora+":"+arrayHora[1];
        	}
        	horarioModificada.add(horaModificada);
        }
		//ordenar el horario de forma ascendente
		Collections.sort(horarioModificada);
		return horarioModificada;
	}
	/**
	 * Metodo auxiliar para ordenar horario
	 * Pasa los datos de un objeto Collection a otro de tipo ArrayList 
	 * @param horario
	 * @return horario ordenado de forma ascendente
	 */
	private ArrayList<String> auxiliarOrdenarHorario(Collection<String> horario)
	{
		ArrayList<String> dat = new ArrayList<String>();		
		for (String hora : horario) {						
			dat.add(hora);
		}		
		ArrayList<String> horarioOrdenado = ordenarHorario(dat);
		return horarioOrdenado;		
	}
	/**
	 * Metodo para obtener el nombre del dia de la semana dado su id
	 * @param sdia id de dia de la semana en el rango 1-7
	 * @return nombre del dia de la semana
	 */
	private String getNombreDiaById(String sdia)
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
	/**
	 * Metodo para convertir una cadena que representa los dias de la semana
	 * en el formato xxxxxxx donde x=0 y 1 a ids de dias de semana
	 * @param dias
	 * @return concatenacion de id de los dias de la semana segun su numero ejemplo
	 * 123 (representaria:Lunes,Martes,Miercoles)
	 */
	private String ConvertDays(String dias)
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
	/**
	 * Metodo para remover un caracter dado una posicion
	 * @param s = cadena
	 * @param pos = posicion del caracter a eliminar
	 * @return cadena con el caracter eliminado
	 */
	public String removeCharAt(String s, int pos) 
	{
	      return s.substring(0, pos) + s.substring(pos + 1);
	}
}
