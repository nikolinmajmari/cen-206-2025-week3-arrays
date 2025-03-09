import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<String> findPermutations(String s) {
        List<String> permutations = new ArrayList<String>();
        if (s.length()==1){
            permutations.add(s);
            return permutations;
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder permutation = new StringBuilder();
            if(i>0){
                permutation.append(s.substring(0, i));
            }
            if(i<s.length()-1){
                permutation.append(s.substring(i+1, s.length()));
            }
            char ch = s.charAt(i);
            List<String> subPermutations = findPermutations(permutation.toString());
            for(String subPermutation:subPermutations){
                StringBuilder subStringBuilder = new StringBuilder();
                subStringBuilder.append(ch);
                subStringBuilder.append(subPermutation);
                permutations.add(subStringBuilder.toString());
            }
        }
        return permutations;
    }

    public static List<int[]> findPermutations(int[] array){
        ArrayList<int[]> permutations = new ArrayList<>();
        if(array.length==1){
            permutations.add(array);
            return permutations;
        }
        for (int i = 0; i < array.length; i++) {
            int[] subArray = new int[array.length-1];
            if(i>0){
                System.arraycopy(array, 0, subArray, 0, i);
            }
            if(i<array.length-1){
                System.arraycopy(array, i+1, subArray, i, array.length-i-1);
            }
            List<int[]> subPermutations = findPermutations(subArray);
            for(int[] subPermutation:subPermutations){
                int[] newArray = new int[array.length];
                System.arraycopy(subPermutation, 0, newArray, 1, subPermutation.length);
                newArray[0] = array[i];
                permutations.add(newArray);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        String string = "abc";
        int[] array = new int[]{1,2,3};
        List permutations = findPermutations(array);
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
