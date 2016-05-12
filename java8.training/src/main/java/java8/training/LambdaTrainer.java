package java8.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class LambdaTrainer {
    public void lambdarize() {
        runner();
        summarize();
        compareIt();
    }

    private void compareIt() {
        final List<String> strList = Arrays.asList("Buenos Aires", "Córdoba", "La Plata"); // unveränderlich
        List<String> strList2 = new ArrayList<String>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")); // veränderlich
        List<String> strList3 = Lists.newArrayList("str1", "str2", "str3"); // Google Guava, veränderlich

        Comparator<String> comp = (final String str1, final String str2) -> {
            return Integer.compare(str1.length(), str2.length());
        };
        strList.sort(comp);
        strList.forEach(str -> System.out.println(str));
    }

    private void summarize() {
        int a = 15;
        int b = 30;

        Calculator calc = (x, y) -> x * y;
        System.out.println(calc.calc(a, b));
    }

    private void runner() {
        System.out.println("=== RunnableTest ===");

        // Anonymous Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world one!");
            }
        };

        // Lambda Runnable
        Runnable r2 = () -> System.out.println("Hello world two!");

        // Lambda method
        Runnable r3 = this::myMethod;

        // Run em!
        r1.run();
        r2.run();
        r3.run();
    }

    private void myMethod() {
        System.out.println("Hello world three!");
    }
}