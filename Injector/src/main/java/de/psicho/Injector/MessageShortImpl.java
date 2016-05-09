package de.psicho.Injector;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageShortImpl implements IMessage {
    @Autowired
    String messageContent;
    
    public String getMessage() {
        messageContent = "Hello World!";
        return messageContent;
    }
}
