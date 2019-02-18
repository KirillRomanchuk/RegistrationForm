package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;

public abstract class AbstractInitializer {
    // TODO (Eugene): 2/18/2019  move UserCommunicator communicator to class fields
    // TODO (Eugene): 2/18/2019 change signature to requestString(MessageType requestKey, Validator<String> textValidator)
    public String requestString(MessageType requestKey, UserCommunicator communicator, Validator<String> textValidator) {
        String returnValue = "";
        while (returnValue.isEmpty()) {
            returnValue = communicator.requestTextValue(requestKey);
            // TODO (Eugene): 2/18/2019 bad approach. Simply negate the condition and remove 'else' block, like: 'if (!textValidator.checkValue(returnValue))'
            if (textValidator.checkValue(returnValue)) {
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                returnValue = "";
            }
        }
        return returnValue;
    }

    // TODO (Eugene): 2/18/2019 remove unused method
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

    // TODO (Eugene): 2/18/2019  move UserCommunicator communicator to class fields
    // TODO (Eugene): 2/18/2019 change signature to requestString(MessageType requestKey, Validator<Integer> intValidator)
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
