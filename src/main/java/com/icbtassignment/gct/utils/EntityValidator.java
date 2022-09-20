package com.icbtassignment.gct.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class EntityValidator<T>  {

	public String validate(T entity) {
		String error = "";
		try {
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
			
			if(!constraintViolations.isEmpty()) {
				error = "<ul>";
				for (ConstraintViolation<T> cv : constraintViolations) {
					error += "<li>" 
							+ cv.getPropertyPath() + " " + cv.getMessage()
							+ "</li>";
				}			
				error += "</ul>";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return error;
	}
	
}
