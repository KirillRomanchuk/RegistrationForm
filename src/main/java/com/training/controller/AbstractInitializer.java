package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.validator.Validator;

public abstract class AbstractInitializer {
    public String requestString(MessageType requestKey, Validator<String> textValidator) {
        UserCommunicator communicator = new UserCommunicator(System.in);
        String returnValue = "";
        while (returnValue.isEmpty()) {
            returnValue = communicator.requestTextValue(requestKey);
            if (!textValidator.checkValue(returnValue)) {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = "";
            }
        }
        return returnValue;
    }

    public Integer requestInt(MessageType requestKey, Validator<Integer> intValidator) {
        UserCommunicator communicator = new UserCommunicator(System.in);
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
