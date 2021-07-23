package com.example.validator;

public class NonNegativeValueValidator implements IValidator {
    @Override
    public boolean isValid(String value) {
        return !value.startsWith("-");
    }
}
