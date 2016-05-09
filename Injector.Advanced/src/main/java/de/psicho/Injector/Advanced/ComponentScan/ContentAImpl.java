package de.psicho.Injector.Advanced.ComponentScan;

import org.springframework.stereotype.Component;

@Component(value="contentStub")
public class ContentAImpl implements IContent {

    public String getContent() {
        return "Implementation Type A - stub.";
    }

}
