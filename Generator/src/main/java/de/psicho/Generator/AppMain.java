package de.psicho.Generator;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import de.psicho.Generator.GenericList.GenericsTester;
import de.psicho.Generator.Wildcard.WildcardTester;
import de.psicho.Generator.Varargs.VarargsTester;
import de.psicho.Generator.Invoke.Invocator;

public class AppMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");
        context.getBean(GenericsTester.class).test();
        context.getBean(WildcardTester.class).test();
        context.getBean(VarargsTester.class).test();
        context.getBean(Invocator.class).test();
        context.close();
    }

}
