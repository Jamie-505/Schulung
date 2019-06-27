package com.exxeta.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TrainingDurationValidator.class)
public @interface ValidDuration {
    String message() default "Invalid duration";
    Class<?>[] groups() default {};
    Class<? extends Payload[]>[] payload() default {};
}
