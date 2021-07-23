package com.example.validator;

public class HexaValueValidator implements IValidator {
    @Override
    public boolean isValid(String value) {
        return value.matches("[a-fA-F]+");
    }
}
