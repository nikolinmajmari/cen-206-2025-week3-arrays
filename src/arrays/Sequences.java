package arrays;

public class Sequences {
    public static int countIncreasingSequences(int[] array){
        int start=0;
        int end=1;
        int count=0;
        while(start<array.length&& end<array.length){
            if(array[end]>=array[end-1]){
                end++;
                if(end==array.length){
                    /// handle the case when the sequence is in the end ,
                    /// loop is exited before else condition is executed
                    count++;
                }
            }
            else{
                start=end;
                count++;
                while(start<array.length-1 && array[start]>array[start+1]){
                    start++;
                }
                end=start+1;
            }
        }
        return count;
    }

    public static int countDecreasingSequences(int[] array){
        // todo your code here
        return 0;
    }

    public static int countSequenceEdges(int[] array){
        // todo your code here
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countIncreasingSequences(new int[]{1,2,1,3,3,3,2,1,2,2,1,3,3,2,1,0}));
        System.out.println(countDecreasingSequences(new int[]{1,2,4,4,3,1,6,7}));
        System.out.println(countSequenceEdges(new int[]{1,2,3,3,3,2,1,2,2,1,3,3,2,1,1,2,2,3}));
        /// 2
        /// 1
        /// 4
        return;
    }
}
