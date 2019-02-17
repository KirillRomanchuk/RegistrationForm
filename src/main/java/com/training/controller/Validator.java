package com.training.controller;

public interface Validator<V> {
    boolean checkValue(V value);
}
