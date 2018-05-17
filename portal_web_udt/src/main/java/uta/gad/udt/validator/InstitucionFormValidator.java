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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","errors.empty.institucion.nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "direccion","errors.empty.institucion.direccion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono","errors.empty.institucion.telefono");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correoAdmin", "errors.empty.institucion.correoAdmin");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lat","errors.empty.institucion.lat");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lon","errors.empty.institucion.lon");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "horarioAtencion","errors.empty.institucion.horarioAtencion");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mision","errors.empty.institucion.mision");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vision", "errors.empty.institucion.vision");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valores", "errors.empty.institucion.valores");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "acercaDe", "errors.empty.institucion.acercaDe");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imgOpcion", "errors.empty.institucion.imgOpcion"); 
		if (!(institucion.getCorreoAdmin() != null && institucion.getCorreoAdmin().isEmpty())) 
		 {  
			   pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(institucion.getCorreoAdmin());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("correoAdmin","errors.invalid.institucion.correoAdmin");  
			   }  
		}
		 
	
	}
}
