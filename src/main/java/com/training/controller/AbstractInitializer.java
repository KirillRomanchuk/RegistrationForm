package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;

public abstract class AbstractInitializer {
    public String requestString(MessageType requestKey, UserCommunicator communicator, Validator<String> textValidator) {
        String returnValue = "";
        while (returnValue.isEmpty()) {
            returnValue = communicator.requestTextValue(requestKey);
            if (textValidator.checkValue(returnValue)) {
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = "";
            }
        }
        return returnValue;
    }

    public String requestStringDoubleValidator(MessageType requestKey, UserCommunicator communicator, Validator<String> textValidator, Validator<String> secondTextValidator) {
        String returnValue = "";
        while (returnValue.isEmpty()) {
            returnValue = communicator.requestTextValue(requestKey);
            if (textValidator.checkValue(returnValue) || secondTextValidator.checkValue(returnValue)) {
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = "";
            }
        }
        return returnValue;
    }

    public Integer requestInt(MessageType requestKey, UserCommunicator communicator, Validator<Integer> intValidator) {
        Integer returnValue = 0;
        while (returnValue == 0) {
            returnValue = communicator.requestNumberValue(requestKey);
            if (intValidator.checkValue(returnValue)) {
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = 0;
            }
        }
        return returnValue;
    }


}
