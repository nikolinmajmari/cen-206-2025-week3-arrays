package arrays;

public class LongestSequence {

    public static int findLongestSequence(int[] array) {
        int longestSequence = 0;
        int currrentSequence = 0;

        for (int i = 0; i < array.length; i++) {
            currrentSequence = 1;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    currrentSequence++;
                }else {
                    break;
                }
            }
            if (currrentSequence > longestSequence) {
                longestSequence = currrentSequence;
            }
        }
        return longestSequence;
    }


    public static void main(String[] args) {
        System.out.println(findLongestSequence(new int[]{1,2,4,4,4,5,6,7,7,7,7,8,9,10}));
    }
}
