package de.psicho.Injector.Advanced.ComponentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.psicho.Injector.Advanced.ComponentScan.DemoB;
import de.psicho.Injector.Advanced.ComponentScan.DemoC;

@Component
public class DemoA {
    private DemoB bbb;
    private DemoC ccc;

    public DemoA() {
        System.out.println("creating bean A (Component Scan): " + this);
    }

    @Autowired
    public void setBbb(DemoB bbb) {
        System.out.println("setting A.bbb (Component Scan) with " + bbb);
        this.bbb = bbb;
    }

    @Autowired
    public void setCcc(DemoC ccc) {
        System.out.println("setting A.ccc (Component Scan) with " + ccc);
        this.ccc = ccc;
    }
}
