package de.psicho.Generator.GenericList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericsTester {

    @Autowired
    GenericList<String> genStringList;

    @Autowired
    GenericList<Integer> genIntList;
    
    public void test() {
        genIntList.add(5);
        genIntList.add(7);
        genIntList.print();

        genStringList.add("abra");
        genStringList.add("kadabra");
        genStringList.print();
    }
}
