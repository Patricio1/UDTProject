package uta.gad.udt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import uta.gad.udt.models.entity.Recurso;

@Component
public class RecursoFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return Recurso.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","errors.empty.recurso.nombre");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo", "errors.empty.recurso.tipo");
	}
}
