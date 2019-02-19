package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;

public class UserCommentInitializer extends AbstractInitializer <RegInformation> {

    public UserCommentInitializer(UserCommunicator communicator) {
        super(communicator);
    }

    @Override
    public void initialize(RegInformation regInformation) {
        regInformation.setComment(communicator.requestTextValue(MessageType.REQUEST_COMMENT));
    }
}
