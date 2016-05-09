package de.psicho.Generator.Wildcard;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class WildcardTester {
    List<String> list1 = new ArrayList<String>();
    List<Integer> list2 = new ArrayList<Integer>();
    
    public void test() {
        list1.add("one");
        list1.add("two");

        list2.add(1);
        list2.add(2);
        
        System.out.println(UnboundedWildcard.printList(list1));
        System.out.println(UnboundedWildcard.printList(list2));
    }
}
