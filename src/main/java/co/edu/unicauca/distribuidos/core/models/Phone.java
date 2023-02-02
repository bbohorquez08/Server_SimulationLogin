package co.edu.unicauca.distribuidos.core.models;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.FIELD })
public @interface Phone {

    String message() default "Número de celular invalido";

    int length() default 2;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
