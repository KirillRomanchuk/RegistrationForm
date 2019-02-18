package com.training;

import com.training.communication.UserCommunicator;
import com.training.controller.RegInformationInitializer;
import com.training.model.RegInformation;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        UserCommunicator communicator = new UserCommunicator(System.in);
        ResourceBundle regexBundle = ResourceBundle.getBundle("RegexBundle");
        RegInformation regInformation = new RegInformation();
        RegInformationInitializer regInformationInitializer = new RegInformationInitializer(communicator, regexBundle);
        regInformationInitializer.initializer(regInformation);
    }
}
