package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.UserAddress;

import java.util.ResourceBundle;

public class UserAddressInitializer extends AbstractInitializer {
    private Validator<String> textValidator;
    private Validator<Integer> intValidator;
    private ResourceBundle regexBundle;
    private UserCommunicator communicator;
    private UserAddress userAddress;

    public UserAddressInitializer(UserCommunicator communicator) {
        this.communicator = communicator;
        this.regexBundle = ResourceBundle.getBundle("RegexBundle");
        this.textValidator = new RegexValidator(regexBundle.getString("address"));
        this.intValidator = new NumberValidator();
        this.userAddress = new UserAddress();
    }

    public UserAddress requestUserAddress() {
        userAddress.setCity(requestString(MessageType.REQUEST_CITY, communicator, textValidator));
        userAddress.setStreet(requestString(MessageType.REQUEST_STREET, communicator, textValidator));
        userAddress.setHouseNumber(requestString(MessageType.REQUEST_HOUSE_NUM, communicator, textValidator));
        userAddress.setFlatNumber(requestString(MessageType.REQUEST_FLAT, communicator, textValidator));
        userAddress.setIndex(requestInt(MessageType.REQUEST_INDEX, communicator, intValidator));
        userAddress.setFullAddress(createFullAddress());

        return userAddress;
    }

    private String createFullAddress() {
        return String.format("%s, %s №%s, №%s, %s", userAddress.getCity()
                // TODO (Eugene): 2/18/2019 move comma after statement
                , userAddress.getStreet()
                , userAddress.getHouseNumber()
                , userAddress.getFlatNumber()
                , userAddress.getIndex());
    }
}
