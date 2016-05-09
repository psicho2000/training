package de.psicho.codewars.calculator;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    // same fib must not be calculated twice
    Map<Long, BigInteger> fibHash = new HashMap<Long, BigInteger>();

    public static BigInteger fib(BigInteger n) {
        Fibonacci f = new Fibonacci();
        BigInteger res = null;
        if (n.longValue() >= 0) {
            // formula for positive fib is trivial
            res = f.fibRec(n.longValue());
        } else {
            // formula for negative fib see wikipedia
            res = f.fibRec(n.abs().longValue());
            if (n.abs().mod(BigInteger.valueOf(2L)) == BigInteger.ZERO) {
                res = res.negate();
            }
        }
        return res;
    }

    private BigInteger fibRec(Long n) {
        if (fibHash.containsKey(n)) {
            return fibHash.get(n);
        }

        BigInteger fibRes;
        if (n == 0) {
            fibRes = BigInteger.ZERO;
        } else if (n == 1 || n == 2) {
            fibRes = BigInteger.ONE;
        } else if (n % 2 == 0) {
            // formula for even fib see wikipedia.de
            Long half = n / 2;
            fibRes = fibRec(half + 1).add(fibRec(half - 1)).multiply(fibRec(half));
        } else {
            // formula for odd fib see wikipedia.de
            Long half = n / 2;
            BigInteger fibN = fibRec(half);
            BigInteger fibM = fibRec(half + 1);
            fibRes = fibN.multiply(fibN).add(fibM.multiply(fibM));
        }

        fibHash.put(n, fibRes);
        return fibRes;
    }
}
