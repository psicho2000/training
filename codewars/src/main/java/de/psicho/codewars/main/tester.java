package de.psicho.codewars.main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import de.psicho.codewars.calculator.BrainLuck;

public class tester {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.";
        assertThat(new BrainLuck(code).process(""), is("Hello World!"));

        assertThat(new BrainLuck(",+[-.,+]").process("Codewars" + ((char) 255)), is("Codewars"));
        assertThat(new BrainLuck(",[.[-],]").process("Codewars" + ((char) 0)), is("Codewars"));

        final char[] input = { 8, 9 };
        assertThat(new BrainLuck(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.").process(String.valueOf(input[0]) + String.valueOf(input[1])),
                is(String.valueOf((char) (input[0] * input[1]))));

        long duration = System.currentTimeMillis() - start;
        System.out.println("Dauer: " + duration + " ms");
    }
}
