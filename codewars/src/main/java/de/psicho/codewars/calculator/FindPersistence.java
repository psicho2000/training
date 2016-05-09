package de.psicho.codewars.calculator;

public class FindPersistence {
    public int findPersistence(long n, int persist) {
        if (n < 10) {
            return persist;
        } else {
            long mult = multiply(n);
            return findPersistence(mult, persist + 1);
        }
    }

    private long multiply(long n) {
        long mult = 1;
        long remainder = n;
        while (remainder > 0) {
            mult *= (remainder % 10);
            remainder /= 10;
        }
        return mult;
    }
}
