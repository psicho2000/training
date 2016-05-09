package de.psicho.Injector;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Starting Hello App");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
        MessageController ctrl = (MessageController) context.getBean("messageController");

        ctrl.ProcessMessages();
        
        context.close();
    }
}
