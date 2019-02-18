package com.training.controller;

import com.training.communication.MessageType;
import com.training.model.RegInformation;
import com.training.validator.RegexValidator;
import com.training.validator.Validator;

import java.util.ResourceBundle;

public class UserNameInitializer extends AbstractInitializer {
    private Validator<String> textValidator;

    public UserNameInitializer() {
        ResourceBundle regexBundle = ResourceBundle.getBundle("RegexBundle");
        this.textValidator = new RegexValidator(regexBundle.getString("onlyText"));
    }

    public void requestFullNameInformation(RegInformation regInformation) {
        regInformation.setLastName(requestString(MessageType.REQUEST_LAST_NAME, textValidator));
        regInformation.setFirstName(requestString(MessageType.REQUEST_FIRST_NAME, textValidator));
        regInformation.setMiddleName(requestString(MessageType.REQUEST_MIDDLE_NAME, textValidator));
        regInformation.setFullName(String.format("%s %s.", regInformation.getLastName(), regInformation.getFirstName().charAt(0)));
        regInformation.setNickName(requestString(MessageType.REQUEST_NICK_NAME, textValidator));
    }
}
