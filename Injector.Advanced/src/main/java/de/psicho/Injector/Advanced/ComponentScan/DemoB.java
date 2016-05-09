package de.psicho.Injector.Advanced.ComponentScan;

import org.springframework.stereotype.Component;

@Component
public class DemoB {
    public DemoB() {
        System.out.println("creating bean B (Component Scan): " + this);
    }
}
