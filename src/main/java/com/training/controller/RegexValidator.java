package com.training.controller;

// TODO (Eugene): 2/18/2019 move to package com.training.validator
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
