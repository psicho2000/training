package de.psicho.Injector.Advanced.AnnotationConfig;

import org.springframework.beans.factory.annotation.Autowired;

import de.psicho.Injector.Advanced.AnnotationConfig.DemoB;
import de.psicho.Injector.Advanced.AnnotationConfig.DemoC;

public class DemoA {
    private DemoB bbb;
    private DemoC ccc;

    public DemoA() {
        System.out.println("creating bean A (Annotation config): " + this);
    }

    @Autowired
    public void setBbb(DemoB bbb) {
        System.out.println("setting A.bbb (Annotation config) with " + bbb);
        this.bbb = bbb;
    }

    @Autowired
    public void setCcc(DemoC ccc) {
        System.out.println("setting A.ccc (Annotation config) with " + ccc);
        this.ccc = ccc;
    }
}
