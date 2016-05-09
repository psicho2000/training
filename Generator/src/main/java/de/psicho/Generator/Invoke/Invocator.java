package de.psicho.Generator.Invoke;

import java.lang.reflect.*;

import org.springframework.stereotype.Component;

@Component
public class Invocator {
    private void InvokeWithParams(String methodName, String param) {
        try {
            Invokee inv = new Invokee();
            Method method = Invokee.class.getMethod(methodName, String.class);
            String returnValue = (String) method.invoke(inv, param);
            System.out.println(returnValue);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void Invoke(String methodName) {
        try {
            Class<?> inv = Invokee.class;
            Method method = inv.getMethod(methodName);
            String returnValue = (String) method.invoke(null);
            System.out.println(returnValue);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        Invoke("Hello");
        Invoke("World");
        Invoke("DoesNotExist");

        InvokeWithParams("Hello", "my friend");
        InvokeWithParams("World", "class java code");
        InvokeWithParams("Unknown", "exception");
    }
}
