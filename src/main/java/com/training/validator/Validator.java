package com.training.validator;

public interface Validator<V> {
    // TODO (Eugene): 2/18/2019 maybe 'isValid' would be a better name for this method
    boolean checkValue(V value);
}
