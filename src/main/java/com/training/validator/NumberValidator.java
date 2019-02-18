package com.training.validator;

public class NumberValidator implements Validator<Integer> {
    @Override
    public boolean checkValue(Integer value) {
        return value > 0;
    }
}
