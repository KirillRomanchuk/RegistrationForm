package com.training.validator;

public interface Validator<V> {
    boolean checkValue(V value);
}
