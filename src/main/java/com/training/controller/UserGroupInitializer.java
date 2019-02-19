package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import com.training.model.UserGroup;
import com.training.validator.EnumValidator;

public class UserGroupInitializer extends AbstractInitializer<RegInformation> {
    private EnumValidator<UserGroup> enumValidator;

    public UserGroupInitializer(UserCommunicator communicator) {
        super(communicator);
        this.enumValidator = new EnumValidator<>(UserGroup.values());
    }

    @Override
    public void initialize(RegInformation regInformation) {
        UserGroup returnValue = null;
        while (returnValue == null) {
            String inputValue = communicator.requestTextValue(MessageType.REQUEST_USER_GROUP);
            if (enumValidator.isValid(inputValue)) {
                returnValue = UserGroup.valueOf(inputValue.toUpperCase());
            } else {
                communicator.viewErrorMessage(MessageType.WRONG_INPUT_VALUE);
                communicator.viewNoTypeMessage(String.format("Available groups: [%s]", UserGroup.values()));
            }
        }
        regInformation.setUserGroup(returnValue);
    }
}
