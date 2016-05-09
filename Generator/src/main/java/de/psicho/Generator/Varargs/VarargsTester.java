package de.psicho.Generator.Varargs;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class VarargsTester {
    private int sum(int... numbers) {
        int total = 0;
        for (int i : numbers) {
            total += i;
        }
        return total;
    }
    
    private String cat(String... stringlist) {
        return StringUtils.join(stringlist, " ");
    }

    public void test() {
        System.out.println(sum(1, 2, 3, 4, 5));
        System.out.println(cat("my", "dog", "sits", "on", "the", "veranda"));
    }
}
