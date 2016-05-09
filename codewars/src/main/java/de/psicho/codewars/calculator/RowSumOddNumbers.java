package de.psicho.codewars.calculator;

public class RowSumOddNumbers {
    public int rowSumOddNumbersCalc(int n) {
        int lastNumCurLine = lastNumForLine(n);
        int lastNumPrevLine = lastNumForLine(n - 1);
        return (sqr(lastNumCurLine + 1) - sqr(lastNumPrevLine + 1)) / 4;
    }

    private int lastNumForLine(int line) {
        int numCount = sum(line);
        return numCount * 2 - 1;
    }

    private int sum(int n) {
        return n * (n + 1) / 2;
    }

    private int sqr(int n) {
        return n * n;
    }
}
