package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import com.training.model.UserAddress;
import com.training.validator.NumberValidator;
import com.training.validator.RegexValidator;
import com.training.validator.Validator;

import java.util.ResourceBundle;

public class UserAddressInitializer extends AbstractInitializer<RegInformation> {
    private Validator<String> textValidator;
    private Validator<Integer> intValidator;

    public UserAddressInitializer(UserCommunicator communicator, ResourceBundle regexBundle) {
        super(communicator);
        this.textValidator = new RegexValidator(regexBundle.getString("address"));
        this.intValidator = new NumberValidator();
    }

    @Override
    public void initialize(RegInformation regInformation) {
        UserAddress userAddress = new UserAddress();
        userAddress.setCity(requestString(MessageType.REQUEST_CITY, textValidator));
        userAddress.setStreet(requestString(MessageType.REQUEST_STREET, textValidator));
        userAddress.setHouseNumber(requestString(MessageType.REQUEST_HOUSE_NUM, textValidator));
        userAddress.setFlatNumber(requestString(MessageType.REQUEST_FLAT, textValidator));
        userAddress.setIndex(requestInt(MessageType.REQUEST_INDEX, MessageType.WRONG_ENTER_NUMBER,intValidator));
        userAddress.setFullAddress(createFullAddress(userAddress));
        regInformation.addUserAddress(userAddress);
    }

    private String createFullAddress(UserAddress userAddress) {
        return String.format("%s, %s №%s, №%s, %s", userAddress.getCity(),
                userAddress.getStreet(),
                userAddress.getHouseNumber(),
                userAddress.getFlatNumber(),
                userAddress.getIndex());
    }
}
