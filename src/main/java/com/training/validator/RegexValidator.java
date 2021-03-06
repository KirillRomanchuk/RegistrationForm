package com.training.validator;

public class RegexValidator implements Validator<String> {

    private final String regex;

    public RegexValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean isValid(String value) {
        return value.matches(regex);
    }
}
