package de.psicho.Injector.Advanced.OldStyle;

import de.psicho.Injector.Advanced.OldStyle.DemoB;
import de.psicho.Injector.Advanced.OldStyle.DemoC;

public class DemoA {
    private DemoB bbb;
    private DemoC ccc;

    public DemoA() {
        System.out.println("creating bean A (Old style): " + this);
    }

    public void setBbb(DemoB bbb) {
        System.out.println("setting A.bbb (Old style) with " + bbb);
        this.bbb = bbb;
    }

    public void setCcc(DemoC ccc) {
        System.out.println("setting A.ccc (Old style) with " + ccc);
        this.ccc = ccc;
    }
}
