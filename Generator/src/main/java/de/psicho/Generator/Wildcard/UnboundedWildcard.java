package de.psicho.Generator.Wildcard;

import java.util.List;

public class UnboundedWildcard {
    public static String printList(List<?> input) {
        StringBuilder s = new StringBuilder();
        for (Object i : input) {
            s.append(i.toString() + " ");
        }
        return s.toString();
    }
}
