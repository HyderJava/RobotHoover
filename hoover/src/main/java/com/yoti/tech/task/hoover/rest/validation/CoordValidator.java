package com.yoti.tech.task.hoover.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CoordValidator implements ConstraintValidator<CoordConstraint, int[]> {
	{

	}

	@Override
	public void initialize(CoordConstraint coord) {
		
		
	}

	@Override
	public boolean isValid(int[] coords, ConstraintValidatorContext context) {

		return !(null == coords || coords.length != 2 || coords[0] < 0 || coords[1] < 0 ) ;
	}

}