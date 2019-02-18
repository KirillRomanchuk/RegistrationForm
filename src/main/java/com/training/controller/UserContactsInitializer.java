package com.training.controller;

import com.training.communication.MessageType;
import com.training.model.RegInformation;
import com.training.validator.RegexValidator;
import com.training.validator.Validator;

import java.util.ResourceBundle;

public class UserContactsInitializer extends AbstractInitializer {
    private Validator<String> textValidator;
    private Validator<String> phoneValidator;
    private Validator<String> emailValidator;

    public UserContactsInitializer() {
        ResourceBundle regexBundle = ResourceBundle.getBundle("RegexBundle");
        this.textValidator = new RegexValidator(regexBundle.getString("onlyText"));
        this.phoneValidator = new RegexValidator(regexBundle.getString("phoneNumber"));
        this.emailValidator = new RegexValidator(regexBundle.getString("email"));
    }

    public void requestUserContacts(RegInformation regInformation) {
        regInformation.setHomePhone(requestString(MessageType.REQUEST_HOME_PHONE, phoneValidator));
        regInformation.setMobilePhoneFirst(requestString(MessageType.REQUEST_MOB_PHONE, phoneValidator));
        regInformation.setMobilePhoneSecond(requestString(MessageType.REQUEST_MOB_PHONE_SECOND, phoneValidator));
        regInformation.setEmail(requestString(MessageType.REQUEST_EMAIL, emailValidator));
        regInformation.setSkype(requestString(MessageType.REQUEST_SKYPE, textValidator));
    }
}
