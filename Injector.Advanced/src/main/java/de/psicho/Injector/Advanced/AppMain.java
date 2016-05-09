package de.psicho.Injector.Advanced;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.psicho.Injector.Advanced.ComponentScan.ConfigurableContentGenerator;
import de.psicho.Injector.Advanced.ComponentScan.ContentGenerator;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("----- Loading Spring application context...");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");

        System.out.println();
        System.out.println("----- Printing bean definition names and aliases...");
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
            for (String t : context.getAliases(s)) {
                System.out.println("\t" + t);
            }
        }

        System.out.println();
        System.out.println("----- Starting examples for (Configurable)ContentGenerator...");
        context.getBean(ContentGenerator.class).generate();
        context.getBean(ConfigurableContentGenerator.class).generate();

        System.out.println();
        System.out.println("----- Spring shutdown...");
        context.close();
    }
}
