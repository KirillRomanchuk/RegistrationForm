package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.validator.Validator;

import java.util.Arrays;

public abstract class AbstractInitializer<T> {
    protected final UserCommunicator communicator;

    public AbstractInitializer(UserCommunicator communicator) {
        this.communicator = communicator;
    }

    protected String requestString(MessageType requestKey, Validator<String> textValidator) {
        String returnValue = "";
        while (returnValue.isEmpty()) {
            returnValue = communicator.requestTextValue(requestKey);
            if (!textValidator.isValid(returnValue)) {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = "";
            }
        }
        return returnValue;
    }

    protected Integer requestInt(MessageType requestKey, Validator<Integer> intValidator) {
        Integer returnValue = 0;
        while (returnValue == 0) {
            returnValue = communicator.requestNumberValue(requestKey);
            if (!intValidator.isValid(returnValue)) {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = 0;
            }
        }
        return returnValue;
    }

    protected <V extends Enum<V>> V requestEnum(MessageType requestKey, Validator<String> enumValidator, V[] enumData) {
        Class<V> enumClass = enumData[0].getDeclaringClass();
        V returnValue = null;
        while (returnValue == null) {
            String inputValue = communicator.requestTextValue(requestKey);
            if (enumValidator.isValid(inputValue)) {
                returnValue = V.valueOf(enumClass, inputValue.toUpperCase());
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                communicator.viewNoTypeMessage(String.format("Available values: %s", Arrays.toString(enumData)));
            }
        }

        return returnValue;
    }

    public abstract void initialize(T data);
}
