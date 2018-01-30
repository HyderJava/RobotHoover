package com.yoti.tech.task.hoover.rest.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PatchesValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PatchesConstraint {
	String message() default "The patch coordinates provided are invalid";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}