package com.training.controller;

import java.util.Arrays;

// TODO (Eugene): 2/18/2019 move to package com.training.validator
public class EnumValidator<T extends Enum> implements Validator<String> {

    private final T[] values;

    public EnumValidator(T[] values) {
        this.values = values;
    }

    @Override
    public boolean checkValue(String value) {
        return Arrays.stream(values).anyMatch(g -> g.name().toLowerCase().equals(value.toLowerCase()));
    }
}
