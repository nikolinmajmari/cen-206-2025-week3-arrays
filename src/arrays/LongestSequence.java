package arrays;

public class LongestSequence {

    public static int findLongestSequence(int[] array) {
        int longestSequence = 0;
        int startIndex = 0;
        int checkIndex = 0;
        int length=0;
        while (startIndex < array.length && checkIndex < array.length) {
            if (array[startIndex] == array[checkIndex]) {
                length++;
                checkIndex++;
            }else {
                startIndex=checkIndex;
                if(length>longestSequence) {
                    longestSequence = length;
                }
                length=0;
            }
        }
        if(length>longestSequence) {
            longestSequence = length;
        }

        return longestSequence;
    }


    public static void main(String[] args) {
        System.out.println(findLongestSequence(new int[]{1,2,4,4,4,5,6,7,7,7,7,7,7,7}));
        /// 4
    }
}
