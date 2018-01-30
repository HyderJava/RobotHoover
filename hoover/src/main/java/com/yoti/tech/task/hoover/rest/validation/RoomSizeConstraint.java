package com.yoti.tech.task.hoover.rest.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.context.annotation.PropertySource;

@Documented
@Constraint(validatedBy = RoomSizeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RoomSizeConstraint {
	String message() default "The room size entered is invalid";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}