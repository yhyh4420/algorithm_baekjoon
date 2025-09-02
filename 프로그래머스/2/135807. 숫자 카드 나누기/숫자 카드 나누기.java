import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int candA = dividesNone(arrayB, gcdA) ? gcdA : 0;
        int candB = dividesNone(arrayA, gcdB) ? gcdB : 0;

        return Math.max(candA, candB);
    }

    private boolean dividesNone(int[] arr, int d) {
        if (d == 1) return false;
        for (int x : arr) {
            if (x % d == 0) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}
