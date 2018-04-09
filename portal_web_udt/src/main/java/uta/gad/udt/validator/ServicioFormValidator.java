package uta.gad.udt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import uta.gad.udt.models.entity.Servicio;


@Component
public class ServicioFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return Servicio.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","Nombre es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "required.descripcion","Descripción es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imgOpcion", "required.imgOpcion","Escoja una opción!");
	}
}
