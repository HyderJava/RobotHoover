package com.yoti.tech.task.hoover.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;

import com.yoti.tech.task.hoover.utils.HooverUtils;

public class PatchesValidator implements ConstraintValidator<PatchesConstraint, int[][]> {

	private static final Logger logger = LoggerFactory.getLogger(PatchesValidator.class);
	{

	}

	@Override
	public void initialize(PatchesConstraint patches) {

	}

	@Override
	public boolean isValid(int[][] patches, ConstraintValidatorContext context) {

		if (null == patches) {
			logger.error("Invalid request: Patches is null");
			return false;
		}

		for (int i = 0; i < patches.length; i++) {
			if (patches[i].length != 2) {
				logger.error("Invalid request: Patches is not a coordinate of size 2 (X,Y)");
				return false;
			}
		}
		return true;
	}

}