package uta.gad.udt.models.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import uta.gad.udt.models.entity.Contacto;

@Component
public class ContactFormValidator implements Validator {
	 private Pattern pattern;  
	 private Matcher matcher;  
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Contacto.class.equals(clazz);
	}
	
	

	@Override
	public void validate(Object target, Errors errors) {
		Contacto contacto = (Contacto) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "asunto", "required.asunto","Asunto es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","Nombre es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo","required.correo", "Correo es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mensaje","required.mensaje","Mensaje es requerido!");
		/**ValidationUtils.rejectIfEmptyOrWhitespace(errors, "asunto", "required.asunto","*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo","required.correo", "*");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mensaje","required.mensaje","*");*/
		
		
		if (contacto.getAsunto() == null) {
			errors.rejectValue("asunto", "*");
		}
		if (contacto.getNombre() == null) {
			errors.rejectValue("nombre", "*");
		}	
		  if (!(contacto.getCorreo() != null && contacto.getCorreo().isEmpty())) {  
			   pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(contacto.getCorreo());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("correo", "correo",  
			      "Ingrese un correo válido");  
			   }  
			  }  
		  
		if (contacto.getMensaje() == null) {
			errors.rejectValue("mensaje", "NotEmpty.contactForm.mensaje");
		}
		
	}

}
