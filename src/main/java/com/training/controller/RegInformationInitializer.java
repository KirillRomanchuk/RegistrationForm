package com.training.controller;

import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class RegInformationInitializer extends AbstractInitializer<RegInformation> {
    private List<AbstractInitializer<RegInformation>> initializers;
    /*private AbstractInitializer<RegInformation> fullNameInitializer;
    private AbstractInitializer<RegInformation> addressInitializer;
    private AbstractInitializer<RegInformation> contactsInitializer;
    private AbstractInitializer<RegInformation> groupInitializer;
    private AbstractInitializer<RegInformation> commentInitializer;*/

    public RegInformationInitializer(UserCommunicator communicator, ResourceBundle regexBundle) {
        super(communicator);
        this.initializers = Arrays.asList();
        initializers.add(new UserNameInitializer(communicator, regexBundle));
        initializers.add(new UserGroupInitializer(communicator));
        initializers.add(new UserCommentInitializer(communicator));
        initializers.add(new UserAddressInitializer(communicator, regexBundle));
        initializers.add(new UserContactsInitializer(communicator, regexBundle));
       /* this.fullNameInitializer = new UserNameInitializer(communicator, regexBundle);
        this.addressInitializer = new UserAddressInitializer(communicator, regexBundle);
        this.contactsInitializer = new UserContactsInitializer(communicator, regexBundle);
        this.groupInitializer = new UserGroupInitializer(communicator);
        this.commentInitializer = new UserCommentInitializer(communicator);*/
    }

    @Override
    public void initializer(RegInformation regInformation) {
        initializers.forEach(initializer ->initializer(regInformation));
        /*fullNameInitializer.initializer(regInformation);
        addressInitializer.initializer(regInformation);
        commentInitializer.initializer(regInformation);
        groupInitializer.initializer(regInformation);
        contactsInitializer.initializer(regInformation);*/
    }
}
