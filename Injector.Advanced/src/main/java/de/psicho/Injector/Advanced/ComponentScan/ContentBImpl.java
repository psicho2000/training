package de.psicho.Injector.Advanced.ComponentScan;

import org.springframework.stereotype.Component;

@Component(value="contentProd")
public class ContentBImpl implements IContent {

    public String getContent() {
        return "Implementation Type B - fully qualified string.";
    }

}
