package co.edu.unicauca.distribuidos.core.models;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private String cadena;
    private char character = '5';

    @Override
    public void initialize(Phone constraintAnnotation) {
        cadena = constraintAnnotation.toString();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.charAt(0) == character;
    }

}
