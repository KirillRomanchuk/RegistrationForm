package com.training.communication;

import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserCommunicator {

    private Scanner scanner;
    private ResourceBundle messageBundle;

    public UserCommunicator(InputStream text) {
        this.scanner = new Scanner(text);
        this.messageBundle = ResourceBundle.getBundle("MessageTextBundle");
    }

    public void viewMessage(MessageType messageType, Object... args) {
        System.out.println(String.format(messageBundle.getString(messageType.name()), args));
    }

    public String requestTextValue(MessageType messageType) {
        viewMessage(messageType);
        return scanner.nextLine();
    }

    public Integer requestNumberValue(MessageType messageType) {
        viewMessage(messageType);
        while (!scanner.hasNextInt()) {
            viewMessage(MessageType.WRONG_ENTER_NUMBER);
            scanner.next();
        }
        return Integer.parseInt(scanner.nextLine());
    }
}
