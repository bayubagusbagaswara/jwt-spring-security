package com.bayu.jwt.validation.annotation;

import com.bayu.jwt.validation.validator.MatchPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchPasswordValidator.class)
@Documented
public @interface MatchPassword {

    String message() default "The new passwords must match";

    Class<?>[] group() default {};

    boolean allowNull() default false;

    Class<? extends Payload>[] payload() default {};

}
