class BinaryString {

    public static String binString(double n) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            if (result.length() > 31)
                return "ERROR";

        }
    }
    public static void main(String[] args) {
        System.out.println(binString(0.25));
        //expected .01
    }
}