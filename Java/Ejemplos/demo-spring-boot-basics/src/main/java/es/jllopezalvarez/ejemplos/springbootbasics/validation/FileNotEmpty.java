package es.jllopezalvarez.ejemplos.springbootbasics.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileNotEmptyValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileNotEmpty {
    String message() default "No puede estar vacio";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



