package com.training.controller;

import com.training.communication.MessageType;
import com.training.communication.UserCommunicator;
import com.training.model.RegInformation;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedUserCommentInitializerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private UserCommunicator communicator;

    @InjectMocks
    private UserCommentInitializer initializer;

    @Test
    @Parameters(method = "initializeData")
    public void initialize(String value) {
        when(communicator.requestTextValue(MessageType.REQUEST_COMMENT)).thenReturn(value);
        RegInformation regInformation = mock(RegInformation.class);

        initializer.initialize(regInformation);
        verify(regInformation).setComment(value);
    }

    public Object[] initializeData() {
        return new Object[][] {
                {"testValue"},
                {"qwe asd"},
                {""}
        };
    }
}