package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import com.training.model.UserGroup;

public class RegInformationInitializer extends AbstractInitializer {
    private RegInformation regInformation;
    private UserCommunicator communicator;
    private UserFullNameInitializer userFullName;
    private UserAddressInitializer userAddressInit;
    private UserContactsInitializer userContactsInitializer;

    public RegInformationInitializer() {
        this.communicator = new UserCommunicator(System.in);
        this.regInformation = new RegInformation();
        this.userFullName = new UserFullNameInitializer(regInformation, communicator);
        this.userAddressInit = new UserAddressInitializer(communicator);
        this.userContactsInitializer = new UserContactsInitializer(regInformation, communicator);
    }

    public void startUserRegistration() {
        userFullName.requestFullNameInformation();
        regInformation.setComment(requestComments(communicator));
        regInformation.setUserGroup(requestUserGroup(communicator));
        regInformation.addUserAddress(userAddressInit.requestUserAddress());
        userContactsInitializer.requestUserContacts();
    }

    private UserGroup requestUserGroup(UserCommunicator communicator) {
        EnumValidator enumValidator = new EnumValidator<>(UserGroup.values());
        UserGroup returnValue = null;
        String inputValue;
        boolean isEmpty = false;
        while (!isEmpty) {
            inputValue = communicator.requestTextValue(MessageType.REQUEST_USER_GROUP);
            if (enumValidator.checkValue(inputValue)) {
                returnValue = UserGroup.valueOf(inputValue.toUpperCase());
                isEmpty = true;
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                communicator.viewNoTypeMessage(String.format("Available groups: [%s]", UserGroup.values().toString()));
            }
        }
        return returnValue;
    }

    private String requestComments(UserCommunicator communicator) {
        return communicator.requestTextValue(MessageType.REQUEST_COMMENT);
    }
}
