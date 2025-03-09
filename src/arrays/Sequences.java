package arrays;

public class Sequences {
    public static int countIncreasingSequences(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isIncreasing = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    isIncreasing = true;
                }else {
                    i = j;
                    break;
                }
            }
            if (isIncreasing) {
                count++;
            }
        }
        return count;
    }

    public static int countDecreasingSequences(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isIncreasing = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    isIncreasing = true;
                }else {
                    i = j;
                    break;
                }
            }
            if (isIncreasing) {
                count++;
            }
        }
        return count;
    }

    public static int countSequenceEdges(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isEdgeOnLeft = true;
            for (int j = i-1; j >=0; j--) {
                if(array[i] < array[j]){
                    isEdgeOnLeft = false;
                    break;
                } else if (array[i]>array[j]) {
                    break;
                }
            }

            boolean isEdgeOnRight = false;
            for (int j = i+1; j < array.length; j++) {
                if(array[i] < array[j] || array[j]>array[j-1]){
                    i = j;
                    if(i == array.length-1){
                        count++;
                    }
                    break;
                }else {
                    isEdgeOnRight = true;
                }
            }

            if(isEdgeOnLeft && (isEdgeOnRight )){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countIncreasingSequences(new int[]{1,2,4,4,3,1,6,7}));
        System.out.println(countDecreasingSequences(new int[]{1,2,4,4,3,1,6,7}));
        System.out.println(countSequenceEdges(new int[]{1,2,3,3,3,2,1,2,2,1,3,3,2,1,1,2,2,3}));
        /// 2
        /// 1
        /// 4
        return;
    }
}
