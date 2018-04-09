package uta.gad.udt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import uta.gad.udt.models.entity.ComunicadoNoticia;
@Component
public class ComuNoticFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return ComunicadoNoticia.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "required.titulo","Título es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contenido", "required.contenido","Contenido es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo", "required.tipo","Seleccione una opción!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha", "required.fecha","Fecha es requerido!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estado", "required.estado","Seleccione una opción!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "imgOpcion", "required.imgOpcion","Seleccione una opción!");
	}
}
