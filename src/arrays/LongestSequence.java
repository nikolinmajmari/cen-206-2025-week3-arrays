package arrays;

public class LongestSequence {

    public static int findLongestSequence(int[] array) {
        int longestSequence = 0;
        int length=0;
        int start=0;
        int end=0;
        while (start<array.length && end<array.length) {
            if (array[start]==array[end]) {
                length++;
                end++;
            }
            else {
                start=end;
                longestSequence=Math.max(length,longestSequence);
                length=0;

            }
        }

        return Math.max(length,longestSequence);
    }


    public static void main(String[] args) {
        System.out.println(findLongestSequence(new int[]{1,2,4,4,4,5,6,7,7,7,7,7,7,7}));
        /// 4
    }
}
