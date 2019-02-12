public class SumOfSubsequence {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, -2, 40, 43};
        sub(a);
    }

    public static void sub(int[] array) {
        int sum = array[0];
        int sumTotalSub = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                sum = sum + array[i];
            } else {
                if (sum > sumTotalSub) {
                    sumTotalSub = sum;
                }
                sum = array[i];
            }
        }

        if (sum > sumTotalSub)
            sumTotalSub = sum;

        System.out.println("maxSumOfSub = " + sumTotalSub);
    }
}
