package com.training;

import com.training.communication.UserCommunicator;
import com.training.controller.RegInformationInitializer;

public class Main {
    public static void main(String[] args) {
        UserCommunicator communicator = new UserCommunicator(System.in);
        RegInformationInitializer regInformation = new RegInformationInitializer(communicator);
        regInformation.startUserRegistration();
    }
}
