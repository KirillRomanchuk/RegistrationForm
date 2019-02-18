package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import com.training.validator.RegexValidator;
import com.training.validator.Validator;

import java.util.ResourceBundle;

public class UserContactsInitializer extends AbstractInitializer<RegInformation> {
    private Validator<String> textValidator;
    private Validator<String> phoneValidator;
    private Validator<String> emailValidator;

    public UserContactsInitializer(UserCommunicator communicator, ResourceBundle regexBundle) {
        super(communicator);
        this.textValidator = new RegexValidator(regexBundle.getString("onlyText"));
        this.phoneValidator = new RegexValidator(regexBundle.getString("phoneNumber"));
        this.emailValidator = new RegexValidator(regexBundle.getString("email"));
    }

    @Override
    public void initializer(RegInformation regInformation) {
        regInformation.setHomePhone(requestString(MessageType.REQUEST_HOME_PHONE, phoneValidator));
        regInformation.setMobilePhoneFirst(requestString(MessageType.REQUEST_MOB_PHONE, phoneValidator));
        regInformation.setMobilePhoneSecond(requestString(MessageType.REQUEST_MOB_PHONE_SECOND, phoneValidator));
        regInformation.setEmail(requestString(MessageType.REQUEST_EMAIL, emailValidator));
        regInformation.setSkype(requestString(MessageType.REQUEST_SKYPE, textValidator));
    }
}
