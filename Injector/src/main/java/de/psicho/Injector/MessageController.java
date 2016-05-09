package de.psicho.Injector;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageController {
    @Autowired
    IMessage  myMessage;
    
    public void ProcessMessages() {
        System.out.println(myMessage.getMessage());
    }
}
