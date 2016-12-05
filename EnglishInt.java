import java.util.*;

public class EnglishInt {
    private static final String[] ONES = {"", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"};

    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Fourty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String[] BLOCKS = {"", "Thousand", "Million", "Trillion",
        "Quadrillion"};

    private static String englishInt(int x) {
        StringBuilder sb = new StringBuilder();
        int blockCount = 0;
        while (x > 0) {
            if (blockCount > 0 && x % 1000 > 0) {
                sb.insert(0, BLOCKS[blockCount] + ", ");
            }
            int hundreds = (x % 1000) / 100;
            int tens = x % 100;
            if (tens < 20) {
                sb.insert(0, ONES[tens] + " ");
            } else {
                sb.insert(0, ONES[tens % 10] + " ");
                sb.insert(0, TENS[tens / 10] + " ");
            }
            if (hundreds > 0) {
                sb.insert(0, ONES[hundreds] + " Hundred ");
            }
            
            blockCount++;
            x /= 1000;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int in = sc.nextInt();
            System.out.println(englishInt(in));
        }
    }
}