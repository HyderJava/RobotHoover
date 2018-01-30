package com.yoti.tech.task.hoover.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.context.annotation.PropertySource;

public class RoomSizeValidator implements ConstraintValidator<RoomSizeConstraint, int[]> {
	{

	}

	@Override
	public void initialize(RoomSizeConstraint roomsize) {

	}

	@Override
	public boolean isValid(int[] roomSize, ConstraintValidatorContext context) {

		return !(roomSize == null || roomSize.length != 2 || roomSize[0] != roomSize[1] || roomSize[0] < 1
				|| roomSize[1] < 1);
	}

}