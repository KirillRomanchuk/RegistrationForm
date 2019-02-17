package com.training.controller;

public class RegexValidator implements Validator<String> {

    private final String regex;

    public RegexValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean checkValue(String value) {
        return value.matches(regex);
    }
}
