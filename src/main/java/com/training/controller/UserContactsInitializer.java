package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;

import java.util.ResourceBundle;

public class UserContactsInitializer extends AbstractInitializer {
    private Validator<String> textValidator;
    private Validator<String> phoneValidator;
    private Validator<String> emailValidator;
    private ResourceBundle regexBundle;
    private UserCommunicator communicator;
    private RegInformation regInformation;

    public UserContactsInitializer(RegInformation regInformation, UserCommunicator communicator) {
        this.regexBundle = ResourceBundle.getBundle("RegexBundle");
        this.textValidator = new RegexValidator(regexBundle.getString("someText"));
        this.phoneValidator = new RegexValidator(regexBundle.getString("phoneNumber"));
        this.emailValidator = new RegexValidator(regexBundle.getString("email"));
        this.communicator = communicator;
        this.regInformation = regInformation;
    }

    public void requestUserContacts() {
        regInformation.setHomePhone(requestString(MessageType.REQUEST_HOME_PHONE, communicator, phoneValidator));
        regInformation.setMobilePhoneFirst(requestString(MessageType.REQUEST_MOB_PHONE, communicator, phoneValidator));
        regInformation.setMobilePhoneSecond(requestString(MessageType.REQUEST_MOB_PHONE_SECOND, communicator, phoneValidator));
        regInformation.setEmail(requestString(MessageType.REQUEST_EMAIL, communicator, emailValidator));
        regInformation.setSkype(requestString(MessageType.REQUEST_SKYPE, communicator, textValidator));
    }
}
