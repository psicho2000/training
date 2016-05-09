package de.psicho.codewars.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        List<long[]> list = new ArrayList<long[]>();

        long totalSum = n * (n + 1) / 2;

        for (long i = n / 2; i <= n; i++) {
            long x = (totalSum - i) / (i + 1);
            if (x * i == totalSum - i - x) {
                list.add(new long[] { i, x });
            }
        }

        Collections.sort(list, new ArrayComparator());
        return list;
    }
}

class ArrayComparator implements Comparator<long[]> {
    public int compare(long[] a, long[] b) {
        return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    }
}
