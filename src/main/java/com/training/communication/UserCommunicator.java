package com.training.communication;

import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserCommunicator {

    private Scanner scan;
    // TODO (Eugene): 2/18/2019 rename to messageBundle
    private ResourceBundle messageText;

    public UserCommunicator(InputStream text) {
        this.scan = new Scanner(text);
        this.messageText = ResourceBundle.getBundle("MessageTextBundle");
    }

    private void viewMessage(String text) {
        System.out.println(text);
    }

    public void viewNoTypeMessage(String text) {
        viewMessage(text);
    }

    public void viewErrorMessage(MessageType messageType) {
        viewMessage(messageText.getString(messageType.name()));
    }

    public String requestTextValue(MessageType messageType) {
        viewMessage(messageText.getString(messageType.name()));
        return scan.nextLine();
    }

    public Integer requestNumberValue(MessageType messageType) {
        viewMessage(messageText.getString(messageType.name()));
        return scan.nextInt();
    }


}
