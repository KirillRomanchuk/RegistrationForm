package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserCommentInitializerTest {
    @Mock
    private UserCommunicator communicator;

    @InjectMocks
    private UserCommentInitializer initializer;

    @Test
    public void initialize() {
        String value = "testValue";
        when(communicator.requestTextValue(MessageType.REQUEST_COMMENT)).thenReturn(value);
        RegInformation regInformation = mock(RegInformation.class);

        initializer.initialize(regInformation);
        verify(regInformation).setComment(value);
    }
}