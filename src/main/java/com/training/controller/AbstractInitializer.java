package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.validator.Validator;

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

    public abstract void initialize(T data);
}
