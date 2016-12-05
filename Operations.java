import java.util.*;

public class Operations {

    /**
    * Multiplication using only addition.
    * TODO: Fix this. It uses multiplication
    */
    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);
        }
        int result = 0;
        for (int i = abs(b); i > 0; i = subtract(i, 1)) {
            result += a;
        }
        if (b < 0) {
            result = negate(result);
        }

        return result;
    }

    public static int abs(int a) {
        if (a < 0)
            return negate(a);
        else
            return a;
    }

    public static int subtract(int a, int b) {
        return a + negate(b);
    }

    public static int divide(int a, int b) {
        int result = 0;
        int sum = 0;
        int absa = abs(a);
        int absb = abs(b);
        while (sum + absb <= absa) {
            sum += absb;
            result++;
        }
        if (a < 0 != b < 0)
            result = negate(result);
        return result;
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
        System.out.println(multiply(-5, 6));
        System.out.println(multiply(5, -6));
        System.out.println(multiply(-5, -6));
        System.out.println(negate(1));
        System.out.println(negate(5));
        System.out.println(negate(-200));
        System.out.println(subtract(100, 23));
        System.out.println(divide(10, 3));
        System.out.println(divide(-30, 15));
        System.out.println(divide(30, -15));
        System.out.println(divide(-30, -15));
    }
}