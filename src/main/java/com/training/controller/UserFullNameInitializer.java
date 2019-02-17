package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;

import java.util.ResourceBundle;

public class UserFullNameInitializer extends AbstractInitializer {
    private Validator<String> textValidator;
    private ResourceBundle regexBundle;
    private final UserCommunicator communicator;
    private final RegInformation regInformation;

    public UserFullNameInitializer(RegInformation regInformation, UserCommunicator communicator) {
        this.regexBundle = ResourceBundle.getBundle("RegexBundle");
        this.textValidator = new RegexValidator(regexBundle.getString("someText"));
        this.communicator = communicator;
        this.regInformation = regInformation;
    }

    public void requestFullNameInformation() {
        regInformation.setLastName(requestString(MessageType.REQUEST_LAST_NAME, communicator, textValidator));
        regInformation.setFirstName(requestString(MessageType.REQUEST_FIRST_NAME, communicator, textValidator));
        regInformation.setMiddleName(requestString(MessageType.REQUEST_MIDDLE_NAME, communicator, textValidator));
        regInformation.setFullName(createFullName());
        regInformation.setNickName(requestString(MessageType.REQUEST_NICK_NAME, communicator, textValidator));
    }

    private String createFullName() {
        return String.format("%s %s.", regInformation.getLastName(), regInformation.getFirstName().charAt(0));
    }
}
