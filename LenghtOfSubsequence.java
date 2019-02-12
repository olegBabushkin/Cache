public class LenghtOfSubsequence {

    private static int[] seq = new int[]{5, 6, 7, -2, 1, 2, 5, 8, 8};
    private static int firstInx = 0;
    private static int maxLength = 1;

    private static void findSub() {

        int currentLength = 1;

        for (int i = 1, nextInx = 0; i < seq.length; i++) {
            if (seq[i] > seq[i - 1]) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    firstInx = nextInx;
                }
                currentLength = 1;
                nextInx = i;
            }
        }
        if (currentLength == seq.length) {
            maxLength = currentLength;
        }
    }

    public static void main(String[] args) {

        findSub();

        if (maxLength == 1) {
            System.out.println("Subsequence is missing");
        } else {
            System.out.println("MaxSubsequenceOfLenght:");
            for (int i = firstInx; i < firstInx + maxLength; i++) {
                System.out.print(seq[i] + " ");
            }
        }
    }
}