package com.training.validator;

public interface Validator<V> {
    boolean isValid(V value);
}
