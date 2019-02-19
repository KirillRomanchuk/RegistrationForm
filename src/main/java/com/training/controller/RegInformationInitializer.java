package com.training.controller;

import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegInformationInitializer extends AbstractInitializer<RegInformation> {
    private List<AbstractInitializer<RegInformation>> initializers;

    public RegInformationInitializer(UserCommunicator communicator, ResourceBundle regexBundle) {
        super(communicator);
        this.initializers = new ArrayList<>();
        initializers.add(new UserNameInitializer(communicator, regexBundle));
        initializers.add(new UserGroupInitializer(communicator));
        initializers.add(new UserCommentInitializer(communicator));
        initializers.add(new UserAddressInitializer(communicator, regexBundle));
        initializers.add(new UserContactsInitializer(communicator, regexBundle));
    }

    @Override
    public void initialize(RegInformation regInformation) {
        initializers.forEach(initializer -> initializer.initialize(regInformation));
    }
}
