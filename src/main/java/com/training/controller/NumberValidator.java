package com.training.controller;

// TODO (Eugene): 2/18/2019 move to package com.training.validator
public class NumberValidator implements Validator<Integer> {
    @Override
    public boolean checkValue(Integer value) {
        return value > 0;
    }
}
