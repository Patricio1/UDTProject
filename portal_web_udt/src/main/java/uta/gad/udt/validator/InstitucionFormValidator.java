package uta.gad.udt.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import uta.gad.udt.models.entity.Institucion;

@Component
public class InstitucionFormValidator implements Validator{
	 private Pattern pattern;  
	 private Matcher matcher;  
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	 private static final String DECIMAL_PATTERN="^[-+]?\\d+(\\.\\d+)?$";
	@Override
	public boolean supports(Class<?> clazz) {
		return Institucion.class.equals(clazz);
	}
	 public static boolean isNumeric(String string) {
	      return string.matches(DECIMAL_PATTERN);
	  }
	@Override
	public void validate(Object target, Errors errors) {
		Institucion institucion = (Institucion) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","Nombre es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion", "required.direccion","Dirección es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required.telefono","Teléfono es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correoAdmin", "required.correoAdmin","Correo es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lat", "required.lat","Latitud es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lon", "required.lon","Longitud es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "horarioAtencion", "required.horarioAtencion","Horario de atención es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mision", "required.mision","Misión es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vision", "required.vision","Visión es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valores", "required.valores","Valores Institucionales es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "acercaDe", "required.acercaDe","Acerca de la Institución es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imgOpcion", "required.imgOpcion","Escoja una opción!"); 
		if (!(institucion.getCorreoAdmin() != null && institucion.getCorreoAdmin().isEmpty())) 
		 {  
			   pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(institucion.getCorreoAdmin());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("correoAdmin", "correoAdmin",  
			      "Ingrese un correo válido");  
			   }  
		}
		 
		/**if ((institucion.getLat() == null || !isNumeric(institucion.getLat().toString()))) 
		 {  
			    
			    errors.rejectValue("lat", "lat",  
			      "Ingrese un valor válido");  
			   
		}
		if ((institucion.getLon() != null)) 
		 {  
			   pattern = Pattern.compile(DECIMAL_PATTERN);  
			   matcher = pattern.matcher(institucion.getLon().toString());   
			   if (!matcher.matches()) {  
			    errors.rejectValue("lon", "lon",  
			      "Ingrese un valor válido");  
			   }  
		} */
	}
}
