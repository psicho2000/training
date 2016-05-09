package de.psicho.Generator.GenericList;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype")
public class GenericList<X> {

    @Autowired
    LinkedList<X> internalList;

    public void add(X element) {
        internalList.add(element);
    }

    public void print() {
        for (X element : internalList) {
            System.out.println(element);
        }
        System.out.println("------");
    }

}
