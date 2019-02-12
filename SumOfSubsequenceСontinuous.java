public class SumOfSubsequenceСontinuous {
    public static void main(String[] args) {
        int[] a = new int[]{-2, -3, -1, 4, -1, 2, -10, 9, 5};
        sub(a);
    }

    public static void sub(int[] array) {
        int sum = 0;
        int sumTotalSub = array[0] + array[1];
        int n = 0;
        int k = 0;
        while (n != array.length - 1) {
            for (int j = n; k < array.length; k++) {
                sum = sum + array[k];
                if (sum > sumTotalSub) {
                    sumTotalSub = sum;
                }
            }
            n++;
            k = n;
            sum = 0;
        }

        System.out.println("maxSumOfSub = " + sumTotalSub);
    }
}
