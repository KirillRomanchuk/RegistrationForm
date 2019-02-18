package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import com.training.model.UserGroup;
import com.training.validator.EnumValidator;

public class RegInformationInitializer extends AbstractInitializer {
    private UserCommunicator communicator;
    private UserFullNameInitializer userFullName;
    private UserAddressInitializer userAddressInit;
    private UserContactsInitializer userContactsInitializer;

    public RegInformationInitializer(UserCommunicator communicator) {
        this.communicator = communicator;
        this.userFullName = new UserFullNameInitializer();
        this.userAddressInit = new UserAddressInitializer();
        this.userContactsInitializer = new UserContactsInitializer();
    }

    public void startUserRegistration() {
        RegInformation regInformation = new RegInformation();
        userFullName.requestFullNameInformation(regInformation);
        regInformation.setComment(requestComments(communicator));
        regInformation.setUserGroup(requestUserGroup(communicator));
        userContactsInitializer.requestUserContacts(regInformation);
        regInformation.addUserAddress(userAddressInit.requestUserAddress());
    }

    private UserGroup requestUserGroup(UserCommunicator communicator) {
        EnumValidator enumValidator = new EnumValidator<>(UserGroup.values());
        UserGroup returnValue = null;
        boolean isEmpty = false;
        while (!isEmpty) {
            String inputValue = communicator.requestTextValue(MessageType.REQUEST_USER_GROUP);
            if (enumValidator.checkValue(inputValue)) {
                returnValue = UserGroup.valueOf(inputValue.toUpperCase());
                isEmpty = true;
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                communicator.viewNoTypeMessage(String.format("Available groups: [%s]", UserGroup.values()));
            }
        }
        return returnValue;
    }

    private String requestComments(UserCommunicator communicator) {
        return communicator.requestTextValue(MessageType.REQUEST_COMMENT);
    }
}
