import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<String> findPermutations(String s) {
        List<String> permutations = new ArrayList<String>();
        // todo your code here
        return permutations;
    }

    public static List<int[]> findPermutations(int[] array){
        ArrayList<int[]> permutations = new ArrayList<>();
        if(array.length==1){
            permutations.add(new int[]{array[0]});
            return permutations;
        }
        for(int i=0; i<array.length; i++){
            int[] newArray = new int[array.length-1];
            if(i==0){
                System.arraycopy(array,1,newArray,0,array.length-1);
            } else if (i==array.length-1) {
                System.arraycopy(array,0,newArray,0,array.length-1);
            }else {
                System.arraycopy(array,0,newArray,0,i);
                System.arraycopy(array,i+1,newArray,i,array.length-i-1);
            }
            List<int[]> newPermutations = findPermutations(newArray);
            for (int[] permutation : newPermutations) {
                int[] newPermutation = new int[array.length];
                System.arraycopy(permutation,0,newPermutation,0,permutation.length);
                newPermutation[array.length-1] = array[i];
                permutations.add(newPermutation);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        String string = "abc";
        int[] array = new int[]{1,2,3};
        List<int[]> permutations = findPermutations(array);
        for(Object permutation:permutations){
            if(permutation instanceof int[]){
                System.out.println(Arrays.toString((int[]) permutation));
            }else{
                System.out.println(permutation);
            }
        }
        /**
         * abc
         * acb
         * bac
         * bca
         * cab
         * cba
         * ---
         *
         *
         */
    }
}
