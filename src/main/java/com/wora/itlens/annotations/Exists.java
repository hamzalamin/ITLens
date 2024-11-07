package com.wora.itlens.annotations;

import com.wora.itlens.validation.ExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ExistsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {
    String message() default "Entity does not exists";
    Class<?> entity();
    String field() default "id";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
