package com.yoti.tech.task.hoover.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.context.annotation.PropertySource;

public class PatchesValidator implements ConstraintValidator<PatchesConstraint, int[][]> {
	{

	}

	@Override
	public void initialize(PatchesConstraint patches) {

	}

	@Override
	public boolean isValid(int[][] patches, ConstraintValidatorContext context) {

		if (null == patches)
			return false;

		for (int i = 0; i < patches.length; i++) {
			if (patches[i].length != 2) {
				return false;
			}
		}
		return true;
	}

}