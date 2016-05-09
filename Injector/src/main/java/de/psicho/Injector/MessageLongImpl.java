package de.psicho.Injector;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageLongImpl implements IMessage {
    @Autowired
    String messageContent;
    
    public String getMessage() {
        messageContent = "Hello my brave new world of misconception!";
        return messageContent;
    }
}
