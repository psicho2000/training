package de.psicho.Injector.Advanced.ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableContentGenerator {

    @Autowired
    @Qualifier("ContentService")
    IContent content;

    public void generate() {
        System.out.println("ConfigurableContentGenerator: " + content.getContent());
    }
}
