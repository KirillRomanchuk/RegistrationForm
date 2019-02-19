package com.training.validator;

import java.util.Arrays;

public class EnumValidator<T extends Enum> implements Validator<String> {

    private final T[] values;

    public EnumValidator(T[] values) {
        this.values = values;
    }

    @Override
    public boolean isValid(String value) {
        return Arrays.stream(values).anyMatch(g -> g.name().toLowerCase().equals(value.toLowerCase()));
    }
}
