package com.training.controller;

import com.training.communication.MessageType;
import com.training.model.UserAddress;
import com.training.validator.NumberValidator;
import com.training.validator.RegexValidator;
import com.training.validator.Validator;

import java.util.ResourceBundle;

public class UserAddressInitializer extends AbstractInitializer {
    private Validator<String> textValidator;
    private Validator<Integer> intValidator;
    private UserAddress userAddress;

    public UserAddressInitializer() {
        ResourceBundle regexBundle = ResourceBundle.getBundle("RegexBundle");
        this.textValidator = new RegexValidator(regexBundle.getString("address"));
        this.intValidator = new NumberValidator();
        this.userAddress = new UserAddress();
    }

    public UserAddress requestUserAddress() {
        userAddress.setCity(requestString(MessageType.REQUEST_CITY, textValidator));
        userAddress.setStreet(requestString(MessageType.REQUEST_STREET, textValidator));
        userAddress.setHouseNumber(requestString(MessageType.REQUEST_HOUSE_NUM, textValidator));
        userAddress.setFlatNumber(requestString(MessageType.REQUEST_FLAT, textValidator));
        userAddress.setIndex(requestInt(MessageType.REQUEST_INDEX, intValidator));
        userAddress.setFullAddress(createFullAddress());

        return userAddress;
    }

    private String createFullAddress() {
        return String.format("%s, %s №%s, №%s, %s", userAddress.getCity(),
                userAddress.getStreet(),
                userAddress.getHouseNumber(),
                userAddress.getFlatNumber(),
                userAddress.getIndex());
    }
}
