class DivingBoard {
    public static int[] divingBoard(int k, int shorter, int longer) {
        int[] result = new int[k + 1];
        int current = k * shorter;
        result[0] = current;
        final int difference = longer - shorter;
        for (int i = 1; i <= k; i++) {
            current += difference;
            result[i] = current;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = divingBoard(3, 3, 5);
        for (int i = 0; i < test1.length; i++) {
            System.out.print(test1[i] + " ");
        }
        System.out.println();
        int[] test2 = divingBoard(10, 11, 70);
        for (int i = 0; i < test2.length; i++) {
            System.out.print(test2[i] + " ");
        }
        System.out.println();
        int[] test3 = divingBoard(0, 18, 19);
        for (int i = 0; i < test3.length; i++) {
            System.out.print(test3[i] + " ");
        }
        System.out.println();
    }
}