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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "errors.empty.comunicado.titulo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contenido","errors.empty.comunicado.contenido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo","errors.empty.comunicado.tipo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha","errors.empty.comunicado.fecha");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "estado","errors.empty.comunicado.estado");
	}
}
