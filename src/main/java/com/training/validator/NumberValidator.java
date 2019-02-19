package com.training.validator;

public class NumberValidator implements Validator<Integer> {
    @Override
    public boolean isValid(Integer value) {
        return value > 0;
    }
}
