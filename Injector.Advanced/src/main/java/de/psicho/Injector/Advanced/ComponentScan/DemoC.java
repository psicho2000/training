package de.psicho.Injector.Advanced.ComponentScan;

import org.springframework.stereotype.Component;

@Component
public class DemoC {
    public DemoC() {
        System.out.println("creating bean C (Component Scan): " + this);
    }
}
