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
        regInformation.setUserGroup(requestEnum(MessageType.REQUEST_USER_GROUP, enumValidator, UserGroup.class, UserGroup.values()));
    }
}
