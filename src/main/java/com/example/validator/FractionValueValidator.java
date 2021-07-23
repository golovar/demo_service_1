package com.example.validator;

import java.util.regex.Pattern;

public class FractionValueValidator implements IValidator {
    @Override
    public boolean isValid(String value) {
        Pattern decimalPattern = Pattern.compile("\\d+(/)\\d+");

        return decimalPattern.matcher(value).matches();
    }
}
