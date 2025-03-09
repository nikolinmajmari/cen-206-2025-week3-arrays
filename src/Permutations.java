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
        // todo your code here
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
