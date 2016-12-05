import java.util.*;

public class Operations {

    /**
    * Multiplication using only addition.
    * TODO: Fix this. It uses multiplication
    */
    public static int multiply(int a, int b) {
        boolean negative = ((a >>> 31) ^ (b >>> 31)) == 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int result = 0;
        for (int i = 0; i < b; i++) {
            result += a;
        }
        if (negative) {
            result *= -1;
        }
        return result;
    }

    public static int subtract(int a, int b) {
        return a + negate(b);
    }

    public static int divide(int a, int b) {
        // TODO: Finish
        return 0;
    }

    public static int negate(int a) {
        int newSign = (a < 0) ? 1 : -1;
        int result = 0;
        while (a != 0) {
            a += newSign;
            result += newSign;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(multiply(5, 6));
        System.out.println(negate(1));
        System.out.println(negate(5));
        System.out.println(negate(-200));
        System.out.println(subtract(100, 23));
        System.out.println(divide(30, 15));
    }
}