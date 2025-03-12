package arrays;

public class LongestSequence {

    public static int findLongestSequence(int[] array) {
        int start=0;
        int end=0;
        int max=1;
        while(start!=array.length && end<array.length){
            if(array[start]==array[end]){
                end++;
                int length=end-start;
                if(length>max){
                    max=length;
                }
            }
            else{
                start=end;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(findLongestSequence(new int[]{1,2,4,4,4,5,6,7,7,7,7,7,7,7}));
        /// 4
    }
}
