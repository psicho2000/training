package de.psicho.codewars.calculator;

import java.util.Stack;

public class ReversePolishCalculator {

    public double evaluate(String expr) {
        if (expr == null || expr.length() == 0) {
            return 0;
        }

        Stack<String> parts = convertArray(expr.split(" "));

        Node tree = new Node();
        tree.build(parts);
        return tree.calc();
    }

    private Stack<String> convertArray(String[] argParts) {
        Stack<String> parts = new Stack<String>();
        for (int i = 0; i < argParts.length; i++) {
            parts.push(argParts[i]);
        }
        return parts;
    }
}

class Node {
    Node left = null;
    Node right = null;
    Operator op = null;
    double num = 0;

    public Node() {
    }

    public void build(Stack<String> parts) {
        String lastEle = parts.pop();
        if (isNumeric(lastEle)) {
            num = Double.parseDouble(lastEle);
        } else {
            switch (lastEle) {
            case "+":
                op = Operator.ADD;
                break;
            case "-":
                op = Operator.SUB;
                break;
            case "*":
                op = Operator.MUL;
                break;
            case "/":
                op = Operator.DIV;
                break;
            }
            right = new Node();
            right.build(parts);
            left = new Node();
            left.build(parts);
        }
    }

    public double calc() {
        if (op == null) {
            return num;
        } else {
            switch (op) {
            case ADD:
                return left.calc() + right.calc();
            case SUB:
                return left.calc() - right.calc();
            case MUL:
                return left.calc() * right.calc();
            case DIV:
                return left.calc() / right.calc();
            }
        }
        return 0;
    }

    private static boolean isNumeric(String str) {
        try {
            @SuppressWarnings("unused")
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private enum Operator {
        ADD, SUB, MUL, DIV;
    }
}
