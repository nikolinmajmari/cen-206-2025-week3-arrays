package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Joins {

    public static Object[] mergeArrays(Object[] left, Object[] right) {
        Object[] newObject = new Object[left.length+right.length];
        System.arraycopy(left, 0, newObject, 0, left.length);
        System.arraycopy(right, 0, newObject, left.length, right.length);
        return newObject;
    }

    public static ArrayList<Object[]> joinOnEqual(Object[][]left,Object[][]right,int leftIndex,int rightIndex) {
        ArrayList<Object[]> joined = new ArrayList<>();
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                Object[] leftRow = left[i];
                Object[] rightRow = right[j];
                if (leftRow[leftIndex].equals(rightRow[rightIndex])) {
                    Object[] joinedRow = mergeArrays(left,right);
                    joined.add(joinedRow);
                }
            }
        }
        return joined;
    }

    public static void main(String[] args) {
        Object[][] students = new Object[][]{
                // id, email, cityid
                {1,"ab@gmail.com",1},
                {2,"ac@gmail.com",1},
                {3,"ad@gmail.com",1},
                {4,"ae@gmail.com",2},
                {5,"af@gmail.com",2},
                {6,"ba@gmail.com",3},
                {7,"ca@gmail.com",3},
                {8,"da@gmail.com",3},
                {9,"ea@gmail.com",4},
        };

        Object[][] cityes = new Object[][]{
                {1,"Tirane"},
                {2,"Durres"},
                {3,"Shkoder"},
                {4,"Diber"},
        };

        ArrayList<Object[]> joined = joinOnEqual(students,cityes,2,0);
        for (Object[] row : joined) {
            System.out.println(Arrays.toString(row));
        }
        /**
         * [1, ab@gmail.com, 1, 1, Tirane]
         * [2, ac@gmail.com, 1, 1, Tirane]
         * [3, ad@gmail.com, 1, 1, Tirane]
         * [4, ae@gmail.com, 2, 2, Durres]
         * [5, af@gmail.com, 2, 2, Durres]
         * [6, ba@gmail.com, 3, 3, Shkoder]
         * [7, ca@gmail.com, 3, 3, Shkoder]
         * [8, da@gmail.com, 3, 3, Shkoder]
         * [9, ea@gmail.com, 4, 4, Diber]
         */
    }
}
